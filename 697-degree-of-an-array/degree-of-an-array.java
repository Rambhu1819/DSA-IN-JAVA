class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            freq.put(x, freq.getOrDefault(x, 0) + 1);
            first.putIfAbsent(x, i);
            last.put(x, i);
        }

        int degree = 0;
        int ans = nums.length;

        for (int key : freq.keySet()) {
            if (freq.get(key) > degree) {
                degree = freq.get(key);
                ans = last.get(key) - first.get(key) + 1;
            } else if (freq.get(key) == degree) {
                ans = Math.min(ans, last.get(key) - first.get(key) + 1);
            }
        }

        return ans;
    }
}
