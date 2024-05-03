import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        // create a hashmap to map roman numerals to integers
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for(int i = 0; i < s.length(); i++){
            // check if the current roman numerals is smaller than next one
            if(i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                // if yes, subtract its value from the result
                res -= map.get(s.charAt(i));
            }else{
                // if no, add its value to result
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        Solution solution = new Solution();
        int res = solution.romanToInt(s);
        System.out.println(res);
    }
}