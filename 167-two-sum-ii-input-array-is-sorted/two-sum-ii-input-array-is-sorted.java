class Solution {
    public int[] twoSum(int[] numbers, int target) {
       // List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = numbers.length-1;
        while(i < j){
            int sum = numbers[i]+numbers[j];
            if(sum == target){
                return new int[] { i+1, j+1 };
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
       throw new IllegalArgumentException("No two sum solution");

    }
}