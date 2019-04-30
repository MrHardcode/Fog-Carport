package logic;


import data.DataFacade;
import data.DataFacadeImpl;
import data.models.OrderModel;
import data.models.PartslistModel;


/**
 *
 * @author Camilla
 */
public class RoofRaisedCalc {
    
    
    public PartslistModel getRoofRaisedMaterials(OrderModel order) {
        PartslistModel roofRaisedBOM = new PartslistModel();
        

        roofRaisedBOM.getBillOfMaterials().addAll(getRoofTiles(order).getBillOfMaterials());
        roofRaisedBOM.getBillOfMaterials().addAll(getRoofStructure(order).getBillOfMaterials());

        return roofRaisedBOM;

    }
    
    protected PartslistModel getRoofTiles(OrderModel order){
        PartslistModel roofTilesBOM = new PartslistModel();
        
        return roofTilesBOM;
    }
    
    protected PartslistModel getRoofStructure(OrderModel order){
        PartslistModel roofStructureBOM = new PartslistModel();
        
        double angleRad = Math.toRadians(order.getIncline()); 
        double adjacentCath = (order.getWidth() * 0.5) + 300;
        double hypotenuse = (adjacentCath/Math.cos(angleRad));
        double oppositeCath = (Math.sin(angleRad) * hypotenuse);
        
        if(order.getWidth() < 1800){
            roofStructureBOM.addMaterial(material);
        }
        
        return roofStructureBOM;
    }
    
    
}
