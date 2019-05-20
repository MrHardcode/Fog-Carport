
package logic.Calculations;

import data.exceptions.AlgorithmException;
import data.models.PartslistModel;

/**
 *
 * @author Camilla
 */
public class PriceCalculator {
        
    public int getSuggestedRetailPrice(PartslistModel partsList) {
        int costPrice = partsList.getTotalprice();
        int suggestedRetailPrice = costPrice + (int) (costPrice * 0.5);
                
        return suggestedRetailPrice;
    }
    
    // FLYTTES TIL JAVASCRIPT
    public int getOperationMargin (PartslistModel partsList, int price) throws AlgorithmException{
        if(price <= 0){
            throw new AlgorithmException("Zero or negative values not permitted");
        }
        int costPrice = partsList.getTotalprice();
        int operationMargin = (costPrice * 100) / price;
        
        return operationMargin;
    }
}
