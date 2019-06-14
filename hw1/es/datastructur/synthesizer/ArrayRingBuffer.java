package es.datastructur.synthesizer;
import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public

public class ArrayRingBuffer<T>  implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {

        rb = (T[]) new Object[capacity];

        first = 0;
        last = 0;
        fillCount = 0;

    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {

        if (isFull()){
            throw new RuntimeException("Ring buffer overflow");
        }

        if (!isEmpty()){
            last = last +1;
        }
        if (last == capacity()){
            last = 0;
        }
        rb[last] = x;
        fillCount ++;

    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {

        if (isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }

        T output = rb[first];
        rb[first] = null;
        first ++;
        if(first == capacity()){
            first = 0;
        }

        fillCount --;

        return output;

    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        if (isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    /** returns size of array ring buffer */
    @Override
    public int capacity(){
        return rb.length;
    }

    /** returns how many items are in array ring buffer */
    @Override
    public int fillCount(){
        return fillCount;
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.
}
