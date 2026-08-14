class Solution {
    HashSet<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        recur(nums, new LinkedList<>(), 0);
        return new LinkedList<>(res);
    }

    void recur(int[] nums, List<Integer> cur, int i) {
        res.add(new LinkedList<>(cur));

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j - 1] == nums[j]) continue;
            
            cur.add(nums[j]);
            recur(nums, cur, j + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
