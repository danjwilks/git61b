package bearmaps;

import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayHeapMinPQTest {

    /**
     * tests getSmallest
     * requires add to work
     */
    @Test
    public void isSmallestTest() {
        ArrayHeapMinPQ<Integer> test = new ArrayHeapMinPQ<>();
        test.add(9, 9.0);
        test.add(10, 10.0);
        test.add(8, 911.0);
        test.add(29, 12.0);
        test.add(234, 3423134);

        assertEquals(234, (int) test.getSmallest());

    }

    /**
     * tests to see if size works
     * assumes add and removeSmallest works
     */

    @Test
    public void sizeTest() {
        ArrayHeapMinPQ<Integer> test = new ArrayHeapMinPQ<>();

        assertEquals(0, test.size());

        test.add(9, 9.0);
        test.add(10, 10.0);

        assertEquals(2, test.size());

        test.add(8, 911.0);
        test.add(29, 12.0);
        test.add(234, 3423134);

        assertEquals(5, test.size());

        test.removeSmallest();
        test.removeSmallest();

        assertEquals(3, test.size());


    }


    @Test
    public void addTimeTest(){

        ArrayHeapMinPQ<Integer> test = new ArrayHeapMinPQ<>();
        Stopwatch sw = new Stopwatch();

        for (int i = 1000; i > 0; i--){
            test.add(i, (double) i);
        }

        System.out.println("Total time elapsed: " + sw.elapsedTime() +  " seconds.");



        comparison<Integer> test1 = new comparison<>();
        Stopwatch sw1 = new Stopwatch();

        for (int i = 1000; i > 0; i--){
            test1.add(i, (double) i);
        }

        System.out.println("Total time elapsed: " + sw1.elapsedTime() +  " seconds.");


    }

    @Test
    public void removeSmallestTimeTest(){

        ArrayHeapMinPQ<Integer> test = new ArrayHeapMinPQ<>();

        for (int i = 1000000; i > 0; i--){
            test.add(i, (double) i);
        }

        Stopwatch sw = new Stopwatch();

        for (int i = 1000; i>1; i--){
            test.removeSmallest();
        }

        System.out.println("Total time elapsed: " + sw.elapsedTime() +  " seconds.");

        comparison<Integer> test1 = new comparison<>();

        for (int i = 1000000; i > 1; i--){
            test1.add(i, (double) i);
        }

        Stopwatch sw1 = new Stopwatch();

        for (int i = 1000; i>1; i--){
            test1.removeSmallest();
        }

        System.out.println("Total time elapsed: " + sw1.elapsedTime() +  " seconds.");


    }


                                /** tests only comparison */

    /**
     * tests getSmallest
     * requires add to work
     */
    @Test
    public void isSmallestTestC() {
        comparison<Integer> test = new comparison<>();
        test.add(9, 9.0);
        test.add(10, 10.0);
        test.add(8, 911.0);
        test.add(29, 12.0);
        test.add(234, 3423134);

        assertEquals(234, (int) test.getSmallest());

    }

    /**
     * tests to see if size works
     * assumes add and removeSmallest works
     */

    @Test
    public void sizeTestC() {
        comparison<Integer> test = new comparison<>();

        assertEquals(0, test.size());

        test.add(9, 9.0);
        test.add(10, 10.0);

        assertEquals(2, test.size());

        test.add(8, 911.0);
        test.add(29, 12.0);
        test.add(234, 3423134);

        assertEquals(5, test.size());

        test.removeSmallest();
        test.removeSmallest();

        assertEquals(3, test.size());


    }


}
