class Solution {
    /*
        {1: 1, 2:2, 3:3}
        --> 2, 3 (can be in any order)


    */

    // Time complexity: O(); Space:
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // max-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(Integer key : freq.keySet()){
            int[] pair = new int[]{key, freq.get(key)};
            pq.offer(pair);

            // if(pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        while(k > 0){
            k--;
            res[k] = pq.poll()[0];
        }

        return res;
    }
}
