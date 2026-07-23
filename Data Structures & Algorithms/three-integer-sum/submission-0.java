class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int left = i+1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(temp);
                    left++;
                    right--;
                }
            }
        }

        return new ArrayList<>(res);
    }
}