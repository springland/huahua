package round1.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/time-based-key-value-store/submissions/
 */
public class TimeBasedKeyValueStore {

    public static void main(String args[])
    {
        TimeMap map = new TimeMap();

        map.set("love" , "high" , 10);
        map.set("love" , "low" , 20);
        System.out.println(map.get("love" , 5));
        System.out.println(map.get("love" , 10));
        System.out.println(map.get("love" , 15));
        System.out.println(map.get("love" , 20));
        System.out.println(map.get("love" , 25));


    }
}

class TimeMap {

    class ValueEntry {

        public ValueEntry(String value , int timeStamp)
        {
            this.value = value ;
            this.timeStamp = timeStamp ;
        }
        String value ;
        int timeStamp ;


    }
    protected Map<String , ArrayList<ValueEntry>>  timeMap ;
    public TimeMap() {
        timeMap = new HashMap<>();

    }

    public void set(String key, String value, int timestamp) {

        ArrayList<ValueEntry> values = new ArrayList<>();
        if (timeMap.containsKey(key))
        {
            values = timeMap.get(key);
        }
        else {
            values = new ArrayList<>();
            timeMap.put(key , values);

        }

        int beginIndex =  0 ;
        int endIndex = values.size()-1;
        ValueEntry entry = new ValueEntry(value , timestamp);
        if( values.isEmpty())
        {
            values.add(entry);
            return ;
        }

        while(beginIndex <= endIndex) {
            int middleIndex = beginIndex + (endIndex - beginIndex) / 2;
            if (values.get(middleIndex).timeStamp == timestamp) {
                values.add(middleIndex, entry);
                return;
            }

            if (values.get(middleIndex).timeStamp < timestamp)
            {
                beginIndex = middleIndex+1;
            }
            else{
                endIndex = middleIndex-1;
            }
        }
        values.add(endIndex+1 , entry);
    }


    public String get(String key, int timestamp) {

        ArrayList<ValueEntry> values = this.timeMap.get(key);
        if(values == null || values.isEmpty())
        {
            return "";
        }

        int beginIndex = 0 ;
        int endIndex = values.size()-1;
        while(beginIndex <= endIndex)
        {
            int middleIndex = beginIndex + (endIndex - beginIndex)/2 ;

            ValueEntry entry = values.get(middleIndex);
            if(entry.timeStamp == timestamp)
            {
                return entry.value;
            }
            if(entry.timeStamp > timestamp)
            {
                endIndex = middleIndex-1;
            }
            else {
                beginIndex = middleIndex+1;
            }
        }


        if(endIndex +1 == 0)
        {
            return "";
        }

        return values.get(endIndex).value;
    }

}
