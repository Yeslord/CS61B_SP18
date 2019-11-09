public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> a=new LinkedListDeque<Character>();
        for (int i=0;i<word.length();i++) {
            a.addLast(word.charAt(i));
        }
        return a;
    }
    public boolean isPalindrome(String word) {
        //test for end of recursion
        if(word.length() < 2) {return true;}

        //check first and last character for equality
        else if(word.charAt(0) != word.charAt(word.length() - 1)){return false;}

        //recursion call
        return isPalindrome(word.substring(1, word.length() - 1));
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if(word.length() < 2) {return true;}

        //check first and last character for equality
        else if(cc.equalChars(word.charAt(0),word.charAt(word.length()-1))){
            return isPalindrome(word.substring(1, word.length() - 1),cc);
        }
        return false;
    }
    /** Can't use this since .equal for class is "==" by default, so after reverse there is no way to compare
    public Deque<Character> reverse(Deque<Character> d){
        if (d.size()<=1) {
            return d;
        }
        Character K =d.removeLast();
        reverse(d).addFirst(K);
        return d;
    }
    */
}
