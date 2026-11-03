class Solution {
    /*
        3 - 1
        {2:3, 20:1, 4:3, 10:1, 3:3}
    
    */
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int res = 0;
    
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, map.getOrDefault(num - 1, 0) + map.getOrDefault(num + 1, 0) + 1);

                map.put(num - map.getOrDefault(num - 1, 0), map.get(num));
                map.put(num + map.getOrDefault(num + 1, 0), map.get(num));

                res = Math.max(res, map.get(num));
            }
        }

        return res;
    }
}
