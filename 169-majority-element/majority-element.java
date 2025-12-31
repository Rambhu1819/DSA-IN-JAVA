class Solution {
    public int majorityElement(int[] nums) {
     if(nums.length < 2) return nums[0];
     int cnt = 0;
     int el = 0;
        for(int x : nums){
            if(cnt == 0) el = x;
           cnt += (x == el) ? 1 : -1;
        }
        return el;
    }
}