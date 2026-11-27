class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        
        int[] map = new int[26];
        for(char letter : s.toCharArray()){
            map[letter-'a']++;
        }

        for(char letter : t.toCharArray()){
            if(map[letter-'a'] == 0){
                return false;
            }

            map[letter-'a']--;
        }

        return true;
    }
}
