import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // check if the start and end cell is blocked
        if(grid[0][0] == 1 || grid[m - 1][n - 1] == 1){
            return -1;
        }

        // start BFS from the top-left corner
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        // start BFS from the top-left corner
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int pathLen = 1;

        // directions array for moving in 8 possible directions
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                // check if the first to reach the bottom-right, will be the shortest path
                if(x == m - 1 && y == n - 1){
                    return pathLen;
                }

                for(int j = 0; j < 8; j++){
                    int nextX = x + dirs[j][0];
                    int nextY = y + dirs[j][1];
                    // check bounds and if the cell is open and not visited
                    if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0 && !visited[nextX][nextY]){
                        q.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            // increase path length with each level of bfs
            pathLen++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{0,1}, {1,0}};
        int res = solution.shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }
}