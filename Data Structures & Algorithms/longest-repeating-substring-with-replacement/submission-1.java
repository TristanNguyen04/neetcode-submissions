class Solution {
    /*
        [A:3, B:3]
        7 - 4 = 3
    */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int max = 0;
        int j = 0;
        int i = 0;

        while(i < s.length()){
            freq[s.charAt(i) - 'A']++;
            max = Math.max(max, freq[s.charAt(i) - 'A']);

            if((i - j + 1) - max > k){
                freq[s.charAt(j) - 'A']--;
                j++;
            }
            i++;
        }

        return n - j;
    }
}
