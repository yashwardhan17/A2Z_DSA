package Math;

public class FourDivisors {
    public static void main(String[] args) {
        int[] arr = {21,7,5};
        System.out.println(fourDiv(arr));
    }

    static int fourDivisors(int[] arr){
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int insideSum = 0;
            cnt = 0;
            for (int j = 1; j <= arr[i]; j++) {
                if(arr[i] % j == 0) {
                    cnt++;
                    insideSum += j;
                }
                if (cnt == 4) {
                    sum += insideSum;
                }
            }
            if (sum == 0) return 0;
        }
        return sum;
    }

    static int fourDiv(int[] arr){
        int totalSum = 0;

        for (int val : arr) {
            int count = 0;
            int sum = 0;

            for (int i = 1; i * i <= val; i++) {
                if (val % i == 0) {
                    int d1 = i;
                    int d2 = val / i;

                    if (d1 == d2) {
                        count++;
                        sum += d1;
                    } else {
                        count += 2;
                        sum += d1 + d2;
                    }

                    if (count > 4) break;
                }
            }

            if (count == 4) {
                totalSum += sum;
            }
        }

        return totalSum;
    }
}
