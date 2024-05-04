import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        // initialize two map to track character needed and characters found in window
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();
        // count the frequency of characters in string t and store in the need map
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int l = 0, r = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while(r < s.length()){
            char c = s.charAt(r);
            r++;
            if(need.containsKey(c)){
                win.put(c, win.getOrDefault(c, 0) + 1);
                if(win.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            // shrink the window from the left until it is no longer valid
            while(valid == need.size()){
                if(r - l < len){
                    start = l;
                    len = r - l;
                }
                char d = s.charAt(l);
                l++;
                if(need.containsKey(d)){
                    if(win.get(d).equals(need.get(d))){
                        valid--;
                    }
                    win.put(d, win.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = solution.minWindow(s, t);
        System.out.println(res);
    }
}
