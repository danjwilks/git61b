public class ArrayDeque<item>{

    /** invariants:
     * size: is always the number of things in the items
     * nextFirst: is always the index of next first item
     * nextLast: is always the index of the next last item
     * */

    item[] items;
    int size;
    int nextFirst;
    int nextLast;
    int resizeFactor;

    public ArrayDeque(){

        items = (item[]) new Object[8];

        size = 0;
        nextFirst = items.length -1;
        nextLast = 0;
        resizeFactor = 2;

    }
    // TODO update resize to be able to cope with remove
    public void resizeBigger(){
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
    // TODO create removeFirst
    public void removeFirst(){



    }
    // TODO create removeLast
    public void removeLast(){

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
        test.printDeque();
    }







}