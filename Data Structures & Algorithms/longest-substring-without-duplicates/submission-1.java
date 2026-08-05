class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int n = s.length();
        int l = 0;
        int r = 1;
        int max = 1;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(l), 1);
        while (r < n) {
            if (map.getOrDefault(s.charAt(r), 0) == 0) {
                map.put(s.charAt(r), 1);
                r++;
            } else {
                map.put(s.charAt(l), 0);
                l++;
            }
            max = Math.max(max, r - l);
        }

        return max;
    }
}
