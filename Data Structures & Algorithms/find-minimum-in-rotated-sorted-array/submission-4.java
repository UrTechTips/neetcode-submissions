class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int left = 0;
        int min = nums[left];
        int right = n - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] >= min) {
                left = mid + 1;
            } else if (nums[mid] < min) {
                min = Math.min(nums[mid], min);
                right = mid - 1;
            }
        }

        return min;
    }
}
