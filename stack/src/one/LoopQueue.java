package one;

/**
 * @author huanghaoxing
 * 循环队列
 */
public class LoopQueue {

    private int[] array;
    private int head;
    private int tail;
    private int length;

    public LoopQueue(int size) {
        array = new int[size];
    }

    public int getSize() {
        return length;
    }

    public void enqueue(int data) {
        if ((tail + 1) % array.length == head) {
            array = resize();
        }

        array[tail] = data;
        tail = (tail + 1) % array.length;
        length++;
    }


    private int[] resize() {
        // 扩容
        int[] newArray = new int[array.length << 1];
        for (int i = 0; i < length; i++) {
            newArray[i] = array[(head + i) % array.length];
        }
        head = 0;
        tail = length;
        return newArray;
    }

    public Integer dequeue() {
        if (tail == head) {
            // empty
            return null;
        } else {
            int ret = array[head];
            array[head] = 0;
            head++;
            length--;
            return ret;
        }
    }


    public static void main(String[] args) {
        LoopQueue queue = new LoopQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
    }


}
