public class ArrayDeque<item>{

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
    public void resize(){
        item[] newArr = (item[]) new Object[size*resizeFactor];
        System.arraycopy(items, nextFirst+1, newArr, 0, size - (nextFirst +1));
        System.arraycopy(items, 0, newArr, size - (nextFirst +1), nextFirst+1);
        nextFirst = newArr.length -1;
        nextLast = size;
        items = newArr;
    }

    public void addFirst(item i){
        if (size == items.length){
            resize();
        }
        items[nextFirst] = i;
        nextFirst --;
        size++;

    }

    public void addLast(item i){
        if (size == items.length){
            resize();
        }
        items[nextLast] = i;
        nextLast++;
        size++;
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