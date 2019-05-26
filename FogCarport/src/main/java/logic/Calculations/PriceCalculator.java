
package logic.Calculations;

import data.models.PartslistModel;

/**
 *
 * @author Camilla
 */
public class PriceCalculator {
        
    /**
     * Takes partslist total price and returns its 150% value as an int
     * @param partsList partslist in question
     * @return 
     */
    public int getSuggestedRetailPrice(PartslistModel partsList) {
        int costPrice = partsList.getTotalprice();
        int suggestedRetailPrice = costPrice + (int) (costPrice * 0.5);
                
        return suggestedRetailPrice;
    }
    
}
