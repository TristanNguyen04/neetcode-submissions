class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        HashSet<Integer> seenSet = new HashSet<>();
        int result = 1;

        for(int num : nums){
            seenSet.add(num);
        }

        for(int key : seenSet){
            if(!seenSet.contains(key - 1)){
                int intermediate = 1;

                while(seenSet.contains(key + 1)){
                    intermediate++;
                    key++;
                }

                result = Math.max(intermediate, result);
            }
        }

        return result;
    }
}
