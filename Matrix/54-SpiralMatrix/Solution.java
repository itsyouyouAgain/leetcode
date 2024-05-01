import java.util.List;
import java.util.LinkedList;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new LinkedList<>();
        int upper = 0, lower = m - 1, left = 0, right = n - 1;

        // Traverse the two-dimensional array in right-bottom-left-top order while shrinking the bounds
        // continue until all elements are added to the res list
        while(res.size() < m * n){
            // upper : left -> right
            if(upper <= lower){
                for(int j = left; j <= right; j++){
                    res.add(matrix[upper][j]);
                }
                // move the upper boundary down
                upper++;
            }

            // right : upper -> lower
            if(right >= left){
                for(int i = upper; i <= lower; i++){
                    res.add(matrix[i][right]);
                }
                // move the right boundary left
                right--;
            }

            // lower : right -> left
            if(lower >= upper){
                for(int j = right; j >= left; j--){
                    res.add(matrix[lower][j]);
                }
                // move the lower boundary up
                lower--;
            }

            // left : lower -> upper
            if(right >= left){
                for(int i = lower; i >= upper; i--){
                    res.add(matrix[i][left]);
                }
                // move the left boundary right
                left++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> res = solution.spiralOrder(matrix);
        System.out.println(res);
    }
}
