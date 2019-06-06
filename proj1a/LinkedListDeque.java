public class LinkedListDeque<genericType>{

    private class Node{

        private Node previous;
        private genericType item;
        private Node next;

        private Node(Node p, genericType i, Node n) {

            previous = p;
            item = i;
            next = n;
        }

    }

    private int size;
    private Node sentFront;
    private Node sentBack;


    public LinkedListDeque(){
        sentFront = new Node(null, null, null);
        size = 0;
        sentBack = new Node(sentFront, null, null);
        sentFront.next = sentBack;

    }

    /** TODO deep copy

     public LinkedListDeque(genericType item){

     sentinel = new Node(null, null, null);
     sentinel.next = new Node(sentinel, item, null);
     size = 1;
     //last = sentinel.next;

     }

     */


    public genericType getFirst(){
        return sentFront.next.item;
    }

    public void addFirst(genericType item){
        size += 1;

        sentFront.next = new Node(sentFront, item, sentFront.next);
        sentFront.next.next.previous = sentFront.next;

    }

    public void addLast(genericType item){
        size += 1;

        sentBack.previous.next = new Node(sentBack.previous, item, sentBack);
        sentBack.previous = sentBack.previous.next;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public void printDeque(){

    }

    public genericType removeFirst(){
        size -= 1;
        genericType output = sentFront.next.item;

        sentFront.next = sentFront.next.next;
        sentFront.next.previous = sentFront;
        return output;
    }



    public static void main(String[] args) {
        LinkedListDeque test = new LinkedListDeque();
        test.addFirst(100);
        test.addLast(0);
        // test.getFirst();
    }

}