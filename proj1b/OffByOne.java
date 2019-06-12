public class OffByOne implements CharacterComparator{


    @Override
    public boolean equalChars(char a , char b){
        int diff = Math.abs(a - b);
        return 1 == diff;

    }





}
