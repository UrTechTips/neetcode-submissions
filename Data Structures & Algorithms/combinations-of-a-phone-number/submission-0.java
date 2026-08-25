class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return new ArrayList<>();
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        List<String> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), map, digits, 0);
        return res;
    }

    void backtrack(List<String> res, List<Character> cur, HashMap<Character, List<Character>> map, String digits, int i) {
        if (i == digits.length()) {
            StringBuilder s = new StringBuilder(cur.size());
            for (char c: cur) {
                s.append(c);
            }
            res.add(s.toString());
            return;
        }

        char c = digits.charAt(i);
        List<Character> charactes = map.get(c);

        for (char alphabet: charactes) {
            cur.add(alphabet);
            backtrack(res, cur, map, digits, i+1);
            cur.remove(cur.size() - 1);
        }
    }
}
