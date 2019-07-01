package bearmaps;

import java.util.ArrayList;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T>{

    private ArrayList<T> heap;

    public ArrayHeapMinPQ(){
        heap = new ArrayList<>(null);
    }


    /* Adds an item with the given priority value. Throws an
     * IllegalArgumentException if item is already present.
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

    private class Node implements Comparable<Node>{

        T item;
        Double priority;

        private Node(T item, Double priority){
            this.item = item;
            this.priority = priority;
        }

        public T getItem(){
            return this.item;
        }

        public Double getPriority(){
            return this.priority;
        }

        @Override
        public int compareTo(Node other) {
            if (other == null) {
                return -1;
            }
            return Double.compare(this.getPriority(), other.getPriority());
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object o) {
            if (o == null || o.getClass() != this.getClass()) {
                return false;
            } else {
                return ((Node) o).getItem().equals(getItem());
            }
        }

        @Override
        public int hashCode() {
            return item.hashCode();
        }

    }


}
