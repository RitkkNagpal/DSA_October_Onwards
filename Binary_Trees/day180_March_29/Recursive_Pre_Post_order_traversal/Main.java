
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Main
 */
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

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }

        Pair() {

        }
    }

    public static Node construct(Integer[] arr) {
        Stack<Pair> st = new Stack<>();
        Node root = new Node(arr[0], null, null);
        st.push(new Pair(root, 1));
        int idx = 1;
        while (!st.isEmpty()) {
            Pair top = st.peek();
            if (top.state == 1) {
                // left child push
                if (arr[idx] != null) {
                    Node nn = new Node(arr[idx], null, null);
                    top.node.left = nn;
                    st.push(new Pair(nn, 1));
                }
                idx++;
                top.state++;
            } else if (top.state == 2) {
                // right child push
                if (arr[idx] != null) {
                    Node nn = new Node(arr[idx], null, null);
                    top.node.right = nn;
                    st.push(new Pair(nn, 1));
                }
                idx++;
                top.state++;

            } else {
                // pop the top of stack
                st.pop();
            }
        }

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
        Integer[] data = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(data);
        display(root);
        levelOrderLineWise(root);
        prePostOrderRecursiveTravel(root);
    }

    private static void prePostOrderRecursiveTravel(Node node) {
        if (node == null) {
            return;
        }
        System.out.println("Node Pre: " + node.data);
        prePostOrderRecursiveTravel(node.left);
        System.out.println("Node In: " + node.data);
        prePostOrderRecursiveTravel(node.right);
        System.out.println("Node Post: " + node.data);
    }
}