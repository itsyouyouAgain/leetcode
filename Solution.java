import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution {
    private HashMap<Node, Node> originToClone = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (originToClone.containsKey(node)) {
            return originToClone.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());
        originToClone.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    public static void main(String[] args) {
        // 示例图的构建
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Solution solution = new Solution();
        Node clonedGraph = solution.cloneGraph(node1);

        // 打印克隆图的结果来验证
        System.out.println("Cloned Node 1's neighbors: ");
        for (Node neighbor : clonedGraph.neighbors) {
            System.out.println(neighbor.val);
        }
    }
}
