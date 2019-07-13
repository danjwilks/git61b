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
    public void getSmallestTest() {
        ArrayHeapMinPQ<Integer> test = new ArrayHeapMinPQ<>();
        test.add(9, 9.0);
        test.add(10, 10.0);
        test.add(8, 911.0);
        test.add(29, 12.0);
        test.add(234, 3423134);

        assertEquals(234, (int) test.getSmallest());

    }

    /**
     * tests removeSmallest
     * requires add to work
     */
    @Test
    public void removeSmallestTest() {
        ArrayHeapMinPQ<Integer> test = new ArrayHeapMinPQ<>();
        test.add(9, 9.0);
        test.add(10, 10.0);
        test.add(8, 911.0);
        test.add(29, 12.0);
        test.add(234, 3423134);

        assertEquals(234, (int) test.removeSmallest());
        assertEquals(8, (int) test.removeSmallest());
        assertEquals(29, (int) test.removeSmallest());
        assertEquals(10, (int) test.removeSmallest());
        assertEquals(9, (int) test.removeSmallest());

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

    /** tests to see if changing priority works
     * assumes add and removeSmallest work*/
    @Test
    public void changingPriorityTest() {
        ArrayHeapMinPQ<Integer> test = new ArrayHeapMinPQ<>();

        assertEquals(0, test.size());

        test.add(9, 9.0);
        test.add(10, 10.0);

        assertEquals(2, test.size());

        test.add(8, 911.0);
        test.add(29, 12.0);
        test.add(234, 1000.0);

        assertEquals(5, test.size());

        test.changePriority(9,10000.0);
        test.changePriority(8,1.0);
        test.changePriority(29,500);

        assertEquals(9, (int) test.removeSmallest());
        assertEquals(234, (int) test.removeSmallest());
        assertEquals(29, (int) test.removeSmallest());
        assertEquals(10, (int) test.removeSmallest());
        assertEquals(8, (int) test.removeSmallest());


    }



    @Test
    public void TimeTest(){

        ArrayHeapMinPQ<Integer> test = new ArrayHeapMinPQ<>();
        for (int i = 10000000; i > 0; i--){
            test.add(i, (double) i);
        }
        Stopwatch sw = new Stopwatch();

        test.removeSmallest();

        System.out.println("My implementation: " + sw.elapsedTime() +  " seconds.");



        NaiveMinPQ<Integer> test1 = new NaiveMinPQ<>();
        for (int i = 10000000; i > 0; i--){
            test1.add(i, (double) i);
        }
        Stopwatch sw1 = new Stopwatch();

        test1.removeSmallest();

        System.out.println("Naive implementation: " + sw1.elapsedTime() +  " seconds.");


    }

    @Test
    public void removeSmallestTimeTest() {

        ArrayHeapMinPQ<Integer> test = new ArrayHeapMinPQ<>();
        for (int i = 100000; i > 0; i--) {
            test.add(i, (double) i);
        }
        Stopwatch sw = new Stopwatch();
        for (int i = 1000; i > 1; i--) {
            test.removeSmallest();
        }
        System.out.println("My implementation: " + sw.elapsedTime() + " seconds.");


        comparison<Integer> test1 = new comparison<>();
        for (int i = 100000; i > 0; i--) {
            test1.insert(i);
        }
        Stopwatch sw1 = new Stopwatch();
        for (int i = 1000; i > 1; i--) {
            test1.delMin();
        }
        System.out.println("Comparison implementation: " + sw1.elapsedTime() + " seconds.");



        NaiveMinPQ<Integer> test2 = new NaiveMinPQ<>();
        for (int i = 100000; i > 0; i--) {
            test2.add(i, (double) i);
        }
        Stopwatch sw2 = new Stopwatch();
        for (int i = 1000; i > 1; i--) {
            test2.removeSmallest();
        }
        System.out.println("Naive implementation: " + sw2.elapsedTime() + " seconds.");

    }


                                /** tests only comparison */

//    /**
//     * tests getSmallest
//     * requires add to work
//     */
//    @Test
//    public void isSmallestTestC() {
//        comparison<Integer> test = new comparison<>();
//        test.add(9, 9.0);
//        test.add(10, 10.0);
//        test.add(8, 911.0);
//        test.add(29, 12.0);
//        test.add(234, 3423134);
//
//        assertEquals(234, (int) test.getSmallest());
//
//    }
//
//    /**
//     * tests to see if size works
//     * assumes add and removeSmallest works
//     */
//
//    @Test
//    public void sizeTestC() {
//        comparison<Integer> test = new comparison<>();
//
//        assertEquals(0, test.size());
//
//        test.add(9, 9.0);
//        test.add(10, 10.0);
//
//        assertEquals(2, test.size());
//
//        test.add(8, 911.0);
//        test.add(29, 12.0);
//        test.add(234, 3423134);
//
//        assertEquals(5, test.size());
//
//        test.removeSmallest();
//        test.removeSmallest();
//
//        assertEquals(3, test.size());
//
//
//    }


}
