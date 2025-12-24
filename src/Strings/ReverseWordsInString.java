package Strings;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }
    static String reverseWords(String s){
        s = s.trim();
        String[] words = s.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if(i != 0){
                result.append(" ");
            }
        }
        return result.toString();
    }
}
