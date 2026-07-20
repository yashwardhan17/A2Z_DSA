package strings;

/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
Example 1: Input: s = "(()"    -> Output: 2 -> Explanation: The longest valid parentheses substring is "()".
Example 2: Input: s = ")()())" -> Output: 4 -> Explanation: The longest valid parentheses substring is "()()".
Example 3: Input: s = ""       -> Output: 0
 */

import java.util.Stack;

public class MoglixValidParentheses {
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    static int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int maxL = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    maxL = Math.max(maxL, i - st.peek());
                }
            }
        }
        return maxL;
    }
}
