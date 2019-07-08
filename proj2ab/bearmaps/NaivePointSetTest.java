package bearmaps;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class NaivePointSetTest {

    @Test
    public void nearrestTest(){

        Point p1 = new Point(1.1, 2.2);
        Point p2 = new Point(3.3, 4.4);
        Point p3 = new Point(-2.9, 4.2);

        NaivePointSet test = new NaivePointSet(List.of(p1,p2,p3));
        Assert.assertEquals(test.nearest(3.0,4.0), p2);
    }

}
