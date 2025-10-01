package Arrays_1D;

public class SecondLargestAndSecondSmallest {
    public static void main(String[] args) {
        int[] arr = {7, 3, 8, 2, 1};
        int n = arr.length;
        int Smallest2nd = find2ndSmallest(arr, n);
        int Largest2nd = find2ndLargest(arr, n);

        System.out.println(Smallest2nd);
        System.out.println(Largest2nd);
    }

    static int find2ndSmallest(int[] arr, int n){
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i] < min){
                min2 = min;
                min = arr[i];
            }
            else if(arr[i] < min2 && arr[i] != min){
                min2 = arr[i];
            }
        }
        return min2;
    }

    static int find2ndLargest(int[] arr, int n){
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if(arr[i] > max){
                max2 = max;
                max = arr[i];
            }
            else if(arr[i] > max2 && arr[i] != max){
                max2 = arr[i];
            }
        }
        return max2;
    }
}
