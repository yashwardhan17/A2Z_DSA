package Arrays_1D;

import java.util.Arrays;

public class RearrangeArrayElements {
    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
        int n = arr.length;
        System.out.println(Arrays.toString(ReArrangeBySign(arr, n)));
    }

    //T.C = O(n) and S.C = O(n) //Two passes
    static int[] RearrangeBySign(int[] arr, int n){
        int[] positiveArr = new int[n/2];
        int[] negativeArr = new int[n/2];
        int p = 0;
        int q = 0;

        for(int i : arr){
            if(i>0){
                positiveArr[p++] = i;
            } else {
                negativeArr[q++] = i;
            }
        }

        int[] result = new int[n];
        int i = 0, pos_i = 0, neg_i = 0;

        while (pos_i < p && neg_i < q) {
            result[i++] = positiveArr[pos_i++];
            result[i++] = negativeArr[neg_i++];
        }
        return result;
    }


    //Using Single Pass ////T.C = O(n) and S.C = O(n)
    static int[] ReArrangeBySign(int[] arr, int n){
        int[] result = new int[n];
        
        int pos = 0;
        int neg = 1;

        for(int i : arr){
            if(i > 0){
                result[pos] = i;
                pos += 2;
            } else{
                result[neg] = i;
                neg += 2;
            }
        }
        return result;
    }
}
