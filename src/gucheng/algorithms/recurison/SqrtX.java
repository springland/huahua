package gucheng.algorithms.recurison;

// https://leetcode.com/problems/sqrtx/
public class SqrtX {

    public int mySqrt(int x) {

        if (x == 0 || x == 1)  return x ;

        long left = 2 ;
        long right = x/2 ;

        while(left <= right ){
            long middle = left + ( right - left)/2;
            if(middle * middle == x) return (int)middle ;
            if(middle * middle < x){
                left = middle+1 ;
            }else{
                right = middle-1 ;
            }
        }

        return (int)( right*right > x ? right -1 : right);
    }

    public static void main(String args[]){
        SqrtX  sqrt = new SqrtX();
        System.out.println(sqrt.mySqrt(2147395599));
        System.out.println(sqrt.mySqrt(10));
        System.out.println(sqrt.mySqrt(8));
    }
}
