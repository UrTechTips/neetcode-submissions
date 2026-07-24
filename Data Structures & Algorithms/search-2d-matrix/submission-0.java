class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int n = matrix[0].length;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (matrix[mid][0] <= target && matrix[mid][n-1] >= target) {
                break;
            } else if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low > high) return false;
        int[] row = matrix[low + ((high - low) / 2)];
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } 
        return false;
    }
}