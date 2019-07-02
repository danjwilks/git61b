package bearmaps;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayHeapMinPQTest {

    /** tests getSmallest
     * requires add to work
     */
    @Test
    public void isSmallestTest(){
        ArrayHeapMinPQ<Integer> test = new ArrayHeapMinPQ<>();
        test.add(9, 9.0);
        test.add(10,10.0);
        test.add(8, 911.0);
        test.add(29, 12.0);
        test.add(234, 3423134);



        assertEquals(234, (int) test.getSmallest());

    }

    /** tests to see if size works */
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




    }

}
