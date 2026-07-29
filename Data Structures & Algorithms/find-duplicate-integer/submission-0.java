class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            fast = nums[nums[fast]];
            slow = nums[slow];

            if (fast == slow) {
                break;
            }
        }

        int first = 0;
        while (true) {
            first = nums[first];
            slow = nums[slow];

            if (first == slow) {
                break;
            }
        }

        return first;
    }
}
