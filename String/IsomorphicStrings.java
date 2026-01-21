import java.util.HashMap;
import java.util.Map;

Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true
Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.

================================================================================

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()) return false;

        Map<Character, Character> ST = new HashMap<>();
        Map<Character, Character> TS = new HashMap<>();

        for(int i=0; i<s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(ST.containsKey(c1)) {
                if(ST.get(c1) != c2) return false;
            }
            else
                ST.put(c1, c2);

            if(TS.containsKey(c2)) {
                if(TS.get(c2) != c1) return false;
            }
            else
                TS.put(c2, c1);
        }

        return true;
        
    }
    
}
