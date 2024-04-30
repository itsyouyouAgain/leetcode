class Solution {
    public double myPow(double x, int n) {
        // base case
        if(n == 0) return 1;

        // edge case: n is the smallest value for an int, which can not be negated directly because it would overflow
        if(n == Integer.MIN_VALUE){
            // compute (1/x)^(n+1) and divide by x one more time
            return myPow(1 / x, -(n + 1)) / x;
        }

        // if the exponent is negative, compute the positive exponent of the reciprocal of the base
        if(n < 0){
            return myPow(1 / x, -n);
        }

        // if the exponent is odd, reduce the problem by multiplying the base with the result of the function where the exponent is decresed by 1 (thus make it even)
        if(n % 2 == 1){
            return (x * myPow(x, n - 1));
        }else{
            // if the exponent is even, since (x^a)^2 = x^(2*a) to reduce the problem size
            double sub = myPow(x, n / 2);
            return (sub * sub);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double x = 2.00000;
        int n = 10;
        double res = solution.myPow(x, n);
        System.out.println(res);
    }
}

// Time Complecoty: O(logn)
// Space Complecoty: O(logn)