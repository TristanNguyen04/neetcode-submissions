class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char letter : s.toCharArray()){
            if(!stack.isEmpty()){
                if(stack.peek() == '(' && letter == ')'){
                    stack.pop();
                } else if(stack.peek() == '[' && letter == ']'){
                    stack.pop();
                } else if(stack.peek() == '{' && letter == '}'){
                    stack.pop();
                } else {
                    stack.push(letter);
                }
            } else {
                stack.push(letter);
            }
        }

        return stack.isEmpty();
    }
}
