package two;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huanghaoxing
 */
public class NextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        int[] ret = new int[nums.length];
        Arrays.fill(ret, -1);
        int n = nums.length;
        for (int i = 0; i < n * 2; i++) {
            int j = i % n;
            while (!deque.isEmpty() && nums[deque.peek()] < nums[j]) {
                ret[deque.pop()] = nums[j];
            }
            deque.push(j);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 1};
        new NextGreaterElements().nextGreaterElements(ints);
    }
}
