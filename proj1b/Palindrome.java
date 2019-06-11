public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> deque = new LinkedListDeque<Character>();

        for (int i = 0;i<word.length();i++){
            deque.addLast(word.charAt(i));
        }

        return deque;

    }

}