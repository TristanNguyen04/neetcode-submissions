class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        int j = n - 1;
        int maxArea = 0;

        while(i < j){
            int currentArea = Math.min(heights[i], heights[j]) * (j - i);

            if(currentArea > maxArea){
                maxArea = currentArea;
            }

            if(heights[i] < heights[j]){
                i++;
            } else if(heights[i] > heights[j]){
                j--;
            } else {
                i++;
                j--;
            }
        }

        return maxArea;
    }
}
