package hw2;

import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationStatsTest {

    @Test
    public void meanTest(){
        double testing;
        PercolationFactory pf = new PercolationFactory();

        PercolationStats test = new PercolationStats(1000, 1000, pf);
        testing = test.mean();
        assertTrue(test.mean()>0.4);

    }
}
