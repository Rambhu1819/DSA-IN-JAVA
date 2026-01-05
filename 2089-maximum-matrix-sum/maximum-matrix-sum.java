class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negCount = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                sum += Math.abs(val);
                minAbs = Math.min(minAbs, Math.abs(val));
                if (val < 0) negCount++;
            }
        }

        return (negCount % 2 == 0) ? sum : sum - 2L * minAbs;
    }
}
