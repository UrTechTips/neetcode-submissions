class Solution {
    HashSet<String> res = new HashSet<>();
    public List<String> generateParenthesis(int n) {
        recur(new StringBuilder(), n);
        return new ArrayList<>(res);
    }

    void recur(StringBuilder cur, int t) {
        if (t == 0) {
            res.add(cur.toString());
            return;
        }
        for (int i = 0; i <= cur.length(); i++) {
            cur.insert(i, "()");
            recur(cur, t - 1);
            cur.delete(i, i+2);
        }
    }
}
