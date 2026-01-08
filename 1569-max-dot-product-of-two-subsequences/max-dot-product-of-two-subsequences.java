class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        int[] dp = new int[m + 1];
        for (int j = 0; j <= m; j++) dp[j] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int prev = Integer.MIN_VALUE; // dp[i-1][j-1]
            for (int j = 1; j <= m; j++) {
                int temp = dp[j]; // store old dp[i-1][j]

                int product = nums1[i - 1] * nums2[j - 1];

                dp[j] = Math.max(
                    product,
                    Math.max(
                        product + Math.max(0, prev),
                        Math.max(dp[j], dp[j - 1])
                    )
                );

                prev = temp;
            }
        }
        return dp[m];
    }
}
