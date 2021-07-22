import java.util.ArrayDeque;
import java.util.Deque;

public class Connect {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        System.out.println(connect(root));
    }

    /**
     * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
     */
    public static Node connect(Node root) {
        Deque<Node> bfsQueue = new ArrayDeque<>();
        Deque<Node> sameLevelStack = new ArrayDeque<>();
        if (root == null) return null;
        bfsQueue.push(root);
        sameLevelStack.push(root);
        while (!bfsQueue.isEmpty()) {
            Node nextNode = sameLevelStack.pop();
            while (!sameLevelStack.isEmpty()) {
                Node temp = sameLevelStack.pop();
                temp.next = nextNode;
                nextNode = temp;
            }
            Deque<Node> tempBfsQueue = new ArrayDeque<>();
            while (!bfsQueue.isEmpty()) tempBfsQueue.push(bfsQueue.pollFirst());
            while (!tempBfsQueue.isEmpty()) {
                Node p = tempBfsQueue.pollFirst();
                if (p.left != null) {
                    bfsQueue.push(p.left);
                    sameLevelStack.push(p.left);
                }
                if (p.right != null) {
                    bfsQueue.push(p.right);
                    sameLevelStack.push(p.right);
                }
            }
        }
        return root;
    }
}

// Definition for a Node.
class Node {
    int val;
    Node left;
    Node right;
    Node next;
    Node random;

    public Node() {
    }

    public Node(int _val) {
        this.val = _val;
    }

    public Node(int _val, Node next, Node random) {
        this.val = _val;
        this.next = null;
        this.random = null;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
