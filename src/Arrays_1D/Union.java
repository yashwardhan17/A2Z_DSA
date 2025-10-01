package Arrays_1D;

import java.util.*;

public class Union {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {2, 3, 4, 4, 5};
        int n = arr1.length;
        int m = arr2.length;
        //ArrayList<Integer> Union = FindUnion(arr1, arr2, n, m);
        //System.out.println(Arrays.toString(Union.toArray()));
        //System.out.println(Union);
        System.out.println(Union(arr1, arr2, n, m));
    }
    static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
        TreeSet<Integer> set = new TreeSet<>();

        // Insert all elements of arr1
        for (int i = 0; i < n; i++) set.add(arr1[i]);

        // Insert all elements of arr2
        for (int i = 0; i < m; i++) set.add(arr2[i]);

        // Convert TreeSet to ArrayList
        return new ArrayList<>(set);
    }
    public static ArrayList<Integer> Union(int[] arr1, int[] arr2, int n, int m){
        ArrayList<Integer> res = new ArrayList<>();
        Integer last = null;
        int i = 0, j = 0;
        while(i<n && j<m) {
            int value;
            if (arr1[i] <= arr2[j]) {
                value = arr1[i];
                i++;
            } else {
                value = arr2[j];
                j++;
            }
            if(last == null || last != value){
                res.add(value);
                last = value;
            }
        }
        while(i<n){
            int value;
            value = arr1[i];
            i++;
            if(last == null || last != value){
                res.add(value);
                last = value;
            }
        }
        while(j<m){
            int value;
            value = arr2[j];
            j++;
            if(last == null || last != value){
                res.add(value);
                last = value;
            }
        }
        return res;
    }
}
