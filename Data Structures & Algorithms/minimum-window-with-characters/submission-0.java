class Solution {
    /*
        "OUZODYXAZV"
        "XYZ"

        [X:1; Y:1, Z:1]    
    */
    public String minWindow(String s, String t) {
        int n = s.length();
        int counter = t.length();

        int[] freq = new int[128];

        for(char c : t.toCharArray()){
            freq[c]++;
        }

        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        while(end < n){
            if(freq[s.charAt(end)] > 0) counter--;

            freq[s.charAt(end)]--;
            end++;

            while(counter == 0){
                if(minLen > end - start){
                    minLen = end - start;
                    minStart = start;
                }

                freq[s.charAt(start)]++;
                if(freq[s.charAt(start)] > 0) counter++;
                start++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
