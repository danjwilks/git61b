public class ArrayDeque<item>{

    /** invariants:
     * size: is always the number of things in the items
     * nextFirst: is always the index of next first item
     * nextLast: is always the index of the next last item
     * */

    private item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int resizeFactor;
    private double usageFactor;

    public ArrayDeque(){

        items = (item[]) new Object[8];

        size = 0;
        nextFirst = items.length -1;
        nextLast = 0;
        resizeFactor = 2;
        usageFactor = 0.25;

    }
    private void resizeBigger(){
        item[] newArr = (item[]) new Object[size*resizeFactor];
        if (nextLast > nextFirst){
            for (int i = 0; i<size;i++){
                newArr[i] = items[(i+nextLast)%size];
            }
        } else {
            for (int i = 0; i<size;i++) {
                newArr[i] = items[(i + nextFirst) % size];
            }
        }
        items = newArr;

        nextFirst = items.length -1;
        nextLast = size;

    }

    public void addFirst(item i){

        items[nextFirst] = i;
        size++;

        if (nextFirst -1 == 0){
            nextFirst = items.length -1;
        } else {
            nextFirst --;
        }
        if (size == items.length) {
            resizeBigger();
        }


    }

    public void addLast(item i){

        items[nextLast] = i;
        size++;

        if (nextLast == items.length) {
            nextLast = 0;
        } else {
            nextLast ++;
        }

        if (size == items.length){
            resizeBigger();
        }

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    private void resizeSmaller(){
        double usage = (double) size / items.length;
        if (usage < usageFactor){

            int itemLength = items.length / 2;

            item[] newArr = (item[]) new Object[itemLength];

            for (int i = 0; i<itemLength;i++) {
                newArr[i] = items[(i + nextFirst + 1) % items.length];
            }
            items = newArr;

            nextFirst = items.length -1;
            nextLast = size;



        }

    }

    // TODO create removeFirst
    public item removeFirst(){
        if (size == 0){
            return null;
        } else {

            int first = nextFirst + 1;

            if (first == items.length) {
                first = 0;
                nextFirst = 0;
            } else {
                nextFirst++;
            }
            size--;
            item output = items[first];
            items[first] = null;
            resizeSmaller();
            return output;

        }

    }
    // TODO create removeLast
    public item removeLast(){

        if (size == 0){
            return null;
        } else {

            int last = nextLast - 1;

            if (last == -1) {
                last = items.length - 1;
                nextLast = last;
            } else {
                nextLast--;
            }
            size--;
            item output = items[last];
            items[last] = null;
            resizeSmaller();
            return output;

        }

<<<<<<< HEAD
=======

    }
>>>>>>> f04c6fc88d9b0566e628ebd19ecc2e67f669a72a

    public item get(int index){
        return items[(index + nextFirst + 1)%items.length];
    }

    public item get(int index){
        return items[(index + nextFirst + 1)%items.length];
    }


    public void printDeque(){
        for (int i = 0; i<size; i++){
            System.out.print(items[ (nextFirst + i +1)%(items.length)]);
            if (i == size -1){
                System.out.print("\n");
            } else {
                System.out.print(" ");
            }
        }
    }

<<<<<<< HEAD
=======
    public static void main(String[] args) {
        ArrayDeque test = new ArrayDeque();
        test.addFirst(2);
        test.addFirst(1);
        test.addLast(3);
        test.addLast(4);
        test.addLast(5);
        test.addLast(6);
        test.addLast(7);
        test.addLast(8);
        test.addLast(9);
        test.addLast(10);
        test.addFirst(-1);
        test.addFirst(-2);
        test.addFirst(-3);
        test.addFirst(-4);
        test.addFirst(-5);
        test.addFirst(-6);
        test.addFirst(-7);
        test.addFirst(-8);
        test.addLast(11);
        test.addLast(12);

        test.removeFirst();

        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.addLast(11);
        test.addLast(12);
        test.addFirst(-4);
        test.addFirst(-5);
        test.addFirst(-6);
        test.addFirst(-7);


        test.printDeque();

        //System.out.println(test.get(10));
    }







>>>>>>> f04c6fc88d9b0566e628ebd19ecc2e67f669a72a
}