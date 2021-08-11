import java.util.*;
public class solution{

    public String minWindow(String s, String t) {
        if(s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int i = 0, j = 0, left = 0, right = 0;
        int count = map.size(), min = s.length();
        boolean found = false;
        
        while(j < s.length()){
            char endChar = s.charAt(j++);
            if(map.containsKey(endChar)){
                map.put(endChar, map.get(endChar)-1);
                if(map.get(endChar) == 0) count -= 1;
            }
            
            if(count > 0) continue;
            
            while(count == 0){
                char startChar = s.charAt(i++);
                // Move the i index
                if(map.containsKey(startChar)){
                    map.put(startChar, map.get(startChar)+1);
                    if(map.get(startChar) > 0)count += 1;
                }
            }
            
            
            if((j-1) < min){
                left = i;
                right = j;
                min = (j - 1);
                found = true;
            }
        }
        
        return found ? s.substring(left-1, right) : "";
        
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println("Final: " + minWindow(s, t));
    }
}

