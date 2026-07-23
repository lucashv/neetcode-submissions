class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        int length = height.length;
        int maxHeight = findMaxHeight(height);
        int[][] matrix = createMatrix(height, maxHeight, length);

        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = 2;
            
            while (left < matrix[i].length && right < matrix[i].length) {
                if (left < right - 1 && matrix[i][left] == 2 && matrix[i][right] == 2) {
                    for (int x = left + 1; x < right; x++) {
                        if (matrix[i][x] != 2) {
                            matrix[i][x] = 1;
                        }
                    }
                }

                if (left < right -1) {
                    if (matrix[i][left] == 0) {
                        left++;
                    } else {
                        right++;
                    }
                } else {
                    right++;
                }
            }
        }

        return countWater(matrix);
    }

    private int countWater(int[][] matrix) {
        int waterCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    waterCount++;
                }
            }
        }
        return waterCount;
    }

    private int findMaxHeight(int[] height) {
        int length = height.length;
        int maxHeight = 0;
        for (int i = 0; i < length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
            }
        }
        return maxHeight;
    }

    private int[][] createMatrix(int[] height, int numLines, int numColumns) {
        int[][] matrix = new int[numLines][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[numColumns];
            for (int j = 0; j < numColumns; j++) {
                matrix[i][j] = (i < height[j] ? 2 : 0);
            }
        }

        return matrix;
    }
}
