package BinarySearch;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int n = weights.length;
        int days = 5;
        System.out.println(shipPackages(weights, n, days));
    }
    static int shipPackages(int[] weights, int n, int days){
//        int start = Arrays.stream(weights).max().getAsInt();
//        int end = Arrays.stream(weights).sum();

        int start = 0;
        int end = 0;

        for(int w : weights){
            start = Math.max(start, w);
            end += w;
        }

        while(start <= end){
            int mid = start + (end - start)/2;
            if(daysNeeded(weights, n, mid) <= days){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int daysNeeded(int[] weights, int n, int capacity){
        int days = 1;
        int currentLoad = 0;

        for(int w : weights){
            if(currentLoad + w > capacity){
                days++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }
        return days;
    }
}
