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

    public static Node linearizeEfficient(Node node) {
        if (node.children.size() == 0) {
            return node;
        }

        Node tailNodeLastChild = linearizeEfficient(node.children.get(node.children.size() - 1));
        while (node.children.size() > 1) {
            Node lastNode = node.children.remove(node.children.size() - 1);
            Node secondLastNode = node.children.get(node.children.size() - 1);
            Node tailSecondLastNode = linearizeEfficient(secondLastNode);
            tailSecondLastNode.children.add(lastNode);
        }
        return tailNodeLastChild;
    }

    public static boolean find(Node node, int target) {
        if (node.data == target) {
            return true;
        }

        for (Node child : node.children) {
            boolean foundInSubtree = find(child, target);
            if (foundInSubtree == true) {
                return true;
            }
        }
        return false;
    }

    public static List<Node> nodeToRootPath(Node node, int target) {
        if (node.data == target) {
            List<Node> base = new ArrayList<>();
            base.add(node);
            return base;
        }

        for (Node child : node.children) {
            List<Node> childToRootPath = nodeToRootPath(child, target);
            if (childToRootPath.size() > 0) {
                childToRootPath.add(node);
                return childToRootPath;
            }
        }
        return new ArrayList<>();
    }

    public static int lowestCommonAnscestor(Node node, int d1, int d2) {
        List<Node> d1ToRootPath = nodeToRootPath(node, d1);
        System.out.println(d1ToRootPath);
        List<Node> d2ToRootPath = nodeToRootPath(node, d2);
        System.out.println(d2ToRootPath);
        int i = d1ToRootPath.size() - 1, j = d2ToRootPath.size() - 1;
        while (i >= 0 && j >= 0 && d1ToRootPath.get(i).data == d2ToRootPath.get(j).data) {
            i--;
            j--;
        }

        return d1ToRootPath.get(i + 1).data;
    }

    public static int distance(Node node, int n1, int n2) {
        List<Node> d1ToRootPath = nodeToRootPath(node, n1);
        System.out.println(d1ToRootPath);
        List<Node> d2ToRootPath = nodeToRootPath(node, n2);
        System.out.println(d2ToRootPath);
        int i = d1ToRootPath.size() - 1, j = d2ToRootPath.size() - 1;
        while (i >= 0 && j >= 0 && d1ToRootPath.get(i).data == d2ToRootPath.get(j).data) {
            i--;
            j--;
        }
        return i + j + 2;
    }

    public static boolean areTreesSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);
            boolean areChildrenSimilar = areTreesSimilar(c1, c2);
            if (areChildrenSimilar == false) {
                return false;
            }
        }

        return true;
    }

    public static boolean areTreesMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(n2.children.size() - i - 1);
            boolean areChildrenMirror = areTreesMirror(c1, c2);
            if (areChildrenMirror == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTreeSymmetric(Node root) {
        return areTreesMirror(root, root);
    }

    public static void main(String[] args) {
        int[] arr1 = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, -1, 40, 100, -1, -1, -1 };
        int[] arr2 = { 10, 40, 100, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, -1, 20, 50, -1, 60, -1, -1, -1 };
        Node root1 = construct(arr1);
        Node root2 = construct(arr2);
        boolean isSymmetric = isTreeSymmetric(root1);
        System.out.println("Is tree Symmetric: " + isSymmetric);
    }
}