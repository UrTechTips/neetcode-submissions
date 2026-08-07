class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        StringBuilder res = new StringBuilder();
        int l = 0;
        int r;

        HashMap<Character, Integer> stringMap = new HashMap<>();
        // boolean found = false;
        int minLen = Integer.MAX_VALUE;
        int bestStart = -1;
        int bestEnd = -1;
        for (r = 0; r < n; r++) {
            char curr = s.charAt(r);
            stringMap.put(curr, stringMap.getOrDefault(curr, 0) + 1);

            if (isValid(map, stringMap) && r - l + 1 < minLen) {
                minLen = r - l + 1;
                bestStart = l - 1;
                bestEnd = r + 1;
            }

            while (isValid(map, stringMap)) {
                if (stringMap.get(s.charAt(l)) == 1) {
                    stringMap.remove(s.charAt(l));
                } else if (stringMap.keySet().contains(s.charAt(l))) {
                    stringMap.put(s.charAt(l), stringMap.get(s.charAt(l)) - 1);
                }
                l++;

                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    bestStart = l - 1;
                    bestEnd = r + 1;
                }
            }

        }

        if (minLen == Integer.MIN_VALUE) return "";
        
        for (int i = bestStart; i < bestEnd; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    boolean isValid(HashMap<Character, Integer> map, HashMap<Character, Integer> stringMap) {
        for (char letter: map.keySet()) {
            if (stringMap.getOrDefault(letter, 0) < map.get(letter)) {
                return false;
            }
        }
        return true;
    }
}
