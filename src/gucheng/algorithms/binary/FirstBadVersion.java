package gucheng.algorithms.binary;

//https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion {

    boolean isBadVersion(int version){

        return version >= 5;

    }
    public int firstBadVersion(int n) {

        return findFirstBadVersion( 1 , n);


    }

    public int findFirstBadVersion(int begin , int end){

        while(begin < end){

            int middle = begin + ( end - begin)/2;
            if(!isBadVersion((middle))){
                begin = middle +1 ;
            }
            else{
                end = middle ;
            }
        }

        return begin ;
    }

    public static void main(String args[]){
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(10));


    }
}
