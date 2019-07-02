package bearmaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

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
        if (heap.size() == 1){
            throw new NoSuchElementException();
        }
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
        return heap.size();
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

        @Override
        public int hashCode() {
            return item.hashCode();
        }

        @Override
        public int compareTo(Node anotherNode) {
            return anotherNode.priority.compareTo(this.priority);
        }

    }

}
