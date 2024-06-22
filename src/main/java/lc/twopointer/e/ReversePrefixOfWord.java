package lc.twopointer.e;

public class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        int right = word.indexOf(ch);
        if(right == -1) {
            return word;
        }
        StringBuilder result = new StringBuilder(word);
        int left = 0;
        for(; right > left; right--) {
            result.setCharAt(left, word.charAt(right));
            result.setCharAt(right, word.charAt(left));
            left++;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        ReversePrefixOfWord rpow = new ReversePrefixOfWord();
        System.out.println(rpow.reversePrefix(word, ch));
    }
}
