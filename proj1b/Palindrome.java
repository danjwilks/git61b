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

}