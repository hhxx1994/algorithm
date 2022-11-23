package six;

public class QuickSort {

    public int[] sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        sort(nums, l, p - 1);
        sort(nums, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
