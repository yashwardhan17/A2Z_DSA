package Arrays_1D;

public class MaxConsecutive1s {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1,0,1,1};
        int n = arr.length;
        System.out.println(Max1s(arr, n));
    }

    //O(n)
    static int Max1s(int[] arr, int n){
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 1){
                count++;
                max = Math.max(max, count);
            }
            else{
                count = 0;
            }
        }
        return max;
    }
}
