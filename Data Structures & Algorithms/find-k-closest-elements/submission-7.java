class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();

        int left = 0;
        int right = left + k;

        while (right < arr.length && (arr[right] - x) < (x - arr[left])) {
            right++;
            left++;
        }

        for (int i = left; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}