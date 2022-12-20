package leetcodedaily;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/find-if-path-exists-in-graph/
public class FindifPathExistsinGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        Set<Integer> visisted = new HashSet<>();

        int[][] directionalEdges = new int[edges.length*2][2];
        for(int index = 0 ; index < edges.length ; index++){
            directionalEdges[index] = edges[index];
            directionalEdges[index+ edges.length][0] =edges[index][1];
            directionalEdges[index+ edges.length][1] =edges[index][0];
        }
        Map<Integer , List<int[]>> edgesMap = Stream.of(directionalEdges).collect(Collectors.groupingBy(t -> t[0]));


        if(source == destination) return true ;

        Deque<int []> queue = new LinkedList<>();
        queue.addAll(edgesMap.getOrDefault(source , Collections.emptyList()));

        while(!queue.isEmpty()){
            int[] edge = queue.poll();

            int cur = edge[1];
            if(cur == destination){
                return true ;
            }

            if(!visisted.contains( cur)){
                List<int[]>  curEdges = edgesMap.getOrDefault(cur , Collections.emptyList());
                for(int[] curEdge : curEdges){
                    queue.offer(curEdge);
                }
                visisted.add(cur);
            }
        }

        return false ;
    }

    public static void main(String args[]){
        FindifPathExistsinGraph findifPathExistsinGraph = new FindifPathExistsinGraph();
        int[][] edges ;

        edges = new int[][] {{0,1},{1,2},{2,0}} ;
    //    System.out.println(findifPathExistsinGraph.validPath(3 , edges , 0 , 2));

        edges = new int[][] {{0,1},{0,2},{3,5},{5,4},{4,3}} ;
    //    System.out.println(findifPathExistsinGraph.validPath(6 , edges , 0 , 5));

        edges = new int[][] {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        System.out.println(findifPathExistsinGraph.validPath(10 , edges , 7 , 5));
    }
}
