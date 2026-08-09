class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            q.add(new int[] {nums[i], i});
        }
        int idx = 0;
        res[idx++] = q.peek()[0];

        for (int i = k; i < n; i++) {
            q.offer(new int[] {nums[i], i});

            while (q.peek()[1] < i-k+1) {
                q.poll();
            }
            res[idx++] = q.peek()[0];
        }
        
        return res;
    }
}