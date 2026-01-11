package Strings;

public class SumOfBeautyOfSubstrings {
    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(beautySum(s));
    }

    //T.C = O(n^2 * 26)
    static int beautySum(String s){
        int n = s.length();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int maxF = 0;
                int minF = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        maxF = Math.max(maxF, freq[k]);
                        minF = Math.min(minF, freq[k]);
                    }
                }
                total += (maxF - minF);
            }
        }
        return total;
    }
}

