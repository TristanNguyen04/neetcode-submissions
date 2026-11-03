class Solution {
    /*
        [A:3, B:4]
        6 - 2 = 4
    */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int max = 0;
        int res = 0;

        int l = 0;

        for(int r = 0; r < n; r++){
            freq[s.charAt(r) - 'A']++;
            max = Math.max(max, freq[s.charAt(r) - 'A']);

            while((r - l + 1) - max > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
