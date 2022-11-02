package gucheng;

public class ib {

    public  int solution(int A[])
    {
        int sign = 1 ;

        for(int index = 0 ; index < A.length ; index++)
        {
            if(A[index] == 0)
            {
                sign = 0;
                break;
            }
            else if (A[index] < 0)
            {
                sign = sign * -1;
            }

        }

        return sign ;
    }
}
