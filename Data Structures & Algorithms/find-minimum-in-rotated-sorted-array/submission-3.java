class Solution {
    /*
        5 / 2 = 2

        l = 3
        r = 5 --> mid = 4

        l = 3
        r = 4
    */
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while(l < r){
            int mid = l + (r - l)/2;

            if(nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[r];
    }
}
