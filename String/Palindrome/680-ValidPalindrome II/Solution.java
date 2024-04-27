class Solution {
    // main method to determine if the string can be palindrome after removing at most one character
    public boolean validPalindrome(String s) {
        // use two pointers to iterate through the string from both ends
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                // check if the substring can be palindrome after removing the right-side chacracter or left-side character
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    // helper method to check if the substring defined by start index i and end index j is palindrome
    private boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String input = "abda";
        boolean output = solution.validPalindrome(input);
        System.out.println("Input: s = \"" + input + "\"");
        System.out.println("Output: " + output);

    }
}

// Time Complecity: O(n)
// Space Complcity: O(1)