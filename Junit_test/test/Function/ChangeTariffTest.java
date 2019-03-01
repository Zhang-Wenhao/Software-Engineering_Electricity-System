package Function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by toavakama on 2018/5/26.
 *
 * @author toavakama
 * @version 1.0
 */
class ChangeTariffTest {
    @Test
    public void testChangeTariff(){
        ChangeTariff a = new ChangeTariff();
        a.readT();

        assertEquals("2.0", a.getTariff()[1]);
    }
}