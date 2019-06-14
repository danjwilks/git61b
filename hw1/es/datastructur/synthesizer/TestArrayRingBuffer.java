package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testEnqueue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(3);

        arb.enqueue(2);
        arb.enqueue(2);
        arb.enqueue(2);
        arb.dequeue();
        arb.enqueue(2);
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();

        int[] test = new int[]{2,2,2};
    }
}
