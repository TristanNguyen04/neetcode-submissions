class Solution {
    /*

    
    */
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        return Math.max(robRange(0, n - 2, nums), robRange(1, n - 1, nums));
    }

    private int robRange(int start, int end, int[] nums){
        int n = end - start + 1;
        if(n == 1){
            return nums[start];
        }
        int[] dp = new int[n];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]); 
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[start + i]);
        }

        return dp[n-1];
    }
}
