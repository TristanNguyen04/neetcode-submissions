class Solution {

    /*
        {1:1, 2:2, 3:3}
        min-heap:
        2 3

        pq: [key, freq]



    */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(Integer key : freq.keySet()){
            pq.offer(new int[] {key, freq.get(key)});
            if(pq.size() > k) pq.poll();
        }

        int[] res = new int[k];

        while(k > 0){
            k--;
            res[k] = pq.poll()[0];
        }

        return res;
    }
}
