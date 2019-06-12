public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> deque = new LinkedListDeque<Character>();

        for (int i = 0;i<word.length();i++){
            deque.addLast(word.charAt(i));
        }

        return deque;

    }

    private Deque<Character> reverse(Deque<Character> deque){

        Deque<Character> reversed = new LinkedListDeque<Character>();
        for (int i =0; i<deque.size(); i++){
            char addToFront = deque.get(i);
            reversed.addFirst(addToFront);

        }
        return reversed;

    }

    public boolean isPalindrome(String word){

        Deque<Character> wordDeque = wordToDeque(word);

        Deque<Character> reversed = reverse(wordDeque);

        return wordDeque.equals(reversed);


    }

    public boolean isPalindrome(String word, CharacterComparator cc){

        Deque<Character> wordDeque = new LinkedListDeque<Character>();
        wordDeque = wordToDeque(word);
        Deque<Character> reversed = new LinkedListDeque<Character>();
        reversed = reverse(wordToDeque(word));

        boolean isPal = true;
        for (int i = 0; i<word.length(); i++){

            char char1 = wordDeque.get(i);
            char char2 = reversed.get(i);
            if (char1 == char2 || cc.equalChars(char1,char2)){
            } else {
                isPal = false;
            }

        }

        return isPal;

    }

}