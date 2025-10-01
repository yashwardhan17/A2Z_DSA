package Arrays_1D;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 5, 6, 6, 10, 10 ,10};
        int n = arr.length;
        System.out.println(removee(arr, n));
        System.out.println(Arrays.toString(arr));
    }
    //O(n) //two pointer works only on sorted arrays
    static int removee(int[] arr, int n){
        int i = 0;
        for (int j = 1; j < n; j++) {
            if(arr[i] != arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }
    //O(n) //using extra space but works on both i.e sorted and unsorted
    static int remove(int[] arr, int n){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        return set.size();
    }
}
