package logic;


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
        
        return roofStructureBOM;
    }
}
