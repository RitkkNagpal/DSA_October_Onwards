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

    private static int height(Node node) {
        if (node == null) {
            return -1;
        }
        int leftSubtreeHt = height(node.left);
        int rightSubtreeHt = height(node.right);
        int bf = Math.abs(rightSubtreeHt - leftSubtreeHt);
        if (bf > 1) {
            isBalanced = false;
        }
        return Math.max(leftSubtreeHt, rightSubtreeHt) + 1;
    }

    private static int height1(Node node) {
        if (node == null) {
            return -1;
        }
        int leftSubtreeHt = height(node.left);
        int rightSubtreeHt = height(node.right);
        return Math.max(leftSubtreeHt, rightSubtreeHt) + 1;
    }

    static boolean isBalanced;

    private static boolean isTreeBalanced(Node node) {
        isBalanced = true;
        height(node);
        return isBalanced;
    }

    public static void main(String[] args) {
        Integer[] data = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(data);
        display(root);
        levelOrderLineWise(root);
        System.out.println("Is Binary Tree Balanced: " + isTreeBalanced(root));
        System.out.println("Is Binary Tree Balanced: " + isTreeBalanced2(root).isBalanced);
    }

    static class BalPair {
        int ht;
        boolean isBalanced;

        BalPair() {

        }

        BalPair(int ht, boolean isBalanced) {
            this.ht = ht;
            this.isBalanced = isBalanced;
        }
    }

    private static BalPair isTreeBalanced2(Node node) {
        if (node == null) {
            return new BalPair(0, true);
        }
        BalPair leftSubtreeBalPair = isTreeBalanced2(node.left);
        BalPair rightSubtreeBalPair = isTreeBalanced2(node.right);

        int bf = Math.abs(leftSubtreeBalPair.ht - rightSubtreeBalPair.ht);

        boolean isSelfBalanced = leftSubtreeBalPair.isBalanced && rightSubtreeBalPair.isBalanced && bf <= 1;
        int selfHt = Math.max(leftSubtreeBalPair.ht, rightSubtreeBalPair.ht) + 1;
        BalPair selfBalPair = new BalPair(selfHt, isSelfBalanced);
        return selfBalPair;
    }
}