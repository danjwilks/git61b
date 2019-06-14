package es.datastructur.synthesizer;
import java.util.Iterator;

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

        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }

        if (!isEmpty()) {
            last = last + 1;
        }
        if (last == capacity()) {
            last = 0;
        }
        rb[last] = x;
        fillCount++;

    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }

        T output = rb[first];
        rb[first] = null;
        first++;
        if (first == capacity()) {
            first = 0;
        }

        fillCount--;

        return output;

    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    /** returns size of array ring buffer */
    @Override
    public int capacity() {
        return rb.length;
    }

    /** returns how many items are in array ring buffer */
    @Override
    public int fillCount() {
        return fillCount;
    }

    /** returns an iterator of ringbuffer, sets up for enhanced for loop*/
    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    /** required for enhanced for loop */
    private class ArrayRingBufferIterator implements Iterator {

        private int lastGone;
        private int wizPos;

        ArrayRingBufferIterator() {
            wizPos = first;
            lastGone = 0;
        }

        public boolean hasNext() {
            if (rb[wizPos] == null || lastGone == 1) {
                return false;
            }
            return true;
        }

        public T next() {

            T output = rb[wizPos];

            if (wizPos == last) {
                lastGone = 1;
            }

            wizPos++;
            if (wizPos == rb.length) {
                wizPos = 0;
            }

            return output;

        }
    }

    /**
     * returns true if compared objects are the same
     * not necessarily same ptr
     */
    @Override
    public boolean equals(Object o) {

        if (o.getClass() != this.getClass()) {
            return false;
        } else {
            ArrayRingBuffer<T> other = (ArrayRingBuffer<T>) o;
            if (other.capacity() != this.capacity()) {
                return false;
            }

            for (int i = 0; i < this.capacity(); i++) {
                T compare1 = this.dequeue();
                T compare2 = other.dequeue();

                if (compare1 != compare2) {
                    return false;
                } else {
                    this.enqueue(compare1);
                    other.enqueue(compare2);
                }

            }
        }

        return true;
    }
}
