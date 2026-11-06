class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        for(char letter : s.toCharArray()){
            freq[letter - 'a']++;
        }

        for(char letter : t.toCharArray()){
            if(freq[letter - 'a'] == 0){
                return false;
            }

            freq[letter - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                return false;
            }
        }

        return true;
    }
}
