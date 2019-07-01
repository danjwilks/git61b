package bearmaps;

import java.util.ArrayList;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T>{

    private ArrayList<Node> heap;

    public ArrayHeapMinPQ(){
        heap = new ArrayList<>();
        heap.add(new Node(null, 0.0));
    }


    /* Adds an item with the given priority value. Throws an
     * IllegalArgumentException if item is already present.
     * You may assume that item is never null. */
    @Override
    public void add(T item, double priority){

        heap.add(new Node(item, priority));
        recSortHeap(heap.size() -1 );

    }

    /** recursively sorts new order after adding new item */
    private void recSortHeap(int indexOfChild){
        if (indexOfChild == 1){
            return;
        }
        int indexOfParent = indexOfChild / 2;
        if (heap.get(indexOfParent).priority < heap.get(indexOfChild).priority){
            Node temp = heap.get(indexOfParent);
            heap.remove(indexOfParent);
            heap.add(indexOfParent, heap.get(indexOfChild-1));
            heap.remove(indexOfChild);
            heap.add(indexOfChild, temp);
            recSortHeap(indexOfParent);
        }
    }

    /* Returns true if the PQ contains the given item. */
    @Override
    public boolean contains(T item){
        return true;
    }

    /* Returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    @Override
    public T getSmallest(){
        return heap.get(1).item;
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
