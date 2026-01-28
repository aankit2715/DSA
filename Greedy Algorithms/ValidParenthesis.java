Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
The following rules define a valid string:
Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

Example:
Input: s = "(*))"
Output: true

========================================================================================

Maintain two counters:
    - low = minimum possible number of open parentheses.
    - - high = maximum possible number of open parentheses

public class ValidParenthesis {

    public boolean checkValidString(String s) {

        int low=0, high=0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                low++;
                high++;
            }
            else if(c == ')') {
                if(low > 0) low--; // one '(' matched
                high--;
            }
            else {
                if(low > 0) low--; // treat '*' as ')'
                high++; // treat '*' as '('
            }

            if(high < 0) return false; // too many ')'
        }

        return low==0;
        
    }
    
}
