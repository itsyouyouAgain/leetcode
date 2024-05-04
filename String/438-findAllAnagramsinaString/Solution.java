import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> win = new HashMap<>();

        for(char c : p.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0, valid = 0;
        List<Integer> res = new LinkedList<>();
        while(r < s.length()){
            char c = s.charAt(r);
            r++;
            if(need.containsKey(c)){
                win.put(c, win.getOrDefault(c, 0) + 1);
                if(win.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while(r - l >= p.length()){
                if(valid == need.size()){
                    res.add(l);
                }
                char d = s.charAt(l);
                if(need.containsKey(d)){
                    if(win.get(d).equals(need.get(d))){
                        valid--;
                    }
                    win.put(d, win.get(d)-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = solution.findAnagrams(s, p);
        System.out.println(res);
    }
}