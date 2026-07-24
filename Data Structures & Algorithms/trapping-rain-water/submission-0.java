class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int currMax = 0;
        for (int i = 0; i < n; i++) {
            prefix[i] = currMax;
            currMax = Math.max(currMax, height[i]);
        }
        currMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = currMax;
            currMax = Math.max(currMax, height[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int water = Math.min(suffix[i], prefix[i]) - height[i];
            if (water > 0) res += water;
        }

        return res;
    }
}