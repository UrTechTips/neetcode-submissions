class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> st = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, 0);

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && st.peek()[0] < temperatures[i]) {
                int[] temp = st.pop();
                res[temp[1]] = i - temp[1];
            }
            st.push(new int[] {temperatures[i], i});
        }
        return res;
    }
}
