package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * This class handles materials needed for a raised roof on the carport. The
 * exposed method returns a PartslistModel with the items, which are then
 * appended to the 'master list' ("bill of materials").
 *
 * @see PartslistModel
 * @author
 */
public class RoofRaisedCalc {

    //<editor-fold defaultstate="collapsed" desc="INSTANCE FIELDS">
    DataFacade DAO;
    int bracketCount;
    int screwCount;
    int rafterCount;
    int lathRowCount;
    int intersectionCount;
    int tileCount;
    int topTileCount;
    int roofOverhang;
    int claddingBoardsTotal;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HARDCODED MATERIALS USED">
    final int screwPacks = 20; // 4,5x60mm. Skruer (200 stk)
    final int roofTileBrackets = 32; // B & C tagstens binder/nakkekrog (kombi)
    final int roofTileBlack = 33; // B & C Dobbelt Tagsten (Sort)
    final int roofTileGrey = 34; // B & C Dobbelt Tagsten (Grå)
    final int roofTileOrange = 35; // Eternit Tagsten(Teglrød)
    final int roofTileRed = 36; // B & C Dobbelt Tagsten (Rød)
    final int roofTileBlue = 37; // B & C Dobbelt Tagsten (Blå)
    final int roofTileBlackBlue = 38; // B & C Dobbelt Tagsten (Sortblå)
    final int roofTileSunlux = 39; // B & C Dobbelt Tagsten (Sunlux)
    final int roofTopTileBlack = 40; // B & C Rygsten (Sort)
    final int roofTopTileGrey = 41; // B & C Rygsten Tagsten (Grå)
    final int roofTopTileOrange = 42; // Eternit Rygsten (Teglrød)
    final int roofTopTileRed = 43; // B & C Rygsten (Rød)
    final int roofTopTileBlue = 44; // B & C Rygsten (Blå)
    final int roofTopTileBlackBlue = 45; // B & C Rygsten (Sortblå)
    final int roofTopTileSunlux = 46; // B & C Rygsten (Sunlux)
    final int topLathBracket = 30;  // B & C Toplægte holder
    final int rafterWood2400 = 6; // 45x95 Reglar ubh. 2400
    final int rafterWood3600 = 7; // 45x95 Reglar ubh. 3600
    final int fasciaWood4800 = 1; // 25x150mm trykimp. Bræt 4800
    final int fasciaWood5400 = 2; // 25x150mm. trykimp. Bræt 5400
    final int fasciaWood6000 = 3; // 25x150mm. trykimp. Bræt 6000
    final int lathWood5400 = 12; // 38x73 mm. taglægte T1 5400
    final int lathWood4200 = 13; // 38x73 mm. taglægte T1 4200
    final int claddingWood4800 = 8; // 19x100mm. trykimp. Bræt 4800
    final int claddingWood2400 = 9; // 19x100mm. trykimp. Bræt 2400
    final int claddingWood2100 = 10; // 19x100mm. trykimp. Bræt 2100
    final String helptext = "roof"; // Used to grab the right helptext from database.
    //</editor-fold>

    /**
     * Constructor, instantiates all instance fields.
     */
    public RoofRaisedCalc() {
        DAO = DataFacadeImpl.getInstance();
        bracketCount = 0;
        screwCount = 0;
        rafterCount = 0;
        lathRowCount = 0;
        intersectionCount = 0;
        tileCount = 0;
        topTileCount = 0;
        roofOverhang = 600;
        claddingBoardsTotal = 0;
    }

