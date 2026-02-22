class MyCircularQueue {
    private int[] data;
    private int head;  // points to the front element
    private int tail;  // points to the next position to insert
    private int size;
    private int capacity;

    /** Initialize the queue with size k */
    public MyCircularQueue(int k) {
        data = new int[k];
        head = 0;
        tail = 0;
        size = 0;
        capacity = k;
    }

    /** Insert an element into the circular queue. Return true if successful */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        data[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if successful */
    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    /** Get the front item from the queue. Return -1 if empty */
    public int Front() {
        if (isEmpty()) return -1;
        return data[head];
    }

    /** Get the last item from the queue. Return -1 if empty */
    public int Rear() {
        if (isEmpty()) return -1;
        // tail points to the next insertion position, so last element is at (tail-1+capacity)%capacity
        return data[(tail - 1 + capacity) % capacity];
    }

    /** Checks whether the queue is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the queue is full */
    public boolean isFull() {
        return size == capacity;
    }
}