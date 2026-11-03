class Solution {
    /*
        {1: 1, 2:2, 3:3}
        --> 2, 3 (can be in any order)


    */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(Integer key : freq.keySet()){
            int[] pair = new int[]{key, freq.get(key)};
            pq.offer(pair);
        }

        int[] res = new int[k];
        while(k > 0){
            k--;
            int[] pair = pq.poll();
            System.out.println(pair[0]);
            res[k] = pair[0];
        }

        return res;
    }
}
