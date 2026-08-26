class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, 0);
        return res;
    }

    void backtrack(List<List<String>> res, List<String> cur, int n, int row) {
        if (row == n) {
            res.add(new ArrayList<>(cur));
            return;
        }

        String dots = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            if (isValidPlacement(cur, row, i, n)) {
                StringBuilder s = new StringBuilder().append(dots);
                s.setCharAt(i, 'Q');
                cur.add(s.toString());
                backtrack(res, cur, n, row +  1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean isValidPlacement(List<String> cur, int i, int j, int n) {
        if (cur.size() <= 0) return true;

        for (String s: cur) {
            if (s.charAt(j) == 'Q') return false; 
        }

        int target = i + j;
        int diffTarget = i - j;
        for (int k = 0; k < cur.size(); k++) {
            String s = cur.get(k);
            if (target - k >= 0 && target - k < n && s.charAt(target - k) == 'Q') return false;
            if (k - diffTarget >= 0 && k - diffTarget < n && s.charAt(k - diffTarget) == 'Q') return false;
        }
        return true;
    }
}
