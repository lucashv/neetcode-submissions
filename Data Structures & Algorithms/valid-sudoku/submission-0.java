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
                if (val != '.') {
                    if (seenInRow.contains(val)) {
                        System.out.println("Saw value " + val + " Exited on column " + c);
                        return false;
                    }
                    seenInRow.add(val);
                }

                val = board[c][r];
                if (val != '.') {
                    if (seenInCol.contains(val)) {
                        System.out.println("Saw value " + val + " Exited on line " + r);
                        return false;
                    }
                    seenInCol.add(val);
                }

                
                int box = ((c / 3) + (3 * (r / 3)));
                System.out.print("r = " + r + " - c = " + c);
                // System.out.println("rBox = " + rBox);
                // System.out.println("cBox = " + cBox);
                System.out.print(" -> box = " + box + "; ");

                seenInBox.computeIfAbsent(box, k -> new HashSet<Character>());
                val = board[r][c];
                if (val != '.') {
                    if (seenInBox.get(box).contains(val)) {
                        System.out.println("Saw value " + val + " Exited on box " + box);
                        return false;
                    }
                    seenInBox.get(box).add(val);
                }
            }
            System.out.println();
            System.out.println();
        }

        // return isValid();
        return true;
    }
}
