import java.util.Stack;

class MyQueue {
    private Stack<Integer> input;  // Stack for push operations
    private Stack<Integer> output; // Stack for pop/peek operations

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    // Push element x to the back of queue
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from the front of the queue and returns it
    public int pop() {
        moveInputToOutputIfNeeded();
        return output.pop();
    }

    // Returns the element at the front of the queue
    public int peek() {
        moveInputToOutputIfNeeded();
        return output.peek();
    }

    // Returns true if the queue is empty
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    // Helper: move elements from input stack to output stack if output is empty
    private void moveInputToOutputIfNeeded() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}