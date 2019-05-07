import logic.Calculations.BaseCalcTest;
import logic.Calculations.RoofFlatCalcTest;
import logic.Calculations.RoofRaisedCalcTest;
import logic.Calculations.ShedLogicTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Camilla
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
RoofRaisedCalcTest.class, BaseCalcTest.class, ShedLogicTest.class, RoofFlatCalcTest.class}) 

public class FogTestSuite {

    
}
