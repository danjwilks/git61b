package es.datastructur.synthesizer;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testEnqueue() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(3);

        arb.enqueue(1);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.dequeue();
        arb.enqueue(3);

        int[] test = new int[]{2,2,2};

        Iterator<Integer> test2 = arb.iterator();

//        for (int i = 0; i<3 ; i++){
//            System.out.println(test2.next());
//        }

        for (int i : arb){
            System.out.println(i);
        }



    }
}
