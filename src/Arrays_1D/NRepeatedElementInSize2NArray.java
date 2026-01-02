package Arrays_1D;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementInSize2NArray {
    public static void main(String[] args) {
        int[] arr = {5,1,5,2,5,3,5,4};
        System.out.println(repeatedNTimess(arr));
    }

    static int repeatedNTimes(int[] arr){
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == arr[i+1] || arr[i] == arr[i+2]){
                return arr[i];
            }
        }
        return arr[arr.length - 1];
    }

    //s.add will run first and mutate the set, then it will check the ! condition, if its true, then enter the if block
    static int repeatedNTimess(int[] arr){
        Set<Integer> s = new HashSet<>();

        for (int i : arr) {
            if(!s.add(i)) {
                return i;
            }
        }
        return arr[arr.length - 1];
    }
}
