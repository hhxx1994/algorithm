/**
 * @author huanghaoxing
 */
public class maxArea11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ret = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ret = Math.max(ret, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ret;
    }
}
