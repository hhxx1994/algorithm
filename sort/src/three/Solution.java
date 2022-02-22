package three;


class Solution {
    int ret;

    public int reversePairs(int[] nums) {
        sort(nums, 0, nums.length);
        return ret;
    }

    // arr[start,end)
    public void sort(int[] arr, int start, int end) {
        if (start >= end - 1) {
            return;
        }

        int middle = start + (end - start) / 2;
        sort(arr, start, middle);
        sort(arr, middle, end);
        merge(arr, start, middle, end);

    }

    public void merge(int[] arr, int start, int middle, int end) {
        int[] temp = new int[end - start];

        int i = start;
        int j = middle;
        for (int k = 0; k < temp.length; k++) {

            if (i == middle) {
                temp[k] = arr[j];
                j++;
            } else if (j == end) {
                temp[k] = arr[i];
                i++;
            } else if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
                ret += middle - i;
            }
        }
        System.arraycopy(temp, 0, arr, start, temp.length);

    }

    public static void main(String[] args) throws Exception {

    }


}