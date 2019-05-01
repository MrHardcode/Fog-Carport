package logic;


import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.LoginException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.ArrayList;


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
    
    protected PartslistModel getRoofTiles(OrderModel order){
        PartslistModel roofTilesBOM = new PartslistModel();
        
        return roofTilesBOM;
    }
    
    protected PartslistModel getRoofStructure(OrderModel order) throws LoginException{
        PartslistModel roofStructureBOM = new PartslistModel();
        
        int totalWidth = order.getWidth() + 600;
        
        double angleRad = Math.toRadians(order.getIncline()); 
        double adjacentCath = totalWidth * 0.5;
        double hypotenuse = (adjacentCath/Math.cos(angleRad));
        double oppositeCath = (Math.sin(angleRad) * hypotenuse);
        
        ArrayList<MaterialModel> materials = new ArrayList();
        materials.add(DAO.getMaterial(6)); // length 2400 mm
        materials.add(DAO.getMaterial(7)); // length 3600 mm
        
        for(MaterialModel material : materials){
            if((material.getLength()/totalWidth) > 0){
                roofStructureBOM.addMaterial(material);
                return roofStructureBOM;
            }
        }
        
        
        return roofStructureBOM;
    }
    
    
}
