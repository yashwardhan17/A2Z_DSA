package BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int hourly = 8;
        int n = piles.length;
        System.out.println(kokoEatingBananas(piles, n, hourly));
    }
    //use long in totalHours to avoid overflow
    static int kokoEatingBananas(int[] piles, int n, int h){
        int start = 1;
        int end = findmaxPile(piles, n);
        while(start <= end){
            int mid = start + ((end-start)/2);
            int totalhrs = totalHours(piles, mid, n);
            if (totalhrs <= h) {
                end = mid - 1;
            } else{
                start = mid+1;
            }
        }
        return start;
    }

    static int totalHours(int[] piles, int k, int n){
        int totalhrs = 0;

        for (int i = 0; i < n; i++) {
            totalhrs += (piles[i] + k - 1) / k; //(int) Math.ceil((double) piles[i] / k)
        }

        return totalhrs;
    }


    static int findmaxPile(int[] piles, int n){
        int max = piles[0];
        for (int i = 0; i < n; i++) {
            if(piles[i] > max){
                max = piles[i];
            }
        }
        return max;
    }
}
