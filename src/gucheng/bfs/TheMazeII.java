package gucheng.bfs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/the-maze-ii/
public class TheMazeII {

    int[][] directions  = new int[][]{{0 , 1} , {1 , 0} , {0 , -1} , {-1  , 0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        int[][] shortestDistance = new int[maze.length][maze[0].length];

        for(int rowIndex = 0 ; rowIndex < maze.length ; rowIndex++){
            for(int colIndex = 0 ; colIndex < maze[0].length ; colIndex++){
                shortestDistance[rowIndex][colIndex] = Integer.MAX_VALUE ;
            }
        }

        shortestDistance[start[0]][start[1]] = 0 ;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int size = queue.size() ;
            for(int index = 0  ; index < size ; index++){

                int[]  currentPos = queue.poll();

                for(int dir = 0 ; dir < directions.length ; dir++){
                    int x = currentPos[0];
                    int y = currentPos[1];
                    int steps = 0 ;
                    int xOffset = directions[dir][0];
                    int yOffset = directions[dir][1];
                    while( x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] ==0){
                        x += xOffset ;
                        y += yOffset ;
                        steps ++;
                    }

                    steps -- ;
                    x -= xOffset ;
                    y -= yOffset ;

                    if(shortestDistance[currentPos[0]][currentPos[1]] + steps < shortestDistance[x][y]){
                        shortestDistance[x][y] = shortestDistance[currentPos[0]][currentPos[1]] + steps;
                        queue.offer(new int[] { x , y});
                    }
                }

            }
        }

        return shortestDistance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 :shortestDistance[destination[0]][destination[1]];
    }

    public static void main(String args[]){
        int[][] maze = new int[][] {
                {0 , 0 , 1 , 0 , 0},
                {0 , 0 ,0 , 0 , 0 },
                {0 , 0 , 0 , 1 , 0},
                {1 , 1 , 0 , 1 , 1} ,
                {0 , 0 , 0 , 0 , 0}

        };

        TheMazeII theMaze = new TheMazeII();
        System.out.println(
                theMaze.shortestDistance(maze , new int[]{0 , 4} , new int[]{4 , 4})
        );


    }

}
