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

    static class BSTPair {
        boolean isBST;
        int max;
        int min;
        int count;

        BSTPair(boolean isBST, int max, int min, int count) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.count = count;
        }

        BSTPair() {

        }
    }

    static Node largestBSTRootNode;
    static int countLargestBSTNodes;

    private static BSTPair isBST(Node node) {
        if (node == null) {
            return new BSTPair(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        BSTPair leftPair = isBST(node.left);
        BSTPair rightPair = isBST(node.right);

        BSTPair self = new BSTPair();
        boolean isSelfBST = (node.data >= leftPair.max) && (node.data <= rightPair.min);
        self.isBST = leftPair.isBST && rightPair.isBST && isSelfBST;
        self.max = Math.max(Math.max(rightPair.max, leftPair.max), node.data);
        self.min = Math.min(Math.min(rightPair.min, leftPair.min), node.data);
        self.count = leftPair.count + rightPair.count + 1;
        if (self.isBST && self.count >= countLargestBSTNodes) {
            largestBSTRootNode = node;
            countLargestBSTNodes = self.count;
        }
        return self;
    }

    public static void main(String[] args) {
        // Integer[] data = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62,
        // null, 70, null, null, 87, null,
        // null };
        Integer[] data = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 89, null, null, 87, null,
                null };
        Node root = construct(data);
        display(root);
        levelOrderLineWise(root);
        isBST(root);
        System.out.println(largestBSTRootNode.data + "@" + countLargestBSTNodes);
    }
}