package Meter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by toavakama on 2018/5/26.
 *
 * @author toavakama
 * @version 1.0
 */
class MeterTest {
    @Test
    public void testMeter(){
        Meter a = new Meter("11111");
        a.checkCAC();

        assertEquals("11111",a.getID());
        assertEquals(true, a.ifMeterExist());
        assertEquals("2.06", a.getCac().getdConsumptionAndCostS()[0]);
    }
}