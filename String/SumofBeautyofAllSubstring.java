The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.

Example 1:
Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.

TC: O(N^2 * 26) => O(N^2)
========================================================================================

public class SumofBeautyofAllSubstring {

    public int beautySum(String s) {

        int n = s.length(), totalBeauty = 0;

        for(int i=0; i<n; i++) {

            int[] freq = new int[26];
            for(int j=i; j<n; j++) {

                freq[s.charAt(j)-'a']++;
                int maxFreq = 0, minFreq = Integer.MAX_VALUE;

                for(int f : freq) {

                    if(f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    } 
                }

                totalBeauty += maxFreq - minFreq;
            }
        }
        
        return totalBeauty;

    }
    
}
