import java.util.Stack;

class Mrmvp {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>(); // store indices of '('

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // match with previous '('
                } else {
                    sb.setCharAt(i, '*'); // mark unmatched ')'
                }
            }
        }

        // Mark any unmatched '(' remaining in stack
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }

        // Build the final string excluding all marked characters
        return sb.toString().replaceAll("\\*", "");
    }
}