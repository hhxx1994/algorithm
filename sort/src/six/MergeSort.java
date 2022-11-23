package six;


public class MergeSort {

    public int[] sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    // [l,mid] [mid+1,r]
    private void merge(int[] nums, int l, int mid, int r) {
        int[] newarr = new int[r - l + 1];
        int i = l;
        int j = mid + 1;

        for (int k = 0; k < newarr.length; k++) {
            if (i > mid) {
                newarr[k] = nums[j];
                j++;
                continue;
            }
            if (j > r) {
                newarr[k] = nums[i];
                i++;
                continue;
            }
            if (nums[i] < nums[j]) {
                newarr[k] = nums[i];
                i++;
            } else {
                newarr[k] = nums[j];
                j++;
            }
        }

        System.arraycopy(newarr, 0, nums, l, newarr.length);
    }

}
