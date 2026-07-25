class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int person = 0;
        int cookie = 0;
        int res = 0;

        while (person < g.length && cookie < s.length) {
            if (g[person] <= s[cookie]) {
                res++;
                person++;
                cookie++;
            } else if (g[person] > s[cookie]) {
                cookie++;
            }
        }
        return res;
    }
}