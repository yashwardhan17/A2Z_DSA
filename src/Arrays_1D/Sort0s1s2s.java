package Arrays_1D;

import java.util.Arrays;

public class Sort0s1s2s {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(SortColors(nums)));
    }

    //Dutch National FLag //O(n)
    static int[] SortColors(int[] nums){
        int n = nums.length;
        int i=0;
        int j=0;
        int k=n-1;


        while(j<=k) {

            if (nums[j]==1) {
                j++;
            }
            else if(nums[j]==2) {
                int temp = nums[j];
                nums[j]=nums[k];
                nums[k]=temp;
                k--;
            }
            else {
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                i++;
                j++;
            }
        }
        return nums;
    }
}
