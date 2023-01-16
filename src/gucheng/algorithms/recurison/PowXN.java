package gucheng.algorithms.recurison;

// https://leetcode.com/problems/powx-n/
public class PowXN {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1.0 ;
        }

        if(n == 1) {
            return x ;
        }
        if(n == -1){
            return 1/x ;
        }

        if(n % 2 == 1){
            double sqrt= myPow(x , n/2);
            return sqrt * sqrt * x;
        }

        if(n%2 == -1){
            double sqrt= myPow(x , n/2);
            return sqrt * sqrt / x;

        }

        double sqrt = myPow(x , n/2);
        return sqrt * sqrt ;

    }
}
