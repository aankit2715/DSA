// Given a string s consisting only of characters a, b and c.
// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

// Example:
// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).

// ===================================================================================

public class NumberofSubstringContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {

        int[] count = new int[3];
        int left=0, right=0, res=0, n=s.length();

        while(right < n) {

            count[s.charAt(right)-'a']++;

            while(count[0]>0 && count[1]>0 && count[2]>0) {

                res += n-right;
                count[s.charAt(left)-'a']--;
                left++;
            }

            right++;
        }

        return res;
        
    }
    
}
