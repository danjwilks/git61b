package bearmaps;

import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KDTreeTest {

    @Test
    public void speedTest(){
        Random random = new Random(10);
        List<Point> list = new LinkedList<>();

        for (int i = 1; i<100000; i++){

            Point p = new Point(random.nextDouble()*100000,random.nextDouble()*100000);
            list.add(p);
        }

        KdTree test = new KdTree(list);

        Stopwatch KDTreeSW = new Stopwatch();
        for (int i = 1; i<10000; i++){

            double x = random.nextDouble()*10000;
            double y = random.nextDouble()*10000;

            test.nearest(x,y);
        }
        double KDTreeTime = KDTreeSW.elapsedTime();


        NaivePointSet correct = new NaivePointSet(list);
        Stopwatch NaiveSW = new Stopwatch();
        for (int i = 1; i<10000; i++){

            double x = random.nextDouble()*10000;
            double y = random.nextDouble()*10000;

            correct.nearest(x,y);
        }
        double NaiveTime = NaiveSW.elapsedTime();

        System.out.println("Naive Time: " + NaiveTime);
        System.out.println("KDTree Time: " + KDTreeTime);
        assertTrue(KDTreeTime/NaiveTime < 0.1);
    }

    @Test
    public void nearrestTest(){

        Random random = new Random(10);
        List<Point> list = new LinkedList<>();

        for (int i = 1; i<1000; i++){

            Point p = new Point(random.nextDouble()*1000,random.nextDouble()*1000);
            list.add(p);
        }

        KdTree test = new KdTree(list);
        NaivePointSet correct = new NaivePointSet(list);

        for (int i = 1; i<1000; i++){

            double x = random.nextDouble()*1000;
            double y = random.nextDouble()*1000;

            assertEquals(correct.nearest(x,y),test.nearest(x,y));
        }
    }


    /** use visualiser to see if k-d tree is right */
    @Test
    public void constructorTest(){

        Point p1 = new Point(2.0, 3.0);
        Point p2 = new Point(4.0, 2.0);
        Point p3 = new Point(4.0, 5.0);
        Point p4 = new Point(3.0, 3.0);
        Point p5 = new Point(1.0, 5.0);
        Point p6 = new Point(4.0, 4.0);

        KdTree test = new KdTree(List.of(p1,p2,p3,p4,p5,p6));

    }


}
