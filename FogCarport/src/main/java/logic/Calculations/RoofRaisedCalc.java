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
        
        int screwPacks = (int) Math.ceil(screwCount/200);
        MaterialModel material = DAO.getMaterial(20);
        for (int i = 0; i < screwPacks; i++) {
            roofRaisedBOM.addMaterial(material);
        }
        return roofRaisedBOM;
    }

    /**
     *
     * @param order
     * @return
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
        for (int i = 0; i < tileCount; i++) {
            roofTilesBOM.addMaterial(materialTiles);

        }
        MaterialModel material = DAO.getMaterial(getTopRoofTileID(order));
        topTileCount = (int) Math.ceil((double) order.getLength() / (double) material.getLength());
        for (int i = 0; i < topTileCount; i++) {
            roofTilesBOM.addMaterial(material);
        }
        roofTilesBOM.addMaterial(DAO.getMaterial(32)); // tagstenbinder/nakkekrog
        return roofTilesBOM;
    }

    /**
     *
     * @param order
     * @return
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
     *
     * @param order
     * @return
     * @throws LoginException
     */
    protected PartslistModel getRoofStructure(OrderModel order) throws LoginException {
        PartslistModel roofStructureBOM = new PartslistModel();
        int totalWidth = order.getWidth() + 600;

        // spær bredde = 45 mm
        // afstand (luft) mellem spær max 900 mm
        rafterCount = 2;
        int remainderLength = order.getLength() - (2 * 45);

        rafterCount = rafterCount + (int) Math.ceil((double) remainderLength / (double) (900 + 45)); // 90 cm mellemrum mellem rafter
        
        MaterialModel material = DAO.getMaterial(30);
        for (int i = 0; i < rafterCount; i++) {
            roofStructureBOM.addPartslist(generateRafter(totalWidth, order.getIncline()));
            roofStructureBOM.addMaterial(material); // toplægteholdere
        }

        roofStructureBOM.addPartslist(generateLaths(order.getLength(), totalWidth, order.getIncline()));

        return roofStructureBOM;
    }

    /**
     *
     * @param materials
     * @param length
     * @return
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

        for (MaterialModel material : materials) {
            if (length < 1) {
                break;
            }

            int amountLongest = (int) Math.ceil(((double) length / (double) material.getLength()));
            int remainder = length - material.getLength() * amountLongest;

            for (int i = 0; i < amountLongest; i++) {
                calcParts.addMaterial(material);
                length = length - material.getLength();
            }
            if (remainder > 0) {
                length = remainder;
            }
        }
        return calcParts;
    }

    /**
     *
     * @param totalWidth
     * @param incline
     * @return
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

        rafterBOM.addPartslist(getMaterialsFromlength(materials, totalWidth));
        rafterBOM.addPartslist(getMaterialsFromlength(materials, (int) Math.ceil(hypotenuse)));
        rafterBOM.addPartslist(getMaterialsFromlength(materials, (int) Math.ceil(hypotenuse)));
        rafterBOM.addPartslist(getMaterialsFromlength(materials, (int) Math.ceil(oppositeCath)));
        bracketCount = bracketCount + 6;
        screwCount = screwCount + (4*6);

        return rafterBOM;
    }

    /**
     *
     * @param orderLength
     * @param totalWidth
     * @param incline
     * @return
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

        lathsBOM.addPartslist(getMaterialsFromlength(materials, lathsLength));
        // tilføj Toplægteholder (metal, kommer i hel længde)

        return lathsBOM;
    }

    /**
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

        for (int i = 0; i < amountMaterial; i++) {
            claddingBOM.addMaterial(material);
            screwCount = screwCount + 6;
        }

        return claddingBOM;
    }

//                                      height  width   length    
//      8	19x100mm. trykimp. Bræt  19	100	4800
//      9	19x100mm. trykimp. Bræt	 19	100	2400
//      10	19x100mm. trykimp. Bræt	 19	100	2100

    /**
     *
     * @param totalWidth
     * @param incline
     * @param offset
     * @param materialWidth
     * @param materialLength
     * @return
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
