import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        // initialize the priority queue to store points with custom comparetor that compares the distance values stored in the second element of the array
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            return a[1] - b[1];
        });

        for(int i = 0; i < points.length; i++){
            int[] arr = new int[2];
            int x = points[i][0];
            int y = points[i][1];
            arr[0] = i;
            arr[1] = (int)Math.pow(x, 2) + (int)Math.pow(y, 2);
            pq.offer(arr);
        }

        // extract the k closest points based on the stored distance
        for(int i = 0; i < k; i++){
            int[] temp = pq.poll();
            res[i] = points[temp[0]];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        int[][] res = solution.kClosest(points, k);
        for(int[] point : res){
            System.out.println("[" + point[0] + "," + point[1] + "]");
        }
    }
}
