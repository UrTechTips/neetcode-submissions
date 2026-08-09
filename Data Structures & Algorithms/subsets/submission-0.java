class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        recur(nums, new ArrayList<>(), 0);
        return res;
    }

    void recur(int[] nums, List<Integer> cur, int k) {
            res.add(new ArrayList<>(cur));
            for (int i = k; i < nums.length; i++) {
                cur.add(nums[i]);
                recur(nums, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
    }
}