    /**
     * Exposed method of this class. Gathers PartslistModel's from protedted
     * methods add's screws to the final PartslistModel and returns the final
     * PartslistModel.
     *
     * @param order
     * @return PartslistModel roofRaisedBOM
     * @throws DataException
     * @throws data.exceptions.AlgorithmException
     */
    public PartslistModel getRoofRaisedMaterials(OrderModel order) throws DataException, AlgorithmException {
        if (order == null || order.getLength() <= 0 || order.getWidth() <= 0 || order.getIncline() <= 0) {
            throw new AlgorithmException("Ordren er ikke udfyldt korrekt. Der bliver muligvis divideret med 0 eller der er indtastet felter med værdier på 0 eller mindre.");
        }
        PartslistModel roofRaisedBOM = new PartslistModel();

        roofRaisedBOM.addPartslist(getRoofTiles(order));
        roofRaisedBOM.addPartslist(getRoofStructure(order));
        roofRaisedBOM.addPartslist(generateCladding(order));
        roofRaisedBOM.addPartslist(getScrews());
        updateFieldsinBOM(roofRaisedBOM);

        return roofRaisedBOM;
    }

    /**
     * Updates the fileds in the PartslistModel
     *
     * @param finalRoofBOM
     */
    protected void updateFieldsinBOM(PartslistModel finalRoofBOM) {
        finalRoofBOM.setLathRowCount(lathRowCount);
        finalRoofBOM.setRafterCount(rafterCount);
        finalRoofBOM.setTileCount(tileCount);
        finalRoofBOM.setTopTileCount(topTileCount);
    }

    /**
     * Calculates amount of screws needed for the entire roof, adds them to a
     * Partslist and returns it.
     *
     * @return PartslistModel
     * @throws DataException
     */
    protected PartslistModel getScrews() throws DataException, AlgorithmException {
        if (screwCount < 1) {
            throw new AlgorithmException("ScrewCounter is less than 1");
        }
        PartslistModel screwBOM = new PartslistModel();
        int screwsPrPack = 200;
        int totalScrewPacks = (int) Math.ceil((double) screwCount / (double) screwsPrPack);
        MaterialModel material = DAO.getMaterial(screwPacks, helptext);

        material.setQuantity(totalScrewPacks);
        screwBOM.addMaterial(material);

        return screwBOM;
    }

    /**
     * Takes in the order provided by the exposed method and gathers the order
     * info needed to calculate the amount of rooftiles, toprooftiles and
     * fasteners. The calculated materials are returned in a PartslistModel.
     *
     * Hardcoded material is one of a kind in the database.
     *
     * @param order
     * @return PartslistModel
     * @throws DataException
     */
    protected PartslistModel getRoofTiles(OrderModel order) throws DataException {
        PartslistModel roofTilesBOM = new PartslistModel();

        int tileLength = DAO.getMaterial(order.getRoof_tiles_id(), helptext).getLength();
        int tileWidth = DAO.getMaterial(order.getRoof_tiles_id(), helptext).getWidth();
        int totalWidth = order.getWidth() + roofOverhang;
        double angleRad = Math.toRadians(order.getIncline());
        double adjacentCath = totalWidth * 0.5;
        double hypotenuse = (adjacentCath / Math.cos(angleRad));
        //<editor-fold defaultstate="collapsed" desc="COMMENTS">
        /*
        topLathDist is the distance from the rooftop to the highest lath, determinded
        by FOG
        
        remaningRoofWidth is the roof width when the distance from the rooftop 
        to the highest lath is removed. The hypotenuse is used since the roof 
        has an incline in order to get the correct width. 
        
        the whileloop calculates the the amount of rows of rooftiles
        
        tileRowLength is the total length of all rooftiles
         */
        //</editor-fold>
        int topLathDist = 30;
        int tileRowCount = 0;
        int tileRowLength = 0;
        int remaningRoofWidth = (int) Math.ceil(hypotenuse) - (topLathDist);

        while (remaningRoofWidth > 0) {
            tileRowCount = tileRowCount + 1;
            remaningRoofWidth = remaningRoofWidth - tileLength;
        }

        tileRowLength = (order.getLength() * tileRowCount) * 2;
        tileCount = (int) Math.ceil((double) tileRowLength / (double) tileWidth);
        MaterialModel materialTiles = DAO.getMaterial(order.getRoof_tiles_id(), helptext);

        materialTiles.setQuantity(tileCount);
        roofTilesBOM.addMaterial(materialTiles);

        MaterialModel materialTopTiles = DAO.getMaterial(getTopRoofTileID(order), helptext);

        topTileCount = (int) Math.ceil((double) order.getLength() / (double) materialTopTiles.getLength());

        materialTopTiles.setQuantity(topTileCount);
        roofTilesBOM.addMaterial(materialTopTiles);

        MaterialModel materialBinders = DAO.getMaterial(roofTileBrackets, helptext);
        materialBinders.setQuantity(2);
        roofTilesBOM.addMaterial(materialBinders);

        return roofTilesBOM;
    }

    /**
     * Takes in the order provided by getRoofTiles() method and returns an int
     * representing the id in the database for the corresponding rooftoptiles.
     *
     * When/if the order in the database is changed to take this into account,
     * this method can be removed.
     *
     * @param order
     * @return int roofTopID
     * @throws DataException
     */
    protected int getTopRoofTileID(OrderModel order) throws DataException {
        int roofTopID;
        int normalTileID = DAO.getMaterial(order.getRoof_tiles_id(), helptext).getID();
        switch (normalTileID) {
            case roofTileBlack:
                roofTopID = roofTopTileBlack;
                break;
            case roofTileGrey:
                roofTopID = roofTopTileGrey;
                break;
            case roofTileOrange:
                roofTopID = roofTopTileOrange;
                break;
            case roofTileRed:
                roofTopID = roofTopTileRed;
                break;
            case roofTileBlue:
                roofTopID = roofTopTileBlue;
                break;
            case roofTileBlackBlue:
                roofTopID = roofTopTileBlackBlue;
                break;
            case roofTileSunlux:
                roofTopID = roofTopTileSunlux;
                break;
            default:
                roofTopID = roofTopTileBlack;
                break;
        }
        return roofTopID;
    }

    /**
     * Takes in the order provided by the exposed method and gathers the order
     * info needed to calculate the amount of rafters, laths, fasciaborads and
     * fasteners. The calculated materials are returned in a PartslistModel.
     * Class field rafterCount is updated.
     *
     * @param order
     * @return PartslistModel
     * @throws DataException
     */
    protected PartslistModel getRoofStructure(OrderModel order) throws DataException, AlgorithmException {
        PartslistModel roofStructureBOM = new PartslistModel();
        rafterCount = 2;
        int totalWidth = order.getWidth() + roofOverhang;
        int rafterWidth = 45;
        int rafterSpace = 900;
        int remainderLength = order.getLength() - (2 * rafterWidth);

        rafterCount = rafterCount + (int) Math.ceil((double) remainderLength / (double) (rafterSpace + rafterWidth));

        MaterialModel material = DAO.getMaterial(topLathBracket, helptext);

        for (int i = 0; i < rafterCount; i++) {
            addPartslistWithMaterialsQuantity(generateRafter(totalWidth, order.getIncline()), roofStructureBOM);
        }

        material.setQuantity(rafterCount);
        roofStructureBOM.addMaterial(material);
        addPartslistWithMaterialsQuantity(generateLaths(order.getLength(), totalWidth, order.getIncline()), roofStructureBOM);
        addPartslistWithMaterialsQuantity(generatefasciaBoards(totalWidth, order.getIncline(), order.getLength()), roofStructureBOM);
        return roofStructureBOM;
    }

