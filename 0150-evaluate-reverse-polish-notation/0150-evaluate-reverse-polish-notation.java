class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int x;
        int a;
        int b;
        for(String s : tokens){
            if(!s.equals("*") && !s.equals("/") && !s.equals("+") && !s.equals("-")){
                x = Integer.parseInt(s);
                stack.push(x);
            } else{
                if(s.equals("*")){
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a*b);
                } else if(s.equals("/")){
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a/b);
                } else if(s.equals("+")){
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a+b);
                } else if(s.equals("-")){
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a-b);
                }
            }
            
        }
        return stack.peek();
    }
}
