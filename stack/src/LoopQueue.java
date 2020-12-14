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

    public void add(int data) {
        if ((tail + 1) % array.length == head) {
            // 扩容
            int[] newArray = new int[array.length << 1];
            if (tail > head) {
                for (int i = head, j = 0; i < tail; i++, j++) {
                    newArray[j] = array[i];
                }
                head = 0;
                tail = length;
            } else {
                int j = 0;
                for (int i = head; i < array.length; i++, j++) {
                    newArray[j] = array[i];
                }
                for (int index = 0; index < tail; index++, j++) {
                    newArray[j] = array[index];
                }
                head = 0;
                tail = length;
            }
            array = newArray;
        }

        array[tail] = data;
        tail = (tail + 1) % array.length;
        length++;
    }

    public Integer remove() {
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
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.remove();
        queue.remove();
        queue.add(5);
        queue.add(6);
        queue.add(7);
    }


}
