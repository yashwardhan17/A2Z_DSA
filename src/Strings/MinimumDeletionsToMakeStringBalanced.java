package strings;

public class MinimumDeletionsToMakeStringBalanced {
    public static void main(String[] args) {
        String s = "bbbbaaaa";
        System.out.println(minimumDeletions(s));
    }

    // One line explanation : This is a DP problem where at each index we decide
    // whether to delete the current 'a' or delete all previous 'b's.
    // Since the DP only depends on the previous state, we can optimize it to constant space.
    // This is : DP with state compression
    // or DP one-pass solution
    // count all b's before 'a', and after encountering 'a'
    // see, what should we remove, 'a' or all b's before 'a'
    static int minimumDeletions(String s) {

        // Minimum deletions needed to keep the prefix balanced up to current index
        int minDeletions = 0;

        // Number of 'b' characters seen so far
        // Represents cost of deleting all previous 'b's
        int bCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            } else {
                minDeletions = Math.min(minDeletions + 1, bCount);
            }
        }
        return minDeletions;
    }

    // Greedy solution
    // alternative approach
    // this soln : deletes one character per conflict
    static int minimumDeletions1(String s) {
        int minDeletions = 0, bCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'b')
                bCount++;
            else if (bCount > 0) {  // it can be also : else if (c == 'a' && bCount > 0) : same thing
                minDeletions++;
                bCount--;
            }
        }
        return minDeletions;
    }
}
