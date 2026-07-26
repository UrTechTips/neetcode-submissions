class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);

        int min = 1;
        int max = piles[n - 1];
        int mid = 0;

        int res = Integer.MAX_VALUE;

        while (min <= max) {
            mid = min + ((max - min) / 2);
            int hours = 0;

            for (int i = 0; i < n; i++) {
                hours += (int) Math.ceil((double) piles[i] / mid);
            }

            if (hours > h) {
                min = mid + 1;
            } else {
                res = Math.min(mid, res);
                max = mid - 1;
            }
        }
        return res;
    }
}
