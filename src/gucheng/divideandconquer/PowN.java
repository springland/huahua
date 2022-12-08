package gucheng.divideandconquer;

public class PowN {

    public double myPow(double x, int n) {


        double answer = 0.0 ;
        switch(n){
            case 0:
                answer = 1.0 ;
                break;
            case 1 :
                answer = x ;
                break;
            case -1 :
                answer = 1/x ;
                break;
            default :
                if (n %2 == 1 || n%2 == -1) {
                    answer = myPow(x, n / 2) * myPow(x, n - n / 2);
                }
                else{
                    answer = myPow(x, n / 2);
                    answer = answer * answer ;
                }
                break;
        }

        return answer ;

    }
}
