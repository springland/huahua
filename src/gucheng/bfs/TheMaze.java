package gucheng.bfs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/the-maze/
public class TheMaze {

    private int[][] directions = new int[][] {{0 , 1} , {0 , -1} , { 1 , 0} , {-1 , 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return bfs(maze , start , destination  ) ;

    }

    public boolean bfs(int[][] maze, int[] start, int[] destination){
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true ;
        if(start[0] == destination[0] && start[1]== destination[1]){
            return true ;
        }
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        while(!queue.isEmpty()){

            int size = queue.size() ;
            for(int index = 0 ; index < size ; index++) {
                int[] cur = queue.poll();
                for (int dir = 0; dir < directions.length; dir++) {

                    int x = cur[0];
                    int y = cur[1];

                    int xOffset = directions[dir][0];
                    int yOffset = directions[dir][1];
                    while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                        x += xOffset;
                        y += yOffset;
                    }
                    x -= xOffset;
                    y -= yOffset;

                    if (x == destination[0] && y == destination[1]) {
                        return true;
                    }

                    if (!visited[x][y]) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return false ;

    }
    public boolean dfs(int[][] maze , int[] start , int[] destination , boolean[][] visited)
    {
        if(visited[start[0]][start[1]]){
            return false ;
        }
        visited[start[0]][start[1]] = true ;

        for(int direction = 0 ; direction < directions.length ; direction++) {
            int x = start[0] ;
            int y = start[1] ;

            int xOffset = directions[direction][0];
            int yOffset = directions[direction][1];

            while( true){

                if( x+xOffset < 0 || x+xOffset  == maze.length  || y + yOffset < 0 || y + yOffset == maze[0].length){
                    break;
                }
                if(maze[x+xOffset][ y + yOffset] == 1 ){
                    break;
                }
                x += xOffset ;
                y += yOffset ;
            }

            if(x == destination[0] && y == destination[1]){
                return true ;
            }
            if(dfs(maze , new int[] { x , y} , destination , visited)) {
                return true ;
            }

        }

        return false ;
    }

    public static void main(String args[]){
        int[][] maze = new int[][] {
                {0 , 0 , 1 , 0 , 0},
                {0 , 0 ,0 , 0 , 0 },
                {0 , 0 , 0 , 1 , 0},
                {1 , 1 , 0 , 1 , 1} ,
                {0 , 0 , 0 , 0 , 0}

        };

        TheMaze theMaze = new TheMaze();
        System.out.println(
                theMaze.hasPath(maze , new int[]{0 , 4} , new int[]{1 , 2})
        );


    }
}
