import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        boolean[] invalid = new boolean[s.length()];
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
                invalid[i] = true;
            }
            if(s.charAt(i) == ')'){
                if(st.empty()){
                    invalid[i] = true;
                }else{
                    invalid[st.pop()] = false;
                }
            }
        }

        for(int i = 0; i < s.length(); i++){
            if(!invalid[i]){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "lee(t(c)o)de)";
        String res = solution.minRemoveToMakeValid(s);
        System.out.println(res);
    }
}