    /**
     * This method takes in an ArrayList of materials and a length, sorts the
     * list and then calculates the amount of the longest material needed to
     * cover the given length. The calculated materials are added to the
     * PartslistModel, which is then returned.
     *
     * The metod was supposed to be able to switch to use the shorter materials
     * in the given list when the remaining length is shorter than the longest
     * material, but that feature has not yet been implemented.
     *
     * @param materials
     * @param length
     * @return PartslistModel
     * @throws data.exceptions.AlgorithmException
     */
    protected PartslistModel getMaterialsFromlength(ArrayList<MaterialModel> materials, int length) throws AlgorithmException {
        if (materials.size() < 1 || materials.get(0).getLength() < 1) {
            throw new AlgorithmException("Materialelisten indeholder ingen materialer eller indeholder materialer uden længde.");
        }

        PartslistModel calcParts = new PartslistModel();
        //<editor-fold defaultstate="collapsed" desc="SORT COMMENT">
        /*
        The materials list is sorted so that the longest material is at index 0. 
        The calculation below depends on this list being sorted in a descending 
        order.  
         */
        //</editor-fold>
        Collections.sort(materials, new Comparator<MaterialModel>() {
            @Override
            public int compare(MaterialModel o1, MaterialModel o2) {
                if (o1.getLength() < o2.getLength()) {
                    return 1;
                } else if (o1.getLength() > o2.getLength()) {
                    return -1;
                }
                return 0;
            }
        });

        //<editor-fold defaultstate="collapsed" desc="MAP COMMENT">
        /*
        The quantityPrMaterial map holds all the materials with an Integer representing
        the quantity for the given material. All quantityrepresentations is set 
        to 0 at the beginning. 
         */
        //</editor-fold>
        HashMap<MaterialModel, Integer> quantityPrMaterial = new HashMap();
        for (MaterialModel material : materials) {
            quantityPrMaterial.put(material, 0);
        }

        int restLength = length;
        double ratioBest = -1;
        MaterialModel bestMaterial = null;

        //<editor-fold defaultstate="collapsed" desc="RATIO COMMENT">
        /*
        The ratioBest is an integer representing how close to 1 the division 
        restLength/material.getLength is. If this division equals 1, then 
        the length of the material is the same as the restLength, meaning 1
        material is enough to cover the length. 
        If the numer is greater than 1 it means that theres is more restLength 
        than 1 material can cover. 
        If the number is less than 1 the restLength is shorter than the material
        length. 
        In the loop the ratioCurrent is calculated for the given material. 
        
        The ratioBest is the ratio of the best material for a given length.
        
         */
        //</editor-fold>
        while (restLength > 0) {
            for (MaterialModel material : materials) {
                double ratioCurrent = (double) restLength / (double) material.getLength();

                //<editor-fold defaultstate="collapsed" desc="IF-ELSE COMMENT">
                /*
                The ratioBest starts at -1 for each iteration of this inner loop
                and when it's -1 we assume that the given material is the best
                material for the length, so bestMaterial is set to this and the
                ratioBest is set to the ratioCurrent for this material. 
                
                When the ratioBest is not -1 we assume that there already is a
                material in bestMaterial i.e. we assume that we are not looking 
                at the first material in the list. 
                
                Now we have to find out if the material in materialBest is really 
                the best or if the current material is better. This is done in the
                two else if's (one checks for ratios over 1 and the other checks 
                for ratios under 1).
                
                RatioBest is always overwitten with the ratio thats closest
                to 1 - then we check if ratioBest is the same as ratioCurrent. If
                that's true we know that ratioCurrent was closer to 1 than ratioBest
                and we set the current material to be the bestMaterial. 
                
                In the case where ratioBest is bigger than 1 and ratioCurrent is 
                less than 1 the best material will be the one already stored in 
                bestMaterial as this will cover the remaining length. 
                
                The case where ratioBest is less than 1 and ratioCurrent is 
                bigger than 1 will never occur because the list is sorted by 
                material.getLength descending. 
                 */
                //</editor-fold>
                if (ratioBest == -1) {
                    ratioBest = ratioCurrent;
                    bestMaterial = material;
                } else if (ratioBest >= 1 && ratioCurrent >= 1) {
                    ratioBest = Math.min(ratioBest, ratioCurrent);
                    if (ratioBest == ratioCurrent) {
                        bestMaterial = material;
                    }
                } else if (ratioBest < 1 && ratioCurrent < 1) {
                    ratioBest = Math.max(ratioBest, ratioCurrent);
                    if (ratioBest == ratioCurrent) {
                        bestMaterial = material;
                    }
                }
            }
            //<editor-fold defaultstate="collapsed" desc="MATERIAL QUANTITY COMMENT">
            /*
            After the inner loop the best material for the given length have been
            found. Now we need to find out how many of the materials we need and 
            remember that for later. 
            
            If the ratioBest is 1 or bigger, we need the amount of material equal 
            to the floored version of that number. We don't care about the remainder, 
            as there might be a better material for the remainder.
            If the ratioBest is less than 1, we know that all the materials are longer 
            than the given length. So we only need one of the best materials for
            this length so we ceil the ratioBest (that always returns 1 in this case). 
            
            If the bestMaterial for the given length already have been chosen as 
            the best material before (and thereby have a quantity bigger than 0) 
            we don't want to overwrite that - so we set exsistingAmount to what
            was stored in the map for that material.
            Then the bestMaterial is added back to the map with the updated quantity.
            
            The length of all the bestMaterial is subtrackted from the restLength
            and the ratioBest is reset to -1.
            */
            //</editor-fold>
            int materialAmount = 0;
            if (ratioBest >= 1) {
                materialAmount = (int) Math.floor(ratioBest);
            }
            if (ratioBest < 1) {
                materialAmount = (int) Math.ceil(ratioBest);
            }
            int exsistingAmount = quantityPrMaterial.get(bestMaterial);
            quantityPrMaterial.put(bestMaterial, exsistingAmount + materialAmount);
            restLength = restLength - (bestMaterial.getLength() * materialAmount);
            ratioBest = -1;
        }
        
        //<editor-fold defaultstate="collapsed" desc="PARTSLIST COMMENT">
            /*
            When the while-loop is done we know we have found the best materials
            for the original length at the start of this method. 
        
            Now the materials with their qunatities just have to be added to the
            partslist. To do that we look at the map and add all materials that 
            have a value greater than 0.
            */
            //</editor-fold>

        for (MaterialModel material : materials) {
            int quantity = quantityPrMaterial.get(material);
            if (quantity > 0) {
                material.setQuantity(quantityPrMaterial.get(material));
                calcParts.addMaterial(material);
            }
        }
        return calcParts;
    }

    /**
     * This method is used when several partslists containing the same materials
     * are added together, to ensure the quantity is updated correctly and only
     * one MaterialModel is added pr. material.
     *
     * It takes in the partslist calculated by the other methods and the
     * partslist the calling method wants to return.
     *
     * @param calcBOM
     * @param returnBOM
     */
    protected void addPartslistWithMaterialsQuantity(PartslistModel calcBOM, PartslistModel returnBOM) {
        ArrayList<MaterialModel> calcList = calcBOM.getBillOfMaterials();
        ArrayList<MaterialModel> returnList = returnBOM.getBillOfMaterials();

        for (int i = 0; i < calcList.size(); i++) {
            if (returnList.isEmpty()) {
                returnBOM.addMaterial(new MaterialModel(calcList.get(i)));
                continue;
            }

            boolean quantityAdded = false;
            for (int j = 0; j < returnList.size(); j++) {

                if (calcList.get(i).getID() == returnList.get(j).getID()) {
                    int qunatity = returnList.get(j).getQuantity() + calcList.get(i).getQuantity();
                    returnList.get(j).setQuantity(qunatity);
                    returnBOM.setTotalprice((calcList.get(i).getQuantity() * (int) Math.ceil(returnList.get(j).getPrice())) + returnBOM.getTotalprice());
                    quantityAdded = true;
                }
            }
            if (quantityAdded == false) {
                returnBOM.addMaterial(new MaterialModel(calcList.get(i)));
            } else {
                quantityAdded = false;
            }
        }
    }

