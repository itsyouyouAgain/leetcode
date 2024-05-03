class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        int i = 0;
        while(num > 0){
            if(num >= values[i]){
                num -= values[i];
                res.append(romanNumerals[i]);
            }else{
                i++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 1994;
        String res = solution.intToRoman(num);
        System.out.println(res);
    }
}