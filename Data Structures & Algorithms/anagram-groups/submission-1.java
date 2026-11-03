class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();

        for(String str : strs){
            int[] count = new int[26];
            for(char letter : str.toCharArray()){
                count[letter - 'a']++;
            }

            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }
}
