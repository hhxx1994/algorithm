/**
 * @author huanghaoxing
 */
public class rotate48 {

    public void rotate(int[][] matrix) {

        // 对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int left = 0;
        int right = matrix[0].length - 1;
        while (left < right) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new rotate48().rotate(ints);
    }
}
