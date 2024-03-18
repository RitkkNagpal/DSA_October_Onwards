import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
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

        @Override
        public String toString() {
            return data + "";
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

    private static int dia;

    public static void diameter(Node root) {
        dia = 0;
        height(root);
    }

    private static int height(Node node) {
        int childBestHt = -1;
        int childSecondBestHt = -1;

        for (Node child : node.children) {
            int childHt = height(child);
            if (childHt > childBestHt) {
                childSecondBestHt = childBestHt;
                childBestHt = childHt;
            } else if (childHt > childSecondBestHt) {
                childSecondBestHt = childHt;
            }
        }
        int diameter = childBestHt + childSecondBestHt + 2;
        if (diameter > dia) {
            dia = diameter;
        }
        return childBestHt + 1;
    }

    static class Pair {
        Node node;
        int state;

        Pair() {

        }

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static String pre = "";
    static String post = "";

    public static void iterativePreOrderPostOrder(Node node) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));
        while (!st.isEmpty()) {
            Pair top = st.peek();
            if (top.state == -1) {
                // preorder
                pre += (top.node.data + " ");
                top.state++;
            } else if (top.state > -1 && top.state < top.node.children.size()) {
                st.push(new Pair(top.node.children.get(top.state), -1));
                top.state++;
            } else if (top.state == top.node.children.size()) {
                post += (top.node.data + " ");
                st.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 10, 20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1 };
        Node root1 = construct(arr1);
        iterativePreOrderPostOrder(root1);
        System.out.println("pre: " + pre);
        System.out.println("post: " + post);
    }
}