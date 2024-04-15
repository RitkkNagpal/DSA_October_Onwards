import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

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

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }

        return sum(node.left) + sum(node.right) + node.data;
    }

    public static int size(Node node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + size(node.right) + 1;
    }

    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(max(node.right), node.data);
    }

    public static int min(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(min(node.left), node.data);
    }

    public static boolean find(Node node, int target) {
        if (node == null) {
            return false;
        }

        if (node.data < target) {
            return find(node.right, target);
        } else if (node.data > target) {
            return find(node.left, target);
        } else if (node.data == target) {
            return true;
        } else {
            return false;
        }
    }

    private static Node removeNodeInBST(Node node, int val) {
        if(node == null) {
            return null;
        }
        if (node.data == val) {
            if (node.left == null && node.right == null) {
                // no child
                return null;
            } else if (node.left == null && node.right != null) {
                // single child
                return node.right;
            } else if (node.left != null && node.right == null) {
                // single child
                return node.left;
            } else {
                // two childs
                Node rightMostNode = getRightMostNode(node.left);
                node.data = rightMostNode.data;
                node.left = removeNodeInBST(node.left, node.data);
            }
        } else if (node.data > val) {
            node.left = removeNodeInBST(node.left, val);
        } else {
            node.right = removeNodeInBST(node.right, val);
        }
        return node;
    }

    private static Node getRightMostNode(Node node) {
        if (node.right != null) {
            return getRightMostNode(node.right);
        } else {
            return node;
        }
    }

    public static void main(String[] args) {
        // BST Can be constructed from a sorted Array
        int[] data = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87 };
        Node root = construct(data, 0, data.length - 1);
        display(root);
        levelOrderLineWise(root);
        Scanner scn = new Scanner(System.in);
        int val = scn.nextInt();
        removeNodeInBST(root, val);
        display(root);
        scn.close();
    }

}