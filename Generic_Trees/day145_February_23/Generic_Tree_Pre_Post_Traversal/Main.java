import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static class Node {
        int data;
        List<Node> children;

        Node() {
            this.children = new ArrayList<>();
        }

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public static Node construct(int[] arr) {
        Stack<Node> st = new Stack<>();
        Node root = new Node(arr[0]);
        st.push(root);

        for (int i = 1; i < arr.length; i++) {
            int ele = arr[i];
            if (ele != -1) {
                Node nn = new Node(ele);
                Node top = st.peek();
                top.children.add(nn);
                st.push(nn);
            } else {
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node root) {
        System.out.print(root.data + " -> ");
        for (Node children : root.children) {
            System.out.print(children.data + ", ");
        }
        System.out.println();
        for (Node children : root.children) {
            display(children);
        }
    }

    public static int maximumInTree(Node node) {
        int max = node.data;
        for (Node children : node.children) {
            max = Math.max(max, maximumInTree(children));
        }
        return max;
    }

    public static int heightOfTree(Node node) {
        int height = -1;
        for (Node children : node.children) {
            height = Math.max(height, heightOfTree(children));
        }
        return height + 1;
    }

    public static void prePostOrderTraversal(Node node) {
        System.out.println("Node pre: " + node.data);
        for (Node child : node.children) {
            System.out.println("Edge Pre -- " + node.data + " -> " + child.data);
            prePostOrderTraversal(child);
            System.out.println("Edge Post -- " + node.data + " -> " + child.data);
        }
        System.out.println("Node post: " + node.data);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, -1, 40, 100, -1, -1, -1 };
        Node root = construct(arr);
        // display(root);
        System.out.println("Size: " + maximumInTree(root));
        System.out.println("Height: " + heightOfTree(root));
        prePostOrderTraversal(root);
    }
}