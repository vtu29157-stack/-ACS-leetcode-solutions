class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.data = new int[k];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % capacity;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % capacity;
        count--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(tail - 1 + capacity) % capacity];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
}
