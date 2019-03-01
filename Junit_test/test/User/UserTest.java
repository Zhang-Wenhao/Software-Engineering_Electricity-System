package User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by toavakama on 2018/5/26.
 *
 * @author toavakama
 * @version 1.0
 */
class UserTest {
    @Test
    public void testUser(){
        User a = new User("11111", "11111111");

        assertEquals("11111", a.getID());
    }
}