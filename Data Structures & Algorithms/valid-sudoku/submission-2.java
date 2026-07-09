class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> seenInRow = new HashSet<>();
        Set<Character> seenInCol = new HashSet<>();
        Map<Integer, HashSet<Character>> seenInBox = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            seenInRow.clear();
            seenInCol.clear();

            for (int c = 0; c < board[0].length; c++) {
                char val = board[r][c];
                int box = ((c / 3) + (3 * (r / 3)));
                seenInBox.computeIfAbsent(box, k -> new HashSet<Character>());
                if (val != '.') {
                    if (seenInRow.contains(val)) {
                        return false;
                    }
                    seenInRow.add(val);

                    if (seenInBox.get(box).contains(val)) {
                        return false;
                    }
                    seenInBox.get(box).add(val);
                }

                val = board[c][r];
                if (val != '.') {
                    if (seenInCol.contains(val)) {
                        return false;
                    }
                    seenInCol.add(val);
                }
            }
        }

        return true;
    }
}
