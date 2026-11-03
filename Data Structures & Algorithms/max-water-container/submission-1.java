class Solution {
    /*
        max = Math.max(min(heights[i], heights[j]) * (i - j), max)

        7

    */
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        int j = n - 1;

        int max = 0;

        while(i < j){
            int curr = Math.min(heights[i], heights[j]) * (j - i);

            if(curr > max){
                max = curr;
            }

            if(heights[i] < heights[j]){
                i++;
            } else if(heights[j] < heights[i]){
                j--;
            } else {
                i++;
                j--;
            }
        }

        return max;
    }
}
