package gucheng.binarysearch;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class Pow {


    public static void main(String args[]) {

        double pown_x;

        pown_x = myPow(2.0, 10);

        assertEquals(pown_x, 1024.00);

        pown_x = myPow(2.1, 3);
        assertEquals(pown_x, 9.26100, 0.000000001);

        pown_x = myPow(2.0, -2);
        assertEquals(pown_x, 0.25, 0.000000001);

    }

    public static double myPow(double x, int n) {

        double result = 1.0;

        double supplemental = 1.0;

        if (x == 0.0) {
            return x;
        }

        double pown = 1.0;
        if (n > 0) {
            pown = pown * x;
        } else {

            pown = pown / x;
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                supplemental = pown;

            } else {
                n = -n;
            }

        }


        while (n > 0) {
            int lastBit = n & 1;
            if (lastBit > 0) {
                result = result * pown;
            }

            n = n >> 1;
            pown = pown * pown;
        }

        return result * supplemental;
    }


    public static double myPowBinarySearch(double x, int n) {
        // how to do it?
        return x;
    }
}