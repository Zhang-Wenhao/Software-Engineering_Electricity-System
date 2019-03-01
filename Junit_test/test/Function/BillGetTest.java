package Function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by toavakama on 2018/5/26.
 *
 * @author toavakama
 * @version 1.0
 */
class BillGetTest {
    @Test
    public void testBillGet(){
        BillGet a = new BillGet();

        assertEquals(false,a.ifNewBill("11111"));
        assertEquals("300.00", a.billListGet("11111")[2][2]);
    }
}