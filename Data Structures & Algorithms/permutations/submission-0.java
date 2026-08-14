class Solution {
    List<List<Integer>> perms = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] added = new boolean[nums.length];
        recur(nums, new LinkedList<>(), added);
        return perms;
    }

    void recur(int[] nums, List<Integer> curr, boolean[] added) {
        if (curr.size() == nums.length) {
            perms.add(new LinkedList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (added[i] == true) continue;

            curr.add(nums[i]);
            added[i] = true;

            recur(nums, curr, added);

            curr.remove(curr.size() - 1);
            added[i] = false;
        }
    }
}
