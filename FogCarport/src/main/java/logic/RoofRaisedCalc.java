package logic;

import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.Collection;

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
    
    public PartslistModel getRoofTiles(OrderModel order){
        PartslistModel roofTilesBOM = new PartslistModel();
        
        return roofTilesBOM;
    }
    
    public PartslistModel getRoofStructure(OrderModel order){
        PartslistModel roofStructureBOM = new PartslistModel();
        
        return roofStructureBOM;
    }
}
