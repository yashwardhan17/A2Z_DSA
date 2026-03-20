package strings;

public class RepeatedStringMatch {
    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println(repeatedStringMatch(a, b));
    }

    static int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int cnt = 0;

        // int minRep = (int) Math.ceil((double) b.length() /a.length());
        // We will use the idea of ceil but instead of computing ceil() using math,
        // We compute it naturally by growing the string to avoid casting and dealing with floating numbers
        // Instead of blindly repeating, compute minimum repetitions needed first.
        // To find the Minimum repetitions required so that length >= b

        while (sb.length() < b.length()) {
            sb.append(a);
            cnt++;
        }

        if (sb.indexOf(b) != -1) {
            return cnt;
        }

        for (int i = 0; i < 2; i++) {
            sb.append(a);
            cnt++;
            if (sb.indexOf(b) != -1) {
                return cnt;
            }
        }
        return -1;
    }
}
