package two;

/**
 * @author huanghaoxing
 */
public class SelectSort {

    public int[] selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        // arr[nextSwapIndex , n) 未排序 , arr[0,nextSwapIndex) 已排序
        for (int nextSwapIndex = 0; nextSwapIndex < arr.length; nextSwapIndex++) {
            int minIndex = nextSwapIndex;
            for (int i = nextSwapIndex; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }

            if(minIndex != nextSwapIndex){
                swap(nextSwapIndex, minIndex, arr);
            }
        }
        return arr;
    }

    private void swap(int nextSwapIndex, int minIndex, int[] arr) {
        int temp = arr[nextSwapIndex];
        arr[nextSwapIndex] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
        int[] result = new SelectSort().selectSort(new int[]{3, 2, 5, 7, 3, 8, 6, 9});
    }

}
