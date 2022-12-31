package gucheng.algorithms.prefixsum;

// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
public class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;

        int[] left = new int[cardPoints.length+1];
        int[] right = new int[cardPoints.length+1];

        for(int index = 1 ; index < left.length ; index++){

            left[index] = left[index-1] + cardPoints[index-1] ;
            right[right.length-1 - index] = right[right.length - index] + cardPoints[cardPoints.length-index];
        }
        for(int index = 0 ; index <= k ; index++){
            int rightIndex =  right.length-1 - (k - index );
            int points = left[index] + right[rightIndex];
            ans = Math.max(ans , points);
        }
        return ans ;
    }

    public static void main(String args[]){
        MaximumPointsYouCanObtainfromCards maximumPointsYouCanObtainfromCards = new MaximumPointsYouCanObtainfromCards();
        int[] cardPoints ;

        cardPoints = new int[] {1,2,3,4,5,6,1};
        System.out.println(maximumPointsYouCanObtainfromCards.maxScore(cardPoints , 3));

        cardPoints = new int[] {2,2,2};
        System.out.println(maximumPointsYouCanObtainfromCards.maxScore(cardPoints , 2));
        cardPoints = new int[] {9,7,7,9,7,7,9};
        System.out.println(maximumPointsYouCanObtainfromCards.maxScore(cardPoints , 7));
    }
}
