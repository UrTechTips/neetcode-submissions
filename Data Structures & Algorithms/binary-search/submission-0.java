class Solution {
    public int search(int[] nums, int target) {
        return recur(nums, target, 0, nums.length - 1);
    }

    static int recur(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + ((right - left) / 2);
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return recur(nums, target, left, mid-1);
        } else {
            return recur(nums, target, mid + 1, right);
        }
    }
}