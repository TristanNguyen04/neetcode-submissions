class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int i = 0;
        HashSet<Character> seenSet = new HashSet<>();
        int result = 1;

        for(int j = 0; j < n; j++){
            char endLetter = s.charAt(j);
            while(seenSet.contains(endLetter)){
                char startLetter = s.charAt(i);
                seenSet.remove(startLetter);
                i++;
            }

            result = Math.max(result, j - i + 1);
            seenSet.add(endLetter);
        }

        return result;        
    }
}
