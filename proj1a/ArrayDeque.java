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

}