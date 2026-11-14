class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while(left < right){
            int mid = (right - left)/2 + left;

            if(nums[mid] > nums[right]){
                left++;
            } else {
                right--;
            }
        }

        return nums[left];
    }
}
