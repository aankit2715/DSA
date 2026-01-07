// Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
// Return the quotient after dividing dividend by divisor.

// Example:
// Input: dividend = 7, divisor = -3
// Output: -2
// Explanation: 7/-3 = -2.33333.. which is truncated to -2.

// ====================================================================================


public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int result=0;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        while(a >= b) {

            long temp=b, multiple=1;

            while( a >= (temp << 1)) {

                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            result += multiple;
        }
        
        return (dividend > 0) == (divisor > 0) ? result : -result;
    }
    
}
