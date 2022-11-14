package one;

import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class largestNumber179 {

    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (String strNum : strNums) {
            sb.append(strNum);
        }
        String s = sb.toString();
        int left = 0;
        while (left < s.length() - 1 && s.charAt(left) == '0') {
            left++;
        }
        return s.substring(left);
    }
}
