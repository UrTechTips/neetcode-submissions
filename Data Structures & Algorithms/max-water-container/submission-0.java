class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxWater = Integer.MIN_VALUE;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int waterCanHold = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(waterCanHold, maxWater);

            if (height[left] < height[right]) {
                left++;
            } else if (height[right] < height[left]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxWater;
    }
}