package Strings;

public class IndexOfFirstOccurenceInString {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(firstOccurenceIdx(haystack, needle));
    }

    // We can use KMP method too (will study later on)
    // Better (direct comparison, no extra space)
    static int firstOccurenceIdx (String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) return i;
        }
        return -1;
    }
}
