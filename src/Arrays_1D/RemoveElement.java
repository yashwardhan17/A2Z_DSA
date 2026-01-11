package Arrays_1D;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        System.out.println(removeElement(arr, 3));
    }
    static int removeElement(int[] arr, int val) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != val) {
                arr[cnt] = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}
