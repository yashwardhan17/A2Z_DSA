package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(sortCh(s));
    }
    static String sortCh(String s){
        int[] freq = new int[256];
        for (int c : s.toCharArray()){
            freq[c]++;
        }

        List<Character>[] bucket = new List[s.length() + 1];
        for (int i = 0; i < 256; i++) {
            if(freq[i] > 0){
                int f = freq[i];
                if(bucket[f] == null){
                    bucket[f] = new ArrayList<>();
                }
                bucket[f].add((char) i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
