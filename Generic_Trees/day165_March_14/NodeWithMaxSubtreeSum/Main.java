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

    static int maxSum;
    static Node maxSumNode;

    public static int nodeWithMaximumSubTreeSum(Node node) {
        int subtreeSum = node.data;
        for (Node child : node.children) {
            subtreeSum += nodeWithMaximumSubTreeSum(child);
        }
        if (subtreeSum > maxSum) {
            maxSum = subtreeSum;
            maxSumNode = node;
        }
        return subtreeSum;
    }

    public static void main(String[] args) {
        int[] arr1 = { 10, 20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1 };
        Node root1 = construct(arr1);
        maxSumNode = null;
        maxSum = Integer.MIN_VALUE;
        nodeWithMaximumSubTreeSum(root1);
        System.out.println(maxSumNode + "@" + maxSum);
    }
}