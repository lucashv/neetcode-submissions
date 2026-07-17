class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxContainerSize = 0;

        while (left < right) {
            int currContainer = (right - left) * Math.min(heights[left], heights[right]);
            
            if (maxContainerSize < currContainer) {
                maxContainerSize = currContainer;
            }

            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        return maxContainerSize;
    }
}
