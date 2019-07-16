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

    @Test
    public void ImageTest(){

        RasterAPIHandler.Depth depthFour = new RasterAPIHandler.Depth(4);

        assertEquals(-122.27783203125, depthFour.images[4][2].upperLeft.longitude, 0.00000003125);
        assertEquals(37.88352140802976, depthFour.images[4][2].upperLeft.latitude, 0.00000003125);
        assertEquals(-122.2723388671875, depthFour.images[4][2].lowerRight.longitude, 0.00000003125);
        assertEquals(37.87918433842246, depthFour.images[4][2].lowerRight.latitude, 0.00000003125);

    }

    @Test
    public void getDepthTest(){

        double ullon = -122.27783203125;
        double ullat = 37.88352140802976;
        double lrlon = -122.2723388671875;
        double lrlat = 37.87918433842246;
        double width = 100.0;
        double height = 100.0;

        RasterAPIHandler.QueryBox queryBox = new RasterAPIHandler.QueryBox(ullon, ullat, lrlon, lrlat, width, height);
        RasterAPIHandler.Depth expected = new RasterAPIHandler.Depth(3);
        RasterAPIHandler.Depth actual = RasterAPIHandler.getDepth(queryBox);
        assertEquals(expected.heightOfImages, actual.heightOfImages, 0.0000000076721);

    }

}
