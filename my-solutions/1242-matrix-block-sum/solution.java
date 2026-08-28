class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int sum = 0;

                int rowStart = Math.max(0, i - k);
                int rowEnd = Math.min(m - 1, i + k);
                int colStart = Math.max(0, j - k);
                int colEnd = Math.min(n - 1, j + k);

                for (int r = rowStart; r <= rowEnd; r++) {
                    for (int c = colStart; c <= colEnd; c++) {
                        sum += mat[r][c];
                    }
                }

                answer[i][j] = sum;
            }
        }

        return answer;
    }
}
