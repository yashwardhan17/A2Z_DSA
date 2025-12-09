package Arrays_1D;

public class NumberAppearsOnce {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3};
        int n = arr.length;
        System.out.println(NoAppearsOnceUsingXOR(arr, n));
    }

    //Brute //O(n^2)
    static int NoAppearsOnce(int[] arr, int n){
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(arr[j] == num){
                    count++;
                }
            }
            if(count == 1){
                return num;
            }
        }
        return -1;
    }

    //T.C = O(n)
    static int NoAppearsOnceUsingXOR(int[] arr, int n){
        int xor = 0;
        for (int x : arr) {
            xor ^= x; // xor = xor ^ x
        }
        return xor;
    }
}
