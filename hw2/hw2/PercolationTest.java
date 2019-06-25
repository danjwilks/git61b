package hw2;


import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationTest {

    Percolation test = new Percolation(5);

    @Test
    public void xyTo1DTest(){

        assertEquals (14, test.xyTo1D(2, 4));
        assertEquals (0, test.xyTo1D(0, 0));
        assertEquals (24, test.xyTo1D(4, 4));

    }

    @Test
    public void isSquareTest(){

        assertFalse(test.isSquare(5,5));
        assertFalse(test.isSquare(5,4));
        assertFalse(test.isSquare(4,5));

        assertTrue(test.isSquare(0,0));
        assertTrue(test.isSquare(0,1));
        assertTrue(test.isSquare(1,0));
        assertTrue(test.isSquare(3,2));

    }

    @Test
    public void isFullTest(){

        Percolation test1 = new Percolation(5);

        test1.open(0,0);
        test1.open(1,0);
        test1.open(2,0);
        test1.open(3,0);
        test1.open(3,1);
        test1.open(3,3);
        test1.open(3,2);

        assertTrue(test1.isFull(3,0));
        assertTrue(test1.isFull(3,2));
        assertTrue(test1.isFull(3,3));
        assertTrue(test1.isFull(3,1));

        test1.open(4,4);

        assertFalse(test1.isFull(4,4));
        assertFalse(test1.isFull(4,1));
        assertFalse(test1.isFull(4,3));
        assertFalse(test1.isFull(3,4));

    }

    @Test
    public void numberOfOpenSitesTest(){

        Percolation test1 = new Percolation(5);

        test1.open(0,0);
        test1.open(1,0);
        test1.open(2,0);
        test1.open(3,0);
        test1.open(3,1);
        test1.open(3,3);
        test1.open(3,2);

        assertEquals(7, test1.numberOfOpenSites());

    }


}
