public class OffByN implements CharacterComparator{


    public int N;

    /** returns true if characters are off by N in ascii values */
    @Override
    public boolean equalChars(char a, char b){
        return true;
    }

    /** constructor takes in an int used in equal Chars calc */
    public OffByN(int N){
        this.N = N;
    }



}
