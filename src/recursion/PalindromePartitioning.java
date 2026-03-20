package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        findPalindrome(0, s, new ArrayList<>(), result);
        return result;
    }

    private static void findPalindrome(int index, String s,
                        List<String> palindrome,
                        List<List<String>> res) {


        if (index == s.length()) {
            res.add(new ArrayList<>(palindrome));
            return;
        }


        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                palindrome.add(s.substring(index, i + 1));
                findPalindrome(i + 1, s, palindrome, res);
                palindrome.remove(palindrome.size() - 1);
            }
        }
    }
}
