package Strings;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;

        // Step 1: skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: count last word length
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
