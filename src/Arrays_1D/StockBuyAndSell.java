package Arrays_1D;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int n = arr.length;
        System.out.println(BestTime(arr, n));
    }

    //Brute //T.C - O(n^2)
    static int BestTime2(int[] arr, int n){
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int Profit = arr[j] - arr[i];
                maxProfit = Math.max(maxProfit, Profit);
            }
        }
        return maxProfit;
    }

    //O(n)
    static int BestTime(int[] arr, int n){
        int min = arr[0];
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            int profit = arr[i] - min;
            maxProfit = Math.max(profit, maxProfit);
            min = Math.min(min, arr[i]);
        }
        return maxProfit;
    }
}
