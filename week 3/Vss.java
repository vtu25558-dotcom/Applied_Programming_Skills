import java.util.Stack;

class Vss {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // Pointer for popped array

        for (int val : pushed) {
            stack.push(val); // push onto stack

            // Pop from stack if top matches the next popped element
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // If stack is empty, all pops matched correctly
        return stack.isEmpty();
    }
}