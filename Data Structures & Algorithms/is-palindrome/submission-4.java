class Solution {
    /*  
        65 + 25 = 90
    
    */
    public boolean isPalindrome(String s) {
        int n = s.length();

        if(n <= 1) return true;

        int i = 0;
        int j = n - 1;

        while(i <= j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private boolean helper(char s){
        if(0 <= s && s <= 9){
            return true;
        }

        if(65 <= s && s <= 90){
            return true;
        }

        if(97 <= s && s <= 122){
            return true;
        }
        return false;
    }
}
