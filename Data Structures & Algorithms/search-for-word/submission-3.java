class Solution {
    HashSet<int[]> visited = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0) == true) {
                    System.out.println(i + " " + j);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (word.length() == index) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;

        if (word.charAt(index) != board[i][j]) return false;

        char temp = board[i][j];
        board[i][j] = '#';
        boolean found =  dfs(board, i + 1, j, word, index + 1) ||
            dfs(board, i, j + 1, word, index + 1) || 
            dfs(board, i - 1, j, word, index + 1) || 
            dfs(board, i, j - 1, word, index + 1);
        board[i][j] = temp;

        return found;
    }
}
