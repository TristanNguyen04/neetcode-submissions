class Solution {
    /*

        [-4,-1,-1,-0,1,2]


    */
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 0; i < n; i++){
            int j = i + 1;
            int k = n - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
                    res.add(Arrays.asList(new Integer[] {nums[i], nums[j], nums[k]}));
                    j++;
                    k--;
                } else if (sum > 0){
                    k--;
                } else {
                    j++;
                }
            }
        }

        return new ArrayList<>(res);
    }
}
