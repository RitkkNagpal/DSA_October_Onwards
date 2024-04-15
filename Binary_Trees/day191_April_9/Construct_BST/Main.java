import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public static Node construct(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + ((hi - lo) / 2);
        Node root = new Node(arr[mid], null, null);
        root.left = construct(arr, lo, mid - 1);
        root.right = construct(arr, mid + 1, hi);
        return root;
    }

    public static void levelOrderLineWise(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                // remove
                Node rem = queue.remove();
                // print
                System.out.print(rem.data + " ");
                // add children
                // left child
                if (rem.left != null) {
                    queue.add(rem.left);
                }
                // right
                if (rem.right != null) {
                    queue.add(rem.right);
                }
            }
            System.out.println();
        }
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            System.out.print("left: " + node.left.data + " ");
        }
        System.out.print("data: " + node.data + " ");
        if (node.right != null) {
            System.out.print("right: " + node.right.data + " ");
        }
        System.out.println();
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        // BST Can be constructed from a sorted Array
        int[] data = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87 };
        Node root = construct(data, 0, data.length - 1);
        display(root);
        levelOrderLineWise(root);
    }
}