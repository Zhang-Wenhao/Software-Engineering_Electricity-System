package ControlSys;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by toavakama on 2018/5/26.
 *
 * @author toavakama
 * @version 1.0
 */
class ControlSysTest {
    @Test
    public void testControlSys(){
        ControlSys a = new ControlSys();

        assertEquals("200", a.getBudget().getBudget("11111").get(1));
        assertEquals("300", a.getBudget().getBudget("11111").get(0));
    }
}