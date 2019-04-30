package logic.Calculations;

/**
 * Material used for creation:
 * https://datsoftlyngby.github.io/dat2sem2019Spring/Modul4/Fog/CP01_DUR.pdf
 *
 * Material rules:
 * 
 * Spær: Every 50cm
 * Stern: 8x (two per building side: one under, one over)
 * Vandbrædt: 3x (size: 19x100. 1x front, 1x each side)
 * 
 * Universalbeslag: 2x per spær. (Remember: Right/Left orientation) (9 scres per beslag)
 * Hulbånd: 1x (10m)
 *
 * Plastic roofing:
 *  Outermost parts must extend 5cm beyond its Spær to account for water.
 *  Roof parts have a 2 'wave' overlay (10cm?)
 *  12 screws per cm^2.
 * 
 * Tagpap roofing:
 * To be determined
 * 
 * Lægter: 
 * To be determined
 * 
 * @author Runi
 */
public class RoofFlatCalc
{

    private static RoofFlatCalc instance = null;

    /**
     * Singleton pattern
     *
     * @return returns a new RoofFlatCalc or the current one. (if available)
     */
    public synchronized static RoofFlatCalc getInstance()
    {
        if (instance == null)
        {
            instance = new RoofFlatCalc();
        }
        return instance;
    }

}
