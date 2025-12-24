package Strings;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeParentheses(s));
    }

    static String removeParentheses(String s) {
        int depth = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (depth > 0) {
                    result.append(s.charAt(i));
                }
                depth++;
            }
            if (s.charAt(i) == ')') {
                depth--;
                if (depth > 0) {
                    result.append(s.charAt(i));
                }
            }
        }
        return result.toString();
    }
}
