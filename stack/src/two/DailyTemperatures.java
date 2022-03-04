package two;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huanghaoxing
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {

            while (!deque.isEmpty() && temperatures[deque.peek()] < temperatures[i]) {
                Integer pop = deque.pop();
                ret[pop] = i - pop;
            }
            deque.push(i);
        }
        return ret;

    }
}
