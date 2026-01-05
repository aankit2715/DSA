
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.


===================================================================================


class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> mp = new HashMap<>();
        int right=0, left=0, res=0;

        while(right < s.length()) {

            char c = s.charAt(right);

            if(mp.containsKey(c)) 
                left = Math.max(left, mp.get(c)+1);
            
            mp.put(c, right);

            res = Math.max(res, right-left+1);
            right++;
        }

        return res;
    }
}