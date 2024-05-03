import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int fresh = 0, round = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty() && fresh > 0){
            round++;
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                int[] rotten = q.poll();
                int x = rotten[0];
                int y = rotten[1];

                if(x - 1 >= 0 && grid[x - 1][y] == 1){
                    q.offer(new int[]{x - 1, y});
                    grid[x - 1][y] = 2;
                    fresh--;
                }

                if(x + 1 < m && grid[x + 1][y] == 1){
                    q.offer(new int[]{x + 1, y});
                    grid[x + 1][y] = 2;
                    fresh--;
                }

                if(y - 1 >= 0 && grid[x][y - 1] == 1){
                    q.offer(new int[]{x, y - 1});
                    grid[x][y - 1] = 2;
                    fresh--;
                }

                if(y + 1 < n && grid[x][y + 1] == 1){
                    q.offer(new int[]{x, y + 1});
                    grid[x][y + 1] = 2;
                    fresh--;
                }
            }
        }

        if(fresh == 0){
            return round;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        int round = solution.orangesRotting(grid);
        System.out.println(round);
    }
}