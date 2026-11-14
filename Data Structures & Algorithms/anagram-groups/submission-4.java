class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();

        for(String str : strs){
            int[] count = new int[26];

            for(char letter : str.toCharArray()){
                count[letter - 'a']++;
            }

            String key = Arrays.toString(count);
            if(!result.containsKey(key)){
                result.put(key, new ArrayList<>());
            }

            result.get(key).add(str);
        }

        return new ArrayList<>(result.values());
    }
}
