class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] dp = new int[m + 1];

        // Base case: delete all characters from s2
        for (int j = 1; j <= m; j++) {
            dp[j] = dp[j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= n; i++) {
            int prev = dp[0];          // dp[i-1][0]
            dp[0] += s1.charAt(i - 1); // delete all from s1 prefix

            for (int j = 1; j <= m; j++) {
                int temp = dp[j];     // save old dp[i-1][j]

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prev;     // dp[i][j] = dp[i-1][j-1]
                } else {
                    dp[j] = Math.min(
                        dp[j] + s1.charAt(i - 1),   // delete from s1
                        dp[j - 1] + s2.charAt(j - 1) // delete from s2
                    );
                }

                prev = temp; // move dp[i-1][j] forward
            }
        }

        return dp[m];
    }
}
