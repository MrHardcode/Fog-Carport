package logic;

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

    public RoofRaisedCalc() {
        DAO = DataFacadeImpl.getInstance();
        bracketCount = 0;
        screwCount = 0;
    }

    public PartslistModel getRoofRaisedMaterials(OrderModel order) throws LoginException {
        PartslistModel roofRaisedBOM = new PartslistModel();

        roofRaisedBOM.getBillOfMaterials().addAll(getRoofTiles(order).getBillOfMaterials());
        roofRaisedBOM.getBillOfMaterials().addAll(getRoofStructure(order).getBillOfMaterials());

        return roofRaisedBOM;

    }

    protected PartslistModel getRoofTiles(OrderModel order) {
        PartslistModel roofTilesBOM = new PartslistModel();

        return roofTilesBOM;
    }

    protected PartslistModel getRoofStructure(OrderModel order) throws LoginException {
        PartslistModel roofStructureBOM = new PartslistModel();
        int totalWidth = order.getWidth() + 600;

        // spær bredde = 45 mm
        // afstand (luft) mellem spær max 900 mm
        int rafterCount = 2;
        int remainderLength = order.getLength() - (2 * 45);
        
        System.out.println("START remainder length = " + remainderLength);

        for (int i = 0; i < remainderLength; i++) {
            if (remainderLength > 900) {
                rafterCount = rafterCount + 1;
                remainderLength = remainderLength - (900 + 45);
                System.out.println("remainder length = " + remainderLength);
                System.out.println("rafter counter = " + rafterCount);
            }
        }
        
        for (int i = 0; i < rafterCount; i++) {
            roofStructureBOM.addPartslist(generateRafter(totalWidth, order.getIncline()));
        }
        System.out.println("beslag counter = " + bracketCount);

        return roofStructureBOM;
    }

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

        return rafterBOM;
    }

}
