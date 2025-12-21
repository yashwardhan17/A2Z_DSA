package Arrays_1D;

public class MinNoDaysToMakeBouqets {
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,12,7,7};
        int n = arr.length;
        int bouqets = 2;
        int flowers = 3;
        System.out.println(toMakeMBouquets(arr, bouqets, flowers, n));
    }
    static int toMakeMBouquets(int[] arr, int bouqets, int flowers, int n){
        if(bouqets*flowers > n){
            return -1;
        }
        int start = findmin(arr, n);
        int end = findmax(arr, n);
        int result = -1;

        while(start <= end){
            int mid = start + ((end-start)/2);
            if(Possible(arr, mid, bouqets, flowers, n)) {
                result = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return result;
    }

    static boolean Possible(int[] arr, int days, int bouquets, int flowers, int n){
        int cnt = 0;
        int totalBouquets = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= days) {
                cnt++;
                if (cnt == flowers) {
                    totalBouquets++;
                    cnt = 0;
                }
            } else {
                cnt = 0; // break adjacency
            }
        }
        return totalBouquets >= bouquets;
    }


    static int findmax(int[] arr, int n){
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    static int findmin(int[] arr, int n){
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    /*private int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int x : arr) min = Math.min(min, x);
        return min;
    }

    private int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int x : arr) max = Math.max(max, x);
        return max;
    }*/

}
