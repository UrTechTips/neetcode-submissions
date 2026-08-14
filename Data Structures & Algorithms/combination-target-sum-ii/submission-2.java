class Solution {
    HashSet<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recur(candidates, target, new LinkedList<>(), 0);
        return new ArrayList<>(res);
    }

    void recur(int[] candidates, int target, List<Integer> curr, int i) {
        if (target == 0) {
            // Collections.sort(curr);
            res.add(new LinkedList(curr));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            int candidate = candidates[j];
            if (candidate > target) continue;
            if (j > i && candidates[j - 1] == candidates[j]) continue;
            
            curr.add(candidate);
            recur(candidates, target - candidate, curr, j + 1);
            curr.remove(curr.size() - 1);
        }
    }
}