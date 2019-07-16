package bearmaps.proj2c.server.handler.impl;

import org.junit.Test;
import static org.junit.Assert.*;

public class RasterAPIHandlerTest {

    @Test
    public void calLonDPPTest(){
        double actual = RasterAPIHandler.calLonDPP((-122.2998046875), (-122.2119140625), 256.0);
        assertEquals(0.00034332275390625,actual , 0.00000000000390625);
    }

    @Test
    public void depthTest(){

        RasterAPIHandler.Depth test = new RasterAPIHandler.Depth(3);
        assertEquals("d3_x3_y1.png", test.images[3][1].name);
        assertEquals("d3_x6_y3.png", test.images[6][3].name);
        assertEquals("d3_x2_y4.png", test.images[2][4].name);

    }

}
