package recursion;

public class PalindromeString {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isClean(s));
    }

    // Using recursion
    // cleaning string in another method
    // cleaned string is passed to the recursive fn
    static boolean isClean(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindromeRec(cleaned, 0);
    }

    static boolean isPalindromeRec(String s, int i) {
        if (i >= s.length() / 2) return true;

        if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        return isPalindromeRec(s, i + 1);
    }
}
