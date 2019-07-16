package bearmaps.proj2c.server.handler.impl;

import org.junit.Test;
import static org.junit.Assert.*;

public class RasterAPIHandlerTest {

    @Test
    public void calLonDPPTest(){
        double actual = RasterAPIHandler.calLonDPP((-122.2998046875), (-122.2119140625), 256.0);
        assertEquals(0.00034332275390625,actual , 0.00000000000390625);
    }

}
