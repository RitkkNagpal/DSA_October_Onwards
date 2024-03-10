import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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

    public static void levelOrderTraversalLineWise2(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                // remove
                Node remNode = queue.remove();
                // print
                System.out.print(remNode.data + " ");
                // add children
                for (Node child : remNode.children) {
                    queue.add(child);
                }
            }
            // next line print
            System.out.println();
        }
    }

    public static void mirrorGT(Node root) {
        for (Node child : root.children) {
            mirrorGT(child);
        }

        int left = 0;
        int right = root.children.size() - 1;
        while (left < right) {
            Node lNode = root.children.get(left);
            Node rNode = root.children.get(right);

            root.children.set(left, rNode);
            root.children.set(right, lNode);
            left++;
            right--;
        }
    }

    public static void removeLeafNodes(Node root) {
        for (int i = root.children.size() - 1; i >= 0; i--) {
            Node child = root.children.get(i);
            if (child.children.size() == 0) {
                // leaf node
                root.children.remove(i);
            }
        }

        for (Node child : root.children) {
            removeLeafNodes(child);
        }

    }

    public static void linearize(Node root) {
        for (Node child : root.children) {
            linearize(child);
        }

        for (int i = root.children.size() - 1; i >= 1; i--) {
            Node lc = root.children.remove(i); // last child
            Node slc = root.children.get(i - 1); // second last child

            Node sLCTailNode = getTailNode(slc); // second last child tail node

            sLCTailNode.children.add(lc);
        }
    }

    private static Node getTailNode(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, -1, 40, 100, -1, -1, -1 };
        // int[] arr2 = { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };
        Node root = construct(arr);
        levelOrderTraversalLineWise2(root);
        linearize(root);
        levelOrderTraversalLineWise2(root);
    }
}