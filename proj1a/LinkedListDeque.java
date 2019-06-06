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
    private Node sentinel;

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        size = 0;
        sentinel.next = sentinel;
        sentinel.previous = sentinel;

    }



    public LinkedListDeque(LinkedListDeque other){

        LinkedListDeque copy = new LinkedListDeque();

        for (int i = 0; i<other.size(); i++){
            copy.addLast(other.get(i));
        }

    }

    public genericType getFirst(){
        return sentinel.next.item;
    }

    public void addFirst(genericType item){
        size += 1;
        sentinel.next = new Node(sentinel, item, sentinel.next);

        sentinel.next.next.previous = sentinel.next;

    }

    public void addLast(genericType item){
        size += 1;

        sentinel.previous = new Node(sentinel.previous, item, sentinel);

        sentinel.previous.previous.next = sentinel.previous;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        } else {
            return false;
        }
    }

    public void printDeque(){
        Node ptr = sentinel.next;
        while (ptr.item != null){
            System.out.print(ptr.item);
            ptr = ptr.next;
        }
        System.out.println("");
    }

    public genericType removeFirst(){
        if (size > 0) {

            size -= 1;
            genericType output = sentinel.next.item;

            sentinel.next = sentinel.next.next;
            sentinel.next.previous = sentinel;
            return output;
        } else {
            return null;
        }

    }

    public genericType get(int index){
        if (size >= index + 1) {

            Node ptr = sentinel;
            for (int i = 0; i <= index; i++) {
                ptr = ptr.next;
            }
            return ptr.item;

        } else{
            return null;
        }
    }

    public genericType getRecursive(int index) {

        return this.recursiveHelper(index, this.sentinel);
    }

    public genericType recursiveHelper(int index, Node n){
        if (index == 0){
            return n.item;

        } else {
            n = n.next;
            return recursiveHelper(index - 1, n);
        }
    }






    public static void main(String[] args) {
        LinkedListDeque test = new LinkedListDeque();
        test.addFirst(100);
        test.addFirst(10);
        test.addFirst(1);
        test.addFirst(0);
        test.removeFirst();
        test.removeFirst();
       // test.addLast(0);
        // test.getFirst();
    }

}