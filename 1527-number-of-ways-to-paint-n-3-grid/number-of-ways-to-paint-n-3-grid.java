class Solution {
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;

        long diff = 6; // Type A (all colors different)
        long same = 6; // Type B (two same, one different)

        for (int i = 2; i <= n; i++) {
            long newDiff = (2 * diff + 2 * same) % MOD;
            long newSame = (2 * diff + 3 * same) % MOD;
            diff = newDiff;
            same = newSame;
        }

        return (int)((diff + same) % MOD);
    }
}
