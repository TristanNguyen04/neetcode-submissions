class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();

        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(complements.containsKey(nums[i])){
                return new int[] {complements.get(nums[i]), i};
            }

            complements.put(target - nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
