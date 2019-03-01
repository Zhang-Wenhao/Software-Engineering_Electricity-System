package Provider;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by toavakama on 2018/5/26.
 *
 * @author toavakama
 * @version 1.0
 */
class ProviderTest {
    @Test
    public void testUser(){
        Provider a = new Provider("EP123", "12345678");

        assertEquals("EP123",a.getID());
        assertEquals("12345678",a.getPsw());
        assertEquals("1.0", a.getGenInfo().get(0));
    }
}