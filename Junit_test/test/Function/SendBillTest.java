package Function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by toavakama on 2018/5/26.
 *
 * @author toavakama
 * @version 1.0
 */
class SendBillTest {
    @Test
    public void testSendBill(){
        SendBill a = new SendBill();

        assertEquals(false, a.ifSend());
    }
}