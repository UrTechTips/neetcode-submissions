class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        recur(res, nums, target, 0, new ArrayList<>());

        return res;
    }

    void recur(List<List<Integer>> res, int[] nums, int target, int i, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (nums[j] > target) continue;
            curr.add(nums[j]);
            recur(res, nums, target - nums[j], j, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
