package bearmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T>{

    private ArrayList<Node> heap;
    private int size;
    private HashMap<T, Integer> nodeIndexs;


    private class Node{

        T item;
        Double priority;

        private Node(T item, Double priority){
            this.item = item;
            this.priority = priority;
        }
    }

    public ArrayHeapMinPQ(){
        heap = new ArrayList<>();
        heap.add(new Node(null, 0.0));
        size = 0;
        nodeIndexs = new HashMap<>();
    }

    /** Adds an item with the given priority value. Throws an
     * IllegalArgumentException if item is already present.
     * You may assume that item is never null. */
    @Override
    public void add(T item, double priority){
        if (contains(item)){
            throw new IllegalArgumentException();
        }
        size = size + 1;
        Node input = new Node(item, priority);

        nodeIndexs.put(item, size());
        heap.add(size(), input);
        swim(size());
    }

    /** swaps node with parents until priority of heap is right */
    private void swim(int index){

        while (parentIndex(index) > 0){
            if (firstIndexIsLowerPrio(parentIndex(index), index)) {
                swap(parentIndex(index), index);
                index = parentIndex(index);
            } else {
                break;
            }
        }
    }

    /** swaps the places of two nodes */
    private void swap(int index1, int index2){
        Node index2Replacement = heap.get(index1);
        Node index1Replacement = heap.get(index2);

        heap.remove(index1);
        heap.add(index1, index1Replacement);
        nodeIndexs.put(index1Replacement.item, index1);


        heap.remove(index2);
        heap.add(index2, index2Replacement);
        nodeIndexs.put(index2Replacement.item, index2);

    }

    /** returns the index of parent */
    private int parentIndex(int childIndex){
        return childIndex/ 2;
    }

    /** Returns true if the PQ contains the given item. */
    @Override
    public boolean contains(T item){
        return nodeIndexs.containsKey(item);
    }

    /** Returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    @Override
    public T getSmallest(){
        if (size() == 0){
            throw new NoSuchElementException();
        }
        return heap.get(1).item;
    }

    /** Removes and returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    @Override
    public T removeSmallest(){
        T smallest = heap.get(1).item;

        nodeIndexs.remove(heap.get(1));

        heap.remove(1);
        size = size -1;

        if (size == 0){
            return smallest;
        }

        Node toTop = heap.get(size());
        heap.remove(size());
        heap.add(1, toTop);
        nodeIndexs.put(toTop.item, 1);

        sink(1);
        return smallest;
    }

    /** send item down if priority of children is larger */
    public void sink(int index){

        if (leftChildIndex(index) <= size()){
            if (firstIndexIsLowerPrio(index, leftChildIndex(index))){
                swap(index, leftChildIndex(index));
                sink(leftChildIndex(index));
            } else if (rightChildIndex(index) <= size()){
                if (firstIndexIsLowerPrio(index, rightChildIndex(index))){
                    swap(index, rightChildIndex(index));
                    sink(rightChildIndex(index));
                }
            }
        }

    }

    /** returns true if the first index's priority
     *  in given arguments is smaller than second */
    private boolean firstIndexIsLowerPrio(int firstIndex, int secondIndex){

        double firstPriority = heap.get(firstIndex).priority;
        double secondPriority = heap.get(secondIndex).priority;

        return (firstPriority < secondPriority);
    }

    /** returns the index of the left child */
    private int leftChildIndex(int parentIndex){
        return parentIndex * 2;
    }

    /** returns the index of the right child */
    private int rightChildIndex(int parentIndex){
        return parentIndex * 2 + 1;
    }

    /** Returns the number of items in the PQ. */
    @Override
    public int size(){
        return size;
    }

    /** Changes the priority of the given item. Throws NoSuchElementException if the item
     * doesn't exist. */
    @Override
    public void changePriority(T item, double priority){

        int nodeIndex = nodeIndexs.get(item);

        Node changing = heap.get(nodeIndex);
        changing.priority = priority;
        sink(nodeIndex);
        swim(nodeIndex);

    }

}
