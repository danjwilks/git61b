
import org.junit.Test;
import static org.junit.Assert.*;

public class UnionFindTest {

    @Test
    public void testParent(){

        UnionFind test = new UnionFind(5);

        test.union(1,2);
        test.union(3,4);

//        test.union(0,1);
//        test.union(1,4);


        assertEquals(1, test.find(1));
        assertEquals(1, test.find(2));
        assertEquals(3, test.find(3));
        assertEquals(3, test.find(4));



    }

}
