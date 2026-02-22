import java.util.Stack;

class Fpsds {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // Store indices
        
        for (int i = 0; i < n; i++) {
            // Apply discount to previous items that are >= current price
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }
        
        // Items with no discount remain unchanged
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices[idx];
        }
        
        return answer;
    }
}