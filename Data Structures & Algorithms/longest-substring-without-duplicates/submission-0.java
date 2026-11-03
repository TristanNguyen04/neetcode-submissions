class Solution {
    /*
        zxy 

    */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;

        boolean[] visited = new boolean[1000];
        int max = 0;

        while(j < n){
            while(visited[s.charAt(j)]){
                visited[s.charAt(i)] = false;
                i++;
            }

            visited[s.charAt(j)] = true;
            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
    }
}
