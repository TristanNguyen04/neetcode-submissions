class Solution {
    /*
        [1,2,4,6]
        
        [1,1,2,8]
        [48,24,6,1]


        [48, 24, 12, 8]
    */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        int[] suffix = new int[n];
        suffix[n-1] = 1;

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
            suffix[n-i-1] = suffix[n-i] * nums[n-i];
        }

        for(int i = 0; i < n; i++){
            nums[i] = prefix[i] * suffix[i];
        }

        return nums;
    }
}  
