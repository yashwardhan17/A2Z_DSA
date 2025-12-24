package Strings;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
//        String s = "hello";
//        char[] arr = s.toCharArray();

        System.out.println(Arrays.toString(Reverse(s)));
    }
    static char[] Reverse(char[] s){
        int start = 0;
        int end = s.length - 1;

        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
        return s;
    }
}
