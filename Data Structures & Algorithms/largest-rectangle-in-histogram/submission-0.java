class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = heights[0];
        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (st.isEmpty() || st.peek()[0] <= heights[i]) {
                st.push(new int[] {heights[i], i});
            } else {
                int k = Integer.MAX_VALUE;
                while (!st.isEmpty() && st.peek()[0] > heights[i]) {
                    int[] prevHeight = st.pop();
                    max = Math.max(prevHeight[0] * (i - prevHeight[1]), max);
                    k = Math.min(prevHeight[1], k);
                }
                st.push(new int[] {heights[i], k});
            }
        }

        while (!st.isEmpty()) {
            int[] prevHeight = st.pop();
            max = Math.max(prevHeight[0] * (n - prevHeight[1]), max);
        }
        return max;
    }
}