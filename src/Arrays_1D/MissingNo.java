package Arrays_1D;

public class MissingNo {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5};
        int n = arr.length+1;
        System.out.println(mNo2(arr, n));
    }
    //BRUTE FORCE SOLUTION //O(n^2)
    static int mNo(int[] arr, int n){
        for (int i = 1; i < n; i++) {
            int flag = 0;
            for (int j = 0; j < n-1; j++) {
                if(arr[j]==i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return i;
            }
        }
        return -1;
    }

    //BETTER APPROACH USING HASH ARRAY //T.C is O(n) and Space is also O(n)
    static int mNo2(int[] arr, int n){
        int[] hash = new int[n+1];
        for(int i : arr){
            hash[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if(hash[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
