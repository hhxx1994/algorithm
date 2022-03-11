import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class SpiralOrder54 {


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int R = matrix.length;
        int C = matrix[0].length;
        boolean[][] visited = new boolean[R][C];
        int row = 0;
        int colum = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        for (int i = 0; i < R * C; i++) {
            visited[row][colum] = true;
            ret.add(matrix[row][colum]);
            int nextr = row + dirs[dir][0];
            int nextc = colum + dirs[dir][1];

            if (nextc < 0 || nextc >= C || nextr < 0 || nextr >= R || visited[nextr][nextc]) {
                dir = (dir + 1) % 4;
            }
            row += dirs[dir][0];
            colum += dirs[dir][1];
        }

        return ret;
    }

}
