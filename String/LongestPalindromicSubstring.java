Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

========================================================================================

public class LongestPalindromicSubstring {

    public int expandFromCenter(String s, int left, int right) {

        while(left>=0 && right<s.length() && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }

        return right-left-1;  // Because when the while loop breaks, left and right are one step further.
    }

    public String longestPalindrome(String s) {

        if(s == null || s.length()<1) return "";

        int start=0, end=0;  
        for(int i=0; i<s.length(); i++) {
            int len1 = expandFromCenter(s, i, i); // Odd Length Palindrom
            int len2 = expandFromCenter(s, i, i+1); // Even Length Palindrom

            int len = Math.max(len1, len2);

            if(len > end-start) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end+1);
        
    }
    
}
