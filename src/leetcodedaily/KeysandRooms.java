package leetcodedaily;

import java.util.*;

// https://leetcode.com/problems/keys-and-rooms/
public class KeysandRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        // topology sort?


        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer>  keys = new LinkedList<>();
        keys.addAll(rooms.get(0));

        while(!keys.isEmpty()){

            Integer nextRoom = keys.poll();
            if(visited.add(nextRoom)){
                for(int key : rooms.get(nextRoom)){
                    keys.offer(key);
                }
            }
        }

        return visited.size() == rooms.size() ;
    }

    public static void main(String[] args){
        KeysandRooms keysandRooms = new KeysandRooms();

        List<List<Integer>> rooms = List.of( List.of(1) , List.of(2) , List.of(3) , Collections.EMPTY_LIST);
        System.out.println(keysandRooms.canVisitAllRooms(rooms));

        rooms = List.of(List.of(1 , 3) , List.of(3 ,0 , 1) , List.of(2) , List.of(0));
        System.out.println(keysandRooms.canVisitAllRooms(rooms));
    }
}
