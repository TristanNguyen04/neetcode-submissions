class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while(l < r){
            int mid = (r - l)/2 + l;

            if(nums[mid] > nums[r]){
                l++;
            } else {
                r--;
            }
        }

        return nums[l];
    }
}
