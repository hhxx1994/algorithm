package three;

import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class LittleK {

    int[] arr;
    int size;

    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        this.arr = new int[k];
        for (int i = 0; i < k; i++) {
            add(arr[i]);
        }
        for (int j = k; j < arr.length; j++) {
            if (arr[j] < this.arr[0]) {
                this.arr[0] = arr[j];
                shifDown(0);
            }
        }
        Arrays.sort(this.arr);
        return this.arr;
    }

    private void shifDown(int index) {
        int shifIndex = leftChild(index);

        if (shifIndex >= size) {
            return;
        }

        int rightChild = rightChild(index);
        if (rightChild < size && arr[shifIndex] < arr[rightChild]) {
            shifIndex = rightChild;
        }
        if (arr[index] < arr[shifIndex]) {
            swap(index, shifIndex);
            shifDown(shifIndex);
        }
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(int val) {
        arr[size] = val;
        shifUp(size);
        size++;
    }

    private void shifUp(int index) {
        int parent = parent(index);
        if (parent < 0) {
            return;
        }

        if (arr[index] > arr[parent]) {
            swap(parent, index);
            shifUp(parent);
        }

    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public static void main(String[] args) {
        LittleK littleK = new LittleK();
        int[] ints = {62577,-220,-8737,-22,-6,59956,5363,-16699,0,-10603,64,-24528,-4818,96,5747,2638,-223,37663,-390,35778,-4977,-3834,-56074,7,-76,601,-1712,-48874,31,3,-9417,-33152,775,9396,60947,-1919,683,-37092,-524,-8,1458,80,-8,1,7,-355,9,397,-30,-21019,-565,8762,-4,531,-211,-23702,3,3399,-67,64542,39546,52500,-6263,4,-16,-1,861,5134,8,63701,40202,43349,-4283,-3,-22721,-6,42754,-726,118,51,539,790,-9972,41752,0,31,-23957,-714,-446,4,-61087,84,-140,6,53,-48496,9,-15357,402,5541,4,53936,6,3,37591,7,30,-7197,-26607,202,140,-4,-7410,2031,-715,4,-60981,365,-23620,-41,4,-2482,-59,5,-911,52,50068,38,61,664,0,-868,8681,-8,8,29,412};
        System.out.println(ints.length);
        littleK.smallestK(ints, 131);
    }
}
