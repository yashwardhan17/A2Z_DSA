package Arrays_1D;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int n = arr.length;
        System.out.println(MajorityEle(arr, n));

    }

    //T.C - O(n) //S.C - O(n)
    static int MajorityEle(int[] arr, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > n/2){
                return key;
            }
        }
        return -1;
    }
}
