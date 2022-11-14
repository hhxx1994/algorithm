package one;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class findKthLargest215 {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int j = k; j < nums.length; j++) {
            if (nums[j] > queue.peek()) {
                queue.remove();
                queue.add(nums[j]);
            }
        }

        return queue.peek();
    }
}
