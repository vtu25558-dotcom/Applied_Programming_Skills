import java.util.Stack;

class Ac {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean destroyed = false;
            
            // Only possible collision: stack top > 0 (right) and ast < 0 (left)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int top = stack.peek();
                
                if (top < -ast) {
                    // Top asteroid explodes
                    stack.pop();
                    continue; // Check next top for collision
                } else if (top == -ast) {
                    // Both explode
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // Current asteroid explodes
                    destroyed = true;
                    break;
                }
            }
            
            if (!destroyed) {
                stack.push(ast);
            }
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}