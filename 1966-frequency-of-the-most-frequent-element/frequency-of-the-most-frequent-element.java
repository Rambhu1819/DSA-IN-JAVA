class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int start = 0;
        int count = 0;

        for(int end = 0;end<nums.length;end++){
            sum += nums[end];
            while( ( ( (long)nums[end]*(end-start+1) )-sum) > k && start <= end){
                sum -= nums[start++];
            }
            count = Math.max(count,end-start+1);
        }
        return count;
    }
}
