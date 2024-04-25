import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String expression1 = "3+2*2";

        System.out.println(expression1 + " = " + solution.calculate(expression1)); // Output should be 7

    }

    public int calculate(String s) {
        // initialize stack to keep track of numbers which may be the result of operations
        Stack<Integer> st = new Stack<>();
        // the sign of current number
        char sign = '+';
        int num = 0;
        int n = s.length();

        // iterate over each character in the string
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            // if the character is digit, form the number
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }

            // If the character is not a digit and is not a space, or it's the last char
            // do operations base on previous sign
            if(!Character.isDigit(c) && c != ' ' || i == n - 1){
                switch(sign){
                    // if the sign is '+', push the number
                    case '+':
                        st.push(num);
                        break;
                    // if the sign is '-', push the negative of the number
                    case '-':
                        st.push(-num);
                        break;
                    // if the sign is '*', multiply the top element of the stack with cur num
                    case '*':
                        st.push(st.pop() * num);
                        break;
                    // if the sign is '/', divide the top element of the stack by cur num
                    case '/':
                        st.push(st.pop() / num);
                }
                // update the sign to the cur character and reset num to 0
                sign = c;
                num = 0;
            }
        }

        // Sum up all the values in the stack to get the result
        int res = 0;
        while(!st.isEmpty()){
            res += st.pop();
        }
        return res;
    }
}