    /**
     *
     * Calculates the length of the different parts of a single rafter and calls
     * getMaterialsFromlength() with the length and the ArrayList of
     * raftermaterials. Class fields screwCount and bracketCount is updated.
     *
     * The hardcoded materials are the only materials used for rafters as of
     * now.
     *
     * @param totalWidth
     * @param incline
     * @return PartslistModel
     * @throws DataException
     * @throws data.exceptions.AlgorithmException
     */
    protected PartslistModel generateRafter(int totalWidth, int incline) throws DataException, AlgorithmException {
        PartslistModel rafterBOM = new PartslistModel();

        double angleRad = Math.toRadians(incline);
        double adjacentCath = totalWidth * 0.5;
        double hypotenuse = (adjacentCath / Math.cos(angleRad));
        double oppositeCath = (Math.sin(angleRad) * hypotenuse);

        ArrayList<MaterialModel> materials = new ArrayList();
        materials.add(DAO.getMaterial(rafterWood2400, helptext));
        materials.add(DAO.getMaterial(rafterWood3600, helptext));

        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, totalWidth), rafterBOM);
        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, (int) Math.ceil(hypotenuse)), rafterBOM);
        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, (int) Math.ceil(hypotenuse)), rafterBOM);
        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, (int) Math.ceil(oppositeCath)), rafterBOM);

        bracketCount = bracketCount + 6;
        screwCount = screwCount + (4 * 6);

        return rafterBOM;
    }

    /**
     * Calculates the length of the different parts of the fascia boards and
     * getMaterialsFromlength() with the length and the ArrayList of
     * fasciamaterials. Class fields screwCount and bracketCount is updated.
     *
     * The hardcoded materials are the only materials used for rafters as of
     * now.
     *
     * @param orderLength
     * @param totalWidth
     * @param incline
     * @return PartslistModel
     * @throws DataException
     * @throws data.exceptions.AlgorithmException
     */
    protected PartslistModel generatefasciaBoards(int totalWidth, int incline, int orderLength) throws DataException, AlgorithmException {
        PartslistModel fasciaBOM = new PartslistModel();

        double angleRad = Math.toRadians(incline);
        double adjacentCath = totalWidth * 0.5;
        double hypotenuse = (adjacentCath / Math.cos(angleRad));

        ArrayList<MaterialModel> materials = new ArrayList();
        materials.add(DAO.getMaterial(fasciaWood4800, helptext));
        materials.add(DAO.getMaterial(fasciaWood5400, helptext));
        materials.add(DAO.getMaterial(fasciaWood6000, helptext));

        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, (int) Math.ceil(hypotenuse)), fasciaBOM);
        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, (int) Math.ceil(hypotenuse)), fasciaBOM);
        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, (int) Math.ceil(orderLength)), fasciaBOM);
        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, (int) Math.ceil(orderLength)), fasciaBOM);

        return fasciaBOM;
    }

    /**
     * Calculates the length of the different parts of all the laths and calls
     * getMaterialsFromlength() with the length and the ArrayList of
     * lathmaterials. Class fields screwCount, intersectionCount, lathRowCount
     * and rafterCount is updated.
     *
     * The hardcoded materials are the only materials used for laths as of now.
     *
     * @param orderLength
     * @param totalWidth
     * @param incline
     * @return PartslistModel
     * @throws DataException
     * @throws data.exceptions.AlgorithmException
     */
    protected PartslistModel generateLaths(int orderLength, int totalWidth, int incline) throws DataException, AlgorithmException {
        PartslistModel lathsBOM = new PartslistModel();
        double angleRad = Math.toRadians(incline);
        double adjacentCath = totalWidth * 0.5;
        double hypotenuse = (adjacentCath / Math.cos(angleRad));

        // der er altid mindts 3 rækker af lægter pr tagside (de to yderste og én nærmest toplægten)
        lathRowCount = 3;
        int outerLathDist = 350;
        int upperLathDist = 30;
        int minimumLathDist = 307;

        // tagvidde når afstanden fra tagtoppen øverste lægte og afstanden mellem de to yderste lægter er trukket fra
        int roofSideWidth = (int) Math.ceil(hypotenuse) - (outerLathDist + upperLathDist);
        // beregn antal af rækker af lægter
        lathRowCount = lathRowCount + (int) Math.floor((double) roofSideWidth / (double) minimumLathDist);
        // total længde af alle lægter lagt sammen + 1 toplægte
        int totalLathsLength = ((orderLength * lathRowCount) * 2) + orderLength;
        // antal af lægter i alt (begge sider af taget + toplægte

        lathRowCount = (lathRowCount * 2) + 1;

        intersectionCount = lathRowCount * rafterCount;
        screwCount = screwCount + (intersectionCount * 2);

        ArrayList<MaterialModel> materials = new ArrayList();
        materials.add(DAO.getMaterial(lathWood5400, helptext));
        materials.add(DAO.getMaterial(lathWood4200, helptext));

        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, totalLathsLength), lathsBOM);

        return lathsBOM;
    }

    /**
     * Takes in the order provided by the exposed method and gathers the order
     * info needed to calculate the amount of cladding and then calls
     * getCladdingMaterialCount(). The calculated materials are returned in a
     * PartslistModel.
     *
     * Class fields screwCount is updated.
     *
     * @param order
     * @return PartslistModel
     * @throws DataException
     * @throws data.exceptions.AlgorithmException
     */
    protected PartslistModel generateCladding(OrderModel order) throws DataException, AlgorithmException {

        PartslistModel claddingBOM = new PartslistModel();
        int totalWidth = order.getWidth() + roofOverhang;
        int totalCladdingLengthFront = (getCladdingMaterialCount(totalWidth, order.getIncline(), 0) + getCladdingMaterialCount(totalWidth, order.getIncline(), 8)) * 2;
        int totalCladdingLengthBack = (getCladdingMaterialCount(totalWidth, order.getIncline(), 0) + getCladdingMaterialCount(totalWidth, order.getIncline(), 8)) * 2;
        int totalCladdingLengh = totalCladdingLengthFront + totalCladdingLengthBack;
        claddingBoardsTotal = claddingBoardsTotal * 4;

        ArrayList<MaterialModel> materials = new ArrayList();
        materials.add(DAO.getMaterial(claddingWood4800, helptext));
        materials.add(DAO.getMaterial(claddingWood2400, helptext));
        materials.add(DAO.getMaterial(claddingWood2100, helptext));
        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, totalCladdingLengh), claddingBOM);

        screwCount = screwCount + (claddingBoardsTotal * 4);
        return claddingBOM;
    }

    /**
     * This method calculates the amount of claddingmaterial needed for a given
     * carport and returns it.
     *
     * The method uses basic trigonometry to calculate the height for each board
     * and checks if the lengt of the board is less than the length of the given
     * material.
     *
     * The amount is increased when the height of the board is greater than the
     * remaining length of the material.
     *
     *
     * @param totalWidth
     * @param incline
     * @param offset
     * @return int amountMaterial
     * @throws DataException
     */
    protected int getCladdingMaterialCount(int totalWidth, int incline, int offset) throws DataException {
        int materialWidth = 100;
        int spaceWidth = 60;
        int cladWidth = offset;
        double angleRad = Math.toRadians(incline);
        double startAdjacentCath = totalWidth * 0.5;
        int totalCladdingLengthPrSidePrOffset = 0;

        for (int i = cladWidth; i < startAdjacentCath; i = cladWidth) {
            cladWidth = cladWidth + materialWidth;

            double hypotenuse = (cladWidth / Math.cos(angleRad));
            double oppositeCath = (Math.sin(angleRad) * hypotenuse);
            totalCladdingLengthPrSidePrOffset = totalCladdingLengthPrSidePrOffset + (int) Math.ceil(oppositeCath);

            cladWidth = cladWidth + spaceWidth;
            claddingBoardsTotal++;
        }
        return totalCladdingLengthPrSidePrOffset;
    }
}
