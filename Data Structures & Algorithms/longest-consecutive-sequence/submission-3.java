class Solution {
    /*
       nlogn 

       2,3,4,4,5,10,20
    
    */
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        Arrays.sort(nums);
        int i = 0;
        int max = 1;
        int streak = 0;
        int curr = nums[0];

        while(i < n){
            if(curr != nums[i]){
                curr = nums[i];
                streak = 0;
            }

            while(i < n && nums[i] == curr){
                i++;
            }

            streak++;
            curr++;
            max = Math.max(streak, max);
        }

        return max;
    }
}
