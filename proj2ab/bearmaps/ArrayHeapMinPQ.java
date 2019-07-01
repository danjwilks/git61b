package bearmaps;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T>{

    /* Adds an item with the given priority value. Throws an
     * IllegalArgumentExceptionb if item is already present.
     * You may assume that item is never null. */
    @Override
    public void add(T item, double priority){

    }


    /* Returns true if the PQ contains the given item. */
    @Override
    public boolean contains(T item){
        return true;
    }

    /* Returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    @Override
    public T getSmallest(){
        return null;
    }

    /* Removes and returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    @Override
    public T removeSmallest(){
        return null;
    }

    /* Returns the number of items in the PQ. */
    @Override
    public int size(){
        return 1;
    }

    /* Changes the priority of the given item. Throws NoSuchElementException if the item
     * doesn't exist. */
    @Override
    public void changePriority(T item, double priority){

    }


}
