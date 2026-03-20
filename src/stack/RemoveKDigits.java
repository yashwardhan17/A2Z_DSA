package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String s = "10";
        int k = 2;
//        RemoveKDigits rkd = new RemoveKDigits();
//        System.out.println(rkd.removeKdigits(s, k));
        System.out.println(removeKdigits(s, k));
    }

    static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char digits = num.charAt(i);
            while (!st.isEmpty() && k > 0 && st.peek() > digits) {
                st.pop();
                k--;
            }
            st.push(digits);
        }

        // remove remaining digits if k still > 0
        while (k > 0) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) return "0";

        // build result in reversed order
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        // remove trailing zeros
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }

        res.reverse();
        if (res.length() == 0) return "0";
        return res.toString();
    }

    static String removeKdigits2(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peekLast() > digit) {
                st.removeLast();
                k--;
            }
            st.addLast(digit);
        }

        // remove remaining digits from end
        while (k-- > 0 && !st.isEmpty()) {
            st.removeLast();
        }

        // build result
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.removeFirst());
        }

        // remove leading zeros
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') i++;

        String ans = res.substring(i);
        return ans.isEmpty() ? "0" : ans;
    }
}

// Check all solutions on Leetcode
// First solution is this one : we build the string in reversed order and then remove the trailing zeroes and then reverse the string again.
// second is building the string in correct order and then removing the leading zeroes.
// one solution is the combination of both.
// and last solution is using ArrayDeque
