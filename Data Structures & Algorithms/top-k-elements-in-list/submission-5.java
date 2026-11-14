class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] result = new int[k];
        int counter = 0;

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()){
            minHeap.offer(new int[] {key, map.get(key)});

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        while(!minHeap.isEmpty()){
            result[counter] = minHeap.poll()[0];
            counter++;
        }

        return result;
    }
}
