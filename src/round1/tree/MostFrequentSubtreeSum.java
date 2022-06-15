package round1.tree;

import com.sun.jdi.Value;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 *
 * 508
 */
public class MostFrequentSubtreeSum {

    class ValueCount {
        int value ;
        int count ;


    }
    public int[] findFrequentTreeSum(TreeNode root) {

        if(root == null)
        {
            return new int[0];
        }

        List<Integer> sums = new ArrayList<>();

        getSubTreeSum(root , sums);

        Map<Integer , ValueCount> valueCountMap = new HashMap<>();
        for(Integer sum : sums)
        {
            ValueCount valueCount ;
            if(valueCountMap.containsKey(sum))
            {
                 valueCount = valueCountMap.get(sum);
            }
            else {
                valueCount = new ValueCount();
                valueCountMap.put(sum , valueCount);
                valueCount.value = sum ;
            }
            valueCount.count++;
        }

        List<ValueCount> sorted = valueCountMap.values().stream().sorted(( v1 ,  v2) -> v2.count - v1.count ).collect(Collectors.toList());

        List<Integer>  result = new ArrayList<>();

        ValueCount first = sorted.get(0);
        result.add(first.value);
        for(int index = 1 ; index < sorted.size() ; index++)
        {
            if(sorted.get(index).count == first.count)
            {
                result.add(sorted.get(index).value);
            }
        }

        int[] resultArray = new int[result.size()];
        for(int index = 0 ; index < resultArray.length ; index++)
        {
            resultArray[index] = result.get(index).intValue();
        }





        return resultArray ;
    }

    protected int getSubTreeSum(TreeNode root  , List<Integer> sums)
    {
        if(root == null)
        {
            return 0 ;
        }

        int left = getSubTreeSum(root.left  , sums);
        int right = getSubTreeSum(root.right , sums);

        int sum = left + right + root.val ;

        sums.add(sum);

        return sum ;
    }

    public static void main(String args[])
    {
        MostFrequentSubtreeSum helper = new MostFrequentSubtreeSum();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        helper.findFrequentTreeSum(root);
    }
}
