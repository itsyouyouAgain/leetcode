import java.util.LinkedList;
import java.util.List;

class Solution {
    // track which courses has been visited
    boolean[] visited;
    // track the current path in DFS to detect cycles
    boolean[] onPath;
    // Flag set to true if it is a cycle
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            traverse(graph, i);
        }

        return !hasCycle;
    }

    // build gragh which represent as an adjecency list
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; i++){
            // create directed edge
            graph[i] = new LinkedList<>();
        }

        for(int[] edge : prerequisites){
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    private void traverse(List<Integer>[] graph, int s){
        // base case
        // check if s has already on the path which means there is a cycle
        if(onPath[s]){
            hasCycle = true;
            return;
        }

        // if s has been visited or a cycle is found, stop traversal
        if(visited[s] || hasCycle){
            return;
        }

        // mark current node as visited
        visited[s] = true;
        // mark current node on the dfs path
        onPath[s] = true;
        // traverse all adjacent nodes
        for(int i : graph[s]){
            traverse(graph, i);
        }
        // unmark the node from dfs track after recursion
        onPath[s] = false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        boolean res = solution.canFinish(numCourses, prerequisites);
        System.out.println(res);
    }
}