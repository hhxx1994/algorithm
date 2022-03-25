/**
 * @author huanghaoxing
 */
public class searchMatrix74 {

    //74. 搜索二维矩阵
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = n * m - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int r1 = mid / n;
            int c1 = mid % n;
            if (matrix[r1][c1] == target) {
                return true;
            } else if (matrix[r1][c1] < target) {
                l = mid + 1;
            } else if (matrix[r1][c1] > target) {
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 3}};
        new searchMatrix74().searchMatrix(ints, 3);
    }
}
