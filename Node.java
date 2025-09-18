
package node;
import java.util.*;
import java.util.List;

    public class Node {

        int data;
        Node left;
        Node right;

    public Node(int data){
        this.data = data;
}    
    }class BinaryTree{
        Node root;
        
    public void inorder(Node n, List<Integer> out) {
        if (n == null) return;
        inorder(n.left, out);
        out.add(n.data);
        inorder(n.right, out);
    }
    public void preorder(Node n, List<Integer> out) {
        if (n == null) return;
        out.add(n.data);
        preorder(n.left, out);
        preorder(n.right, out);
    }
    public void postorder(Node n, List<Integer> out) {
        if (n == null) return;
        postorder(n.left, out);
        postorder(n.right, out);
        out.add(n.data);
    }
    public List<Integer> levelOrder(Node n) {
        List<Integer> out = new ArrayList<>();
        if (n == null) return out;

        Queue<Node> q = new ArrayDeque<>();
        q.add(n);

        while (!q.isEmpty()) {
            Node cur = q.remove();
            out.add(cur.data);
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }

        return out;
    
}  
    
    }
class Main{
        
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Build the tree
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(7);
        tree.root.right.left = new Node(12);

        // Create traversal lists
        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        // Perform traversals
        tree.inorder(tree.root, in);
        tree.preorder(tree.root, pre);
        tree.postorder(tree.root, post);
        List<Integer> level = tree.levelOrder(tree.root);

        // Print results
        System.out.println("Inorder: " + in);
        System.out.println("Preorder: " + pre);
        System.out.println("Postorder: " + post);
        System.out.println("Level Order: " + level);
    }

    }
    