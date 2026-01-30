class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;

        // 1st pass: Find potential candidates
        for (int num : nums) {
            if (element1 == num) {
                cnt1++;
            } else if (element2 == num) {
                cnt2++;
            } else if (cnt1 == 0 && num != element2) {
                element1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0 && num != element1) {
                element2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // 2nd pass: Verify counts
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == element1) cnt1++;
            else if (num == element2) cnt2++;
        }

        // Threshold = n/3
        int threshold = nums.length / 3;
        List<Integer> result = new ArrayList<>();
        if (cnt1 > threshold) result.add(element1);
        if (cnt2 > threshold) result.add(element2);

        return result;
    }
}
