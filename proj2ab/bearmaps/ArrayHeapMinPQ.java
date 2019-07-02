package bearmaps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T>{

    private ArrayList<Node> heap;
    private HashSet<T> items;

    public ArrayHeapMinPQ(){
        heap = new ArrayList<>();
        heap.add(new Node(null, 0.0));
        items = new HashSet<>();
    }

    private class Node{

        T item;
        Double priority;

        private Node(T item, Double priority){
            this.item = item;
            this.priority = priority;
        }
    }

    /** returns index of node i's parent */
    private int parentIndex(int i){
        return i / 2;
    }

    /** returns index of node i's leftChildIndex */
    private int leftChildIndex(int i){
        return i * 2;
    }

    /** returns index of node i's rightChildIndex */
    private int rightChildIndex(int i){
        return i * 2 + 1;
    }



    /* Adds an item with the given priority value. Throws an
     * IllegalArgumentException if item is already present.
     * You may assume that item is never null. */
    @Override
    public void add(T item, double priority){

        if (contains(item)){
            throw new IllegalArgumentException("item is already present");
        }
        heap.add(new Node(item, priority));
        recSortHeap(size() );
        items.add(item);

    }

    /** recursively sorts new order after adding new item */
    private void recSortHeap(int index){
        if (index == 1){
            return;
        }
        int indexOfParent = parentIndex(index);


        if (heap.get(indexOfParent).priority < heap.get(index).priority){
            Node temp = heap.get(indexOfParent);
            heap.remove(indexOfParent);
            heap.add(indexOfParent, heap.get(index-1));
            heap.remove(index);
            heap.add(index, temp);
            recSortHeap(indexOfParent);
        }
    }

    /* Returns true if the PQ contains the given item. */
    @Override
    public boolean contains(T item){
        return items.contains(item);
    }

    /* Returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    @Override
    public T getSmallest(){
        if (size() == 0){
            throw new NoSuchElementException();
        }
        return heap.get(1).item;
    }

    /* Removes and returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    @Override
    public T removeSmallest(){
        if (size() == 0){
            throw new NoSuchElementException();
        }

        T output = heap.get(1).item;
        int parentIndex = 1;
        heap.remove(parentIndex);
        Node newSmallest = heap.get(size());
        heap.remove(size());
        heap.add(parentIndex, newSmallest);

        removeSmallestHelper(parentIndex);

        return output;
    }

    /** recursively goes through and rearranges*/
    private void removeSmallestHelper(int parentIndex){

        int rightChildIndex = parentIndex * 2 + 1;
        int leftChildIndex = parentIndex * 2;

        if (rightChildIndex <= size()){
            if (heap.get(rightChildIndex).priority > heap.get(parentIndex).priority && heap.get(rightChildIndex).priority > heap.get(leftChildIndex).priority){
                swap(parentIndex, rightChildIndex);
                removeSmallestHelper(rightChildIndex);
            } else if (heap.get(leftChildIndex).priority > heap.get(parentIndex).priority) {
                swap(parentIndex, leftChildIndex);
                removeSmallestHelper(leftChildIndex);
            }
        } else if (leftChildIndex <= size()){
            if (heap.get(leftChildIndex).priority > heap.get(parentIndex).priority){
                swap(parentIndex, leftChildIndex);
                removeSmallestHelper(leftChildIndex);
            }
        }

    }

    /** smaller index = index1 */
    private void swap(int index1, int index2){

        Node temp = heap.get(index1);
        heap.remove(index1);
        heap.add(index1, heap.get(index2 - 1));
        heap.remove(index2);
        heap.add(index2, temp);

    }

    /* Returns the number of items in the PQ. */
    @Override
    public int size(){
        return heap.size() - 1;
    }

    /* Changes the priority of the given item. Throws NoSuchElementException if the item
     * doesn't exist. */
    @Override
    public void changePriority(T item, double priority){

    }

}
