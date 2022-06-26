package round1.binarysearch;

public class Sqrt {

    public int mySqrt(int x) {

        if(x == 0 || x == 1) return x ;

        int beginValue = 2;
        int endValue = 46340 ;
        while(beginValue <= endValue)
        {
            int middleValue = beginValue + ( endValue - beginValue)/2 ;

            int square = middleValue * middleValue ;
            if(square == x)
            {
                return middleValue;
            }

            if(square > x)
            {
                endValue = middleValue-1 ;
            }
            else {
                beginValue = middleValue +1 ;
            }
        }
        return endValue ;
    }

    public static void main(String args[])
    {
        Sqrt sqrt = new Sqrt();

        System.out.println(Integer.MAX_VALUE);
        System.out.println(sqrt.mySqrt(
                2147395599));

    }

}
