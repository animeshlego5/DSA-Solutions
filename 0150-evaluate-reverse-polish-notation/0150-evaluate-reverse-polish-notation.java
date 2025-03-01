import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String s : tokens) {
            switch (s) {
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a / b);
                    break;
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    b = stack.pop(); a = stack.pop();
                    stack.push(a - b);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
