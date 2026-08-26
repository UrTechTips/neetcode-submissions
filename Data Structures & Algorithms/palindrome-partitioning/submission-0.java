class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;  
    }

    void backtrack(List<List<String>> res, List<String> cur, String s, int k) {
        if (isPalindrome(s)) {
            cur.add(s);
            res.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
        }


        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i, s.length());

            if (isPalindrome(s1)) {
                cur.add(s1);
                backtrack(res, cur, s2, i);
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        if (s.equals("")) return true;
        return new StringBuilder().append(s).reverse().toString().equals(s);
    }
}
