
package logic.Calculations;

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
    
}
