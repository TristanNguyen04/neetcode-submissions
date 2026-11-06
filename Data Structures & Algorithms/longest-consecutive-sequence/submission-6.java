class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int result = 1;

        for(int num : nums){
            set.add(num);
        }

        for(int key : set){
            int immediate = 1;
            if(!set.contains(key - 1)){
                while(set.contains(key + 1)){
                    immediate++;
                    key++;
                }

                result = Math.max(result, immediate);
            }
        }

        return result;
    }
}
