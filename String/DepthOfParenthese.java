Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

Example 1:
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation:
Digit 8 is inside of 3 nested parentheses in the string.

========================================================================================

public class DepthOfParenthese {

    public int maxDepth(String s) {

        int curDepth=0, maxDepth=0;

        for(char c : s.toCharArray()) {

            if(c == '(') {
                curDepth++;
                maxDepth = Math.max(maxDepth, curDepth);
            }
            else if(c == ')')
                curDepth--;
        }

        return maxDepth;
        
    }
    
}
