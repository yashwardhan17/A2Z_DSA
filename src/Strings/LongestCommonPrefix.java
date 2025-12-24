package Strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(LCP(strs));
    }

    //T.C = O(n × m) : n = number of strings and m = length of the shortest string
    static String LCP(String[] strs){
        if (strs == null || strs.length == 0) {
            return "";
        }
        String first = strs[0];

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return prefix.toString();
                }
            }
            prefix.append(ch);
        }
        return prefix.toString();
    }
}
