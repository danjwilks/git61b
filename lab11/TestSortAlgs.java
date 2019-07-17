import edu.princeton.cs.algs4.Queue;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSortAlgs {

    @Test
    public void testQuickSort() {

    }

    @Test
    public void testMergeSort() {
        Queue<Integer> actualQue = new Queue<>();
        actualQue.enqueue(1);
        actualQue.enqueue(2);
        actualQue.enqueue(10);
        actualQue.enqueue(4);
        actualQue.enqueue(123);
        actualQue.enqueue(23);

        MergeSort.mergeSort(actualQue);

        Queue<Integer> expected = new Queue<>();
        expected.enqueue(1);
        expected.enqueue(2);
        expected.enqueue(4);
        expected.enqueue(10);
        expected.enqueue(23);
        expected.enqueue(123);


        assertTrue(isSorted(MergeSort.mergeSort(actualQue)));


    }


    @Test
    public void testmergetwosortedQues() {

        Queue<Integer> actualQue = new Queue<>();
        actualQue.enqueue(1);
        actualQue.enqueue(2);
        actualQue.enqueue(3);
        actualQue.enqueue(5);

        Queue<Integer> que = new Queue<>();
        que.enqueue(2);
        que.enqueue(4);
        que.enqueue(10);
        que.enqueue(3123);

        Queue<Integer> expected = new Queue<>();
        expected.enqueue(1);
        expected.enqueue(2);
        expected.enqueue(2);
        expected.enqueue(3);
        expected.enqueue(4);
        expected.enqueue(5);
        expected.enqueue(10);
        expected.enqueue(3123);


        //assertTrue(isSorted(MergeSort.mergeSortedQueues(actualQue, que)));


    }

    /**
     * Returns whether a Queue is sorted or not.
     *
     * @param items  A Queue of items
     * @return       true/false - whether "items" is sorted
     */
    private <Item extends Comparable> boolean isSorted(Queue<Item> items) {
        if (items.size() <= 1) {
            return true;
        }
        Item curr = items.dequeue();
        Item prev = curr;
        while (!items.isEmpty()) {
            prev = curr;
            curr = items.dequeue();
            if (curr.compareTo(prev) < 0) {
                return false;
            }
        }
        return true;
    }
}
