class Solution {
    /*
        "["



    
    */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char bracket : s.toCharArray()){
            if(!stack.isEmpty()){
                if(bracket == ')' && stack.peek() == '('){
                    stack.pop();
                } else if(bracket == ']' && stack.peek() == '['){
                    stack.pop();
                } else if(bracket == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(bracket);
                }
            } else {
                stack.push(bracket);
            }
        }

        return stack.isEmpty();
    }
}
