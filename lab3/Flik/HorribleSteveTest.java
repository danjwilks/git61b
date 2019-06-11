import static org.junit.Assert.*;

import org.junit.Test;

public class HorribleSteveTest{
    /** test isSameNumber from Flik library */
    @Test
    public void TestIsSameNumber(){
        assertEquals(128 == 128, Flik.isSameNumber(128,128));
        assertEquals(false, Flik.isSameNumber(5,4));
    }

}