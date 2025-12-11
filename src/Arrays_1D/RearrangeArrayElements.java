package Arrays_1D;

import java.util.Arrays;

public class RearrangeArrayElements {
    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
        System.out.println();
    }

    static int[] RearrangeBySign(int[] arr, int[] negativeArr, int[] positiveArr){
        for (int i = 0; i < positiveArr.length; i++) {
            if(positiveArr[i] > 0){
                arr[i] = positiveArr[i];
            }
        }

        for (int i = 0; i < negativeArr.length; i++) {
            if(negativeArr[i] < 0){
                arr[i] = negativeArr[i];
            }
        }
    }

}
