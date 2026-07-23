class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, Comparator.comparingInt(car -> car[0]));

        Stack<Double> st = new Stack<>();

        int res = 1;
        for (int i = n - 1; i >= 0; i--) {
            double time = (double) (target - cars[i][0]) / cars[i][1];
            if (st.isEmpty() || st.peek() < time) {
                st.push(time);
            }
        }
        return st.size();
    }
}
