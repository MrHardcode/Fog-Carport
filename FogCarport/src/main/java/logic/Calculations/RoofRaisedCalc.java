package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.LoginException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author Camilla
 */
public class RoofRaisedCalc {

    DataFacade DAO;
    int bracketCount;
    int screwCount;
    int rafterCount;
    int lathRowCount;
    int intersectionCount;
    int tileCount;
    int topTileCount;

    /**
     *
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
    }

    /**
     * Exposed method of this class. Gathers PartslistModel's from protedted
     * methods add's screws to the final PartslistModel and returns the final
     * PartslistModel.
     *
     * @param order
     * @return PartslistModel
     * @throws LoginException
     */
    public PartslistModel getRoofRaisedMaterials(OrderModel order) throws LoginException {
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
     */
    protected PartslistModel getScrews() throws LoginException {

        PartslistModel screwBOM = new PartslistModel();
        int screwPacks = (int) Math.ceil((double) screwCount / (double) 200);
        MaterialModel material = DAO.getMaterial(20);
        
        material.setQuantity(screwPacks);
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
     * @throws LoginException
     */
    protected PartslistModel getRoofTiles(OrderModel order) throws LoginException {
        PartslistModel roofTilesBOM = new PartslistModel();

        int tileLength = DAO.getMaterial(order.getRoof_tiles_id()).getLength();
        int tileWidth = DAO.getMaterial(order.getRoof_tiles_id()).getWidth();
        int totalWidth = order.getWidth() + 600;
        double angleRad = Math.toRadians(order.getIncline());
        double adjacentCath = totalWidth * 0.5;
        double hypotenuse = (adjacentCath / Math.cos(angleRad));

        int tileRowCount = 0;
        int tileRowLength = 0;

        // tagvidde når afstanden fra tagtoppen øverste lægte
        int remaningRoofWidth = (int) Math.ceil(hypotenuse) - (30);

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
                
        MaterialModel materialBinders = DAO.getMaterial(32); // tagstenbinder/nakkekrog
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
     * @throws LoginException
     */
    protected int getTopRoofTileID(OrderModel order) throws LoginException {
        int roofTopID = 40;
        int notmalTileID = DAO.getMaterial(order.getRoof_tiles_id()).getID();
        switch (notmalTileID) {
            case 33:
                roofTopID = 40;
                break;
            case 34:
                roofTopID = 41;
                break;
            case 35:
                roofTopID = 42;
                break;
            case 36:
                roofTopID = 43;
                break;
            case 37:
                roofTopID = 44;
                break;
            case 38:
                roofTopID = 45;
                break;
            case 39:
                roofTopID = 46;
                break;
            default:
                roofTopID = 40;
                break;
        }
        return roofTopID;
    }

    /**
     * Takes in the order provided by the exposed method and gathers the order
     * info needed to calculate the amount of rafters, laths and fasteners. The
     * calculated materials are returned in a PartslistModel. Class field
     * rafterCount is updated.
     *
     * @param order
     * @return PartslistModel
     * @throws LoginException
     */
    protected PartslistModel getRoofStructure(OrderModel order) throws LoginException {
        PartslistModel roofStructureBOM = new PartslistModel();
        rafterCount = 2;
        int totalWidth = order.getWidth() + 600;
        int rafterWidth = 45;
        int rafterSpace = 900;
        int remainderLength = order.getLength() - (2 * rafterWidth);

        rafterCount = rafterCount + (int) Math.ceil((double) remainderLength / (double) (rafterSpace + rafterWidth));

        MaterialModel material = DAO.getMaterial(30);
        for (int i = 0; i < rafterCount; i++) {
            addPartslistWithMaterialsQuantity(generateRafter(totalWidth, order.getIncline()), roofStructureBOM);
        }
        
        material.setQuantity(rafterCount); // toplægteholdere
        roofStructureBOM.addMaterial(material);
        addPartslistWithMaterialsQuantity(generateLaths(order.getLength(), totalWidth, order.getIncline()), roofStructureBOM);
        generatefasciaBoards(totalWidth, order.getIncline(), order.getLength());

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

        for (MaterialModel material : materials) {
            if (length < 1) {
                break;
            }

            int amountLongest = (int) Math.ceil(((double) length / (double) material.getLength()));
            int remainder = length - material.getLength() * amountLongest;

            for (int i = 0; i < amountLongest; i++) {
                int quantityCount = quantityPrMaterial.get(material);
                quantityCount = quantityCount + 1;
                quantityPrMaterial.put(material, quantityCount);

                length = length - material.getLength();
            }
            if (remainder > 0) {
                length = remainder;
            }
        }

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
     * @throws LoginException
     */
    protected PartslistModel generateRafter(int totalWidth, int incline) throws LoginException {
        PartslistModel rafterBOM = new PartslistModel();

        double angleRad = Math.toRadians(incline);
        double adjacentCath = totalWidth * 0.5;
        double hypotenuse = (adjacentCath / Math.cos(angleRad));
        double oppositeCath = (Math.sin(angleRad) * hypotenuse);

        ArrayList<MaterialModel> materials = new ArrayList();
        materials.add(DAO.getMaterial(6)); // length 2400 mm
        materials.add(DAO.getMaterial(7)); // length 3600 mm

        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, totalWidth), rafterBOM);
        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, (int) Math.ceil(hypotenuse)), rafterBOM);
        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, (int) Math.ceil(hypotenuse)), rafterBOM);
        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, (int) Math.ceil(oppositeCath)), rafterBOM);

        bracketCount = bracketCount + 6;
        screwCount = screwCount + (4 * 6);

        return rafterBOM;
    }

    protected void addPartslistWithMaterialsQuantity(PartslistModel calcBOM, PartslistModel returnBOM) {
        ArrayList<MaterialModel> calcList = calcBOM.getBillOfMaterials();
        ArrayList<MaterialModel> returnList = returnBOM.getBillOfMaterials();

        for (int i = 0; i < calcList.size(); i++) {
            if (returnList.isEmpty()) {
                returnBOM.addMaterial(new MaterialModel(calcList.get(i)));
                break;
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
     * @throws LoginException
     */
    protected PartslistModel generatefasciaBoards(int totalWidth, int incline, int orderLength) throws LoginException {
        PartslistModel fasciaBOM = new PartslistModel();

        double angleRad = Math.toRadians(incline);
        double adjacentCath = totalWidth * 0.5;
        double hypotenuse = (adjacentCath / Math.cos(angleRad));

        ArrayList<MaterialModel> materials = new ArrayList();
        materials.add(DAO.getMaterial(1)); // length 4800 mm
        materials.add(DAO.getMaterial(2)); // length 5400 mm
        materials.add(DAO.getMaterial(3)); // length 6000 mm

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
     * @throws LoginException
     */
    protected PartslistModel generateLaths(int orderLength, int totalWidth, int incline) throws LoginException {
        PartslistModel lathsBOM = new PartslistModel();

        // til hypotenuseberegning (hypotenuse = tagvidde)
        double angleRad = Math.toRadians(incline);
        double adjacentCath = totalWidth * 0.5;
        double hypotenuse = (adjacentCath / Math.cos(angleRad));

        // der er altid mindts 3 rækker af lægter 
        lathRowCount = 3;
        int lathsLength;

        // tagvidde når afstanden fra tagtoppen øverste lægte og afstanden mellem de to yderste lægter er trukket fra
        int roofSideWidth = (int) Math.ceil(hypotenuse) - (30 + 350);

        // beregn antal af rækker af lægter
        lathRowCount = lathRowCount + (int) Math.floor((double) roofSideWidth / (double) 307);

        // total længde af alle lægter lagt sammen + 1 toplægte
        lathsLength = ((orderLength * lathRowCount) * 2) + orderLength;

        intersectionCount = lathRowCount * rafterCount;
        screwCount = screwCount + (intersectionCount * 2);

        // lægte materialer
        ArrayList<MaterialModel> materials = new ArrayList();
        materials.add(DAO.getMaterial(12)); // length 5400 mm
        materials.add(DAO.getMaterial(13)); // length 4200 mm

        addPartslistWithMaterialsQuantity(getMaterialsFromlength(materials, lathsLength), lathsBOM);

        return lathsBOM;
    }

    /**
     * Takes in the order provided by the exposed method and gathers the order
     * info needed to calculate the amount of cladding and then calls
     * getCladdingMaterialCount(). The calculated materials are returned in a
     * PartslistModel.
     *
     * Hardcoded material is not accounted for in the order yet. When/if the
     * order in the database is changed to take this into account, this method
     * can be removed. method can be removed.
     *
     * Class fields screwCount is updated.
     *
     * @param order
     * @return
     * @throws LoginException
     */
    protected PartslistModel getCladding(OrderModel order) throws LoginException {

        PartslistModel claddingBOM = new PartslistModel();
        MaterialModel material = DAO.getMaterial(8);
        int totalWidth = order.getWidth() + 600;

        int amountMaterial = getCladdingMaterialCount(totalWidth, order.getIncline(), 0, material.getWidth(), material.getLength())
                + getCladdingMaterialCount(totalWidth, order.getIncline(), 8, material.getWidth(), material.getLength());
        amountMaterial = amountMaterial * 2;
        material.setQuantity(amountMaterial);
        claddingBOM.addMaterial(material);
        screwCount = (screwCount + 6) * amountMaterial;

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
     * @throws LoginException
     */
    protected int getCladdingMaterialCount(int totalWidth, int incline, int offset, int materialWidth, int materialLength) throws LoginException {
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
}
