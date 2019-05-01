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

    public RoofRaisedCalc() {
        DAO = DataFacadeImpl.getInstance();
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
        
        generateRafter(totalWidth, order.getIncline());

        return roofStructureBOM;
    }
    
    protected PartslistModel getMaterialsFromlength (ArrayList<MaterialModel> materials, int length){
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
            int amountLongest = material.getLength() / length;
            int remainder = material.getLength() % length;
            if (remainder > 0) {
                length = remainder;
            }
            for (int i = 0; i < amountLongest; i++) {
                calcParts.addMaterial(material);
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
        rafterBOM.addPartslist(getMaterialsFromlength(materials, (int) Math.ceil(oppositeCath)));
        
        return rafterBOM;
    }
    

}
