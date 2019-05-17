package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.DataException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
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
    //</editor-fold>

    /**
     * Class-constructor, instantiates all instance fields.
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
     * @return PartslistModel
     * @throws DataException
     */
    public PartslistModel getRoofRaisedMaterials(OrderModel order) throws DataException {
        PartslistModel roofRaisedBOM = new PartslistModel();

        roofRaisedBOM.addPartslist(getRoofTiles(order));
        roofRaisedBOM.addPartslist(getRoofStructure(order));
        roofRaisedBOM.addPartslist(getCladding(order));
        roofRaisedBOM.addPartslist(getScrews());
        updateFieldsinBOM(roofRaisedBOM);

        return roofRaisedBOM;
    }

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
    protected PartslistModel getScrews() throws DataException {

        PartslistModel screwBOM = new PartslistModel();
        int screwsPrPack = 200;
        int totalScrewPacks = (int) Math.ceil((double) screwCount / (double) screwsPrPack);
        MaterialModel material = DAO.getMaterial(screwPacks);

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

        int tileLength = DAO.getMaterial(order.getRoof_tiles_id()).getLength();
        int tileWidth = DAO.getMaterial(order.getRoof_tiles_id()).getWidth();
        int totalWidth = order.getWidth() + roofOverhang;
        double angleRad = Math.toRadians(order.getIncline());
        double adjacentCath = totalWidth * 0.5;
        double hypotenuse = (adjacentCath / Math.cos(angleRad));
        int topLathDist = 30;
        int tileRowCount = 0;
        int tileRowLength = 0;

        // tagvidde når afstanden fra tagtoppen øverste lægte
        int remaningRoofWidth = (int) Math.ceil(hypotenuse) - (topLathDist);

        // beregn antal rækker tagsten
        while (remaningRoofWidth > 0) {
            tileRowCount = tileRowCount + 1;
            remaningRoofWidth = remaningRoofWidth - tileLength;
        }

        // total længde af alle tagsten lagt sammen
        tileRowLength = (order.getLength() * tileRowCount) * 2;
        tileCount = (int) Math.ceil((double) tileRowLength / (double) tileWidth);

        MaterialModel materialTiles = DAO.getMaterial(order.getRoof_tiles_id());

        materialTiles.setQuantity(tileCount);
        roofTilesBOM.addMaterial(materialTiles);

        MaterialModel materialTopTiles = DAO.getMaterial(getTopRoofTileID(order));
        topTileCount = (int) Math.ceil((double) order.getLength() / (double) materialTopTiles.getLength());

        materialTopTiles.setQuantity(topTileCount);
        roofTilesBOM.addMaterial(materialTopTiles);

        MaterialModel materialBinders = DAO.getMaterial(roofTileBrackets); // tagstenbinder/nakkekrog
        materialBinders.setQuantity(1);
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
        int normalTileID = DAO.getMaterial(order.getRoof_tiles_id()).getID();
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
    protected PartslistModel getRoofStructure(OrderModel order) throws DataException {
        PartslistModel roofStructureBOM = new PartslistModel();
        rafterCount = 2;
        int totalWidth = order.getWidth() + roofOverhang;
        int rafterWidth = 45;
        int rafterSpace = 900;
        int remainderLength = order.getLength() - (2 * rafterWidth);

        rafterCount = rafterCount + (int) Math.ceil((double) remainderLength / (double) (rafterSpace + rafterWidth));

        MaterialModel material = DAO.getMaterial(topLathBracket);

        for (int i = 0; i < rafterCount; i++) {
            addPartslistWithMaterialsQuantity(generateRafter(totalWidth, order.getIncline()), roofStructureBOM);
        }

        material.setQuantity(rafterCount);
        roofStructureBOM.addMaterial(material);
        addPartslistWithMaterialsQuantity(generateLaths(order.getLength(), totalWidth, order.getIncline()), roofStructureBOM);
        addPartslistWithMaterialsQuantity(generatefasciaBoards(totalWidth, order.getIncline(), order.getLength()), roofStructureBOM);
        System.out.println("screwa " + screwCount);
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
     */
    protected PartslistModel getMaterialsFromlength(ArrayList<MaterialModel> materials, int length) {
        PartslistModel calcParts = new PartslistModel();
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

        HashMap<MaterialModel, Integer> quantityPrMaterial = new HashMap();
        for (MaterialModel material : materials) {
            quantityPrMaterial.put(material, 0);
        }

        int restLength = length;
        double ratioBest = -1;
        MaterialModel bestMaterial = null;

        while (restLength > 0) {
            for (MaterialModel material : materials) {
                double ratioCurrent = (double) restLength / (double) material.getLength();

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

//        for (MaterialModel material : materials) {
//            if (length < 1) {
//                break;
//            }
//
//            int amountLongest = (int) Math.ceil(((double) length / (double) material.getLength()));
//            int remainder = length - material.getLength() * amountLongest;
//
//            for (int i = 0; i < amountLongest; i++) {
//                int quantityCount = quantityPrMaterial.get(material);
//                quantityCount = quantityCount + 1;
//                quantityPrMaterial.put(material, quantityCount);
//
//                length = length - material.getLength();
//            }
//            if (remainder > 0) {
//                length = remainder;
//            }
//        }
        for (MaterialModel material : materials) {
            int quantity = quantityPrMaterial.get(material);
            if (quantity > 0) {
                material.setQuantity(quantityPrMaterial.get(material));
                calcParts.addMaterial(material);
            }
        }
//        System.out.println("***************************************");
//        System.out.println("Order Length: " + length);
//        for (int i = 0; i < calcParts.getBillOfMaterials().size(); i++) {
//            System.out.println("***");
//            System.out.println("Material ID: " + calcParts.getBillOfMaterials().get(i).getID());
//            System.out.println("Material Quantity: " + calcParts.getBillOfMaterials().get(i).getQuantity());
//            System.out.println("Length of same materials combined: " + calcParts.getBillOfMaterials().get(i).getLength()*calcParts.getBillOfMaterials().get(i).getQuantity());
//            
//        }
//        System.out.println("***************************************");

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
     */
    protected PartslistModel generateRafter(int totalWidth, int incline) throws DataException {
        PartslistModel rafterBOM = new PartslistModel();

        double angleRad = Math.toRadians(incline);
        double adjacentCath = totalWidth * 0.5;
        double hypotenuse = (adjacentCath / Math.cos(angleRad));
        double oppositeCath = (Math.sin(angleRad) * hypotenuse);

        ArrayList<MaterialModel> materials = new ArrayList();
        materials.add(DAO.getMaterial(rafterWood2400));
        materials.add(DAO.getMaterial(rafterWood3600));

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
     */
    protected PartslistModel generatefasciaBoards(int totalWidth, int incline, int orderLength) throws DataException {
        PartslistModel fasciaBOM = new PartslistModel();

        double angleRad = Math.toRadians(incline);
        double adjacentCath = totalWidth * 0.5;
        double hypotenuse = (adjacentCath / Math.cos(angleRad));

        ArrayList<MaterialModel> materials = new ArrayList();
        materials.add(DAO.getMaterial(fasciaWood4800));
        materials.add(DAO.getMaterial(fasciaWood5400));
        materials.add(DAO.getMaterial(fasciaWood6000));

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
     */
    protected PartslistModel generateLaths(int orderLength, int totalWidth, int incline) throws DataException {
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
        materials.add(DAO.getMaterial(lathWood5400));
        materials.add(DAO.getMaterial(lathWood4200));
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
     */
    protected PartslistModel getCladding(OrderModel order) throws DataException {

        PartslistModel claddingBOM = new PartslistModel();
//        MaterialModel material = DAO.getMaterial(8);
        int totalWidth = order.getWidth() + roofOverhang;

//        int amountMaterial = getCladdingMaterialCount(totalWidth, order.getIncline(), 0, material.getWidth(), material.getLength())
//                + getCladdingMaterialCount(totalWidth, order.getIncline(), 8, material.getWidth(), material.getLength());
        int totalCladdingLengh = (NEWgetCladdingMaterialCount(totalWidth, order.getIncline(), 0) + NEWgetCladdingMaterialCount(totalWidth, order.getIncline(), 8)) * 2;
        claddingBoardsTotal = claddingBoardsTotal * 2;
        
        ArrayList<MaterialModel> materials = new ArrayList();
        materials.add(DAO.getMaterial(8));
        materials.add(DAO.getMaterial(9));
        materials.add(DAO.getMaterial(10));
        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, totalCladdingLengh), claddingBOM);
        
//        amountMaterial = amountMaterial * 2;
//        material.setQuantity(amountMaterial);
//        claddingBOM.addMaterial(material);
        screwCount = screwCount * claddingBoardsTotal * 4;

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
     * @param materialWidth
     * @param materialLength
     * @return int amountMaterial
     * @throws DataException
     */
    protected int getCladdingMaterialCount(int totalWidth, int incline, int offset, int materialWidth, int materialLength) throws DataException {
        int materialLengthStart = materialLength;
        int spaceWidth = 60;
        int cladWidth = offset;
        double angleRad = Math.toRadians(incline);
        double startAdjacentCath = totalWidth * 0.5;
        int amountMaterial = 1;

        for (int i = cladWidth; i < startAdjacentCath; i = cladWidth) {
            cladWidth = cladWidth + materialWidth;

            double hypotenuse = (cladWidth / Math.cos(angleRad));
            double oppositeCath = (Math.sin(angleRad) * hypotenuse);

            if (oppositeCath > materialLength) {
                amountMaterial = amountMaterial + 1;
                materialLength = materialLengthStart;
            }
            materialLength = materialLength - (int) Math.ceil(oppositeCath);
            cladWidth = cladWidth + spaceWidth;
        }
        return amountMaterial;
    }
    
    protected int NEWgetCladdingMaterialCount(int totalWidth, int incline, int offset) throws DataException {
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
