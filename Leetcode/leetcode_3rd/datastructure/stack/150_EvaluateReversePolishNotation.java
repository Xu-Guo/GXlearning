public class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++){
            if (!set.contains(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int second = stack.pop();
                int first = stack.pop();
                int temp = 0;
                if (tokens[i].equals("+")){
                    temp = first + second;
                } else if (tokens[i].equals("-")){
                    temp = first - second;
                } else if (tokens[i].equals("*")){
                    temp = first * second;
                } else if (tokens[i].equals("/")){
                    temp = first / second;
                }
                stack.push(temp);
            }
        }
        return stack.pop();
    }
}