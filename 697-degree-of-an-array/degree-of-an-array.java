class Solution {
    public int findShortestSubArray(int[] nums) {

        // value -> [firstIndex, lastIndex, frequency]
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            if (!map.containsKey(x)) {
                map.put(x, new int[]{i, i, 1});
            } else {
                map.get(x)[1] = i;      // update last index
                map.get(x)[2]++;        // increase frequency
            }
        }

        int degree = 0;
        int ans = nums.length;

        for (int[] data : map.values()) {
            int first = data[0];
            int last = data[1];
            int freq = data[2];

            if (freq > degree) {
                degree = freq;
                ans = last - first + 1;
            } else if (freq == degree) {
                ans = Math.min(ans, last - first + 1);
            }
        }

        return ans;
    }
}
