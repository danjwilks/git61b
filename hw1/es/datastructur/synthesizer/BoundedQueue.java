package es.datastructur.synthesizer;

import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T> {

    int capacity();     // return size of the buffer
    int fillCount();    // return number of items currently in the buffer
    void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();           // return (but do not delete) item from the front

    /** returns true if queue is empty */
    default boolean isEmpty() {
        return 0 == fillCount();
    }
    /** returns true if queue is full */
    default boolean isFull() {
        return capacity() == fillCount();
    }

    @Override
    Iterator<T> iterator();

}
