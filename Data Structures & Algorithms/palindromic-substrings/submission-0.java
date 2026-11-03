class Solution {
    /*
        "abc" --> "a", "b", "c"
        "aaa" --> "a", "a", "a", "aa", "aa", "aa"

        "aaa"
        i = 1;
        start = 1;
        end = 1;

        start = i
        end = i + 1

        res = 6 (number of satisfied substrings)

        time complexity: O(n^2); space: O(1)
        expand center by two pointers
    */
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();

        // time: O(n^2)
        for(int i = 0; i < n; i++){
            int start = i;
            int end = i;
            while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)){
                res += 1;
                start--;
                end++;
            }

            start = i;
            end = i + 1;
            while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)){
                res += 1;
                start--;
                end++;
            }
        }

        return res;
    }
}
