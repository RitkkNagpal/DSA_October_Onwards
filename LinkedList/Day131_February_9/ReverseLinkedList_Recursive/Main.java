import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        private int data;
        private Node next;

        public Node() {
            // DEFAULT CONSTRUCTOR
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static class LinkedList {
        private Node head;
        private Node tail;
        private int size;

        public void addLast(int val) {
            Node nn = new Node(val, null);
            if (head == null) {
                head = nn;
                tail = nn;
            } else {

                tail = tail.next = nn;
            }
            size++;
        }

        public void addFirst(int val) {
            Node nn = new Node(val, null);
            if (head == null) {
                head = nn;
                tail = nn;
            } else {
                nn.next = head;
                head = nn;
            }
            size++;
        }

        public void addAtIndex(int idx, int val) {
            Node nn = new Node(val, null);
            if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                int i = 1;
                Node temp = head;
                while (temp != null && i < idx) {
                    temp = temp.next;
                    i++;
                }
                if (temp != null) {
                    nn.next = temp.next;
                    temp.next = nn;
                }
            }
            size++;
        }

        public int getFirst() {
            if (this.head == null) {
                System.out.println("No element in list");
                return -1;
            }

            return this.head.data;
        }

        public int getLast() {
            if (this.tail == null) {
                System.out.println("No element in list");
                return -1;
            }
            return this.tail.data;
        }

        public int getAt(int idx) {
            if (this.head == null) {
                System.out.println("No element in list");
                return -1;
            } else if (idx == 0) {
                return getFirst();
            } else if (idx == size - 1) {
                return getLast();
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid Arguements");
                return -1;
            } else {
                Node temp = head;
                int i = 1;
                while (i <= idx) {
                    temp = temp.next;
                    i++;
                }
                return temp.data;
            }
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("No element in list");
                return;
            } else if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
            }
            size--;
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("No element in list");
                return;
            } else if (size == 1) {
                head = tail = null;
            } else {
                Node secondLastNode = getNodeAt(size - 2);
                secondLastNode.next = null;
                tail = secondLastNode;
            }
            size--;
        }

        public void removeAt(int idx) {
            if (size == 0) {
                System.out.println("No element in list");
                return;
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else if (idx < 0 || idx >= size) {
                // System.out.println(size + " size " + idx + " idx");
                System.out.println("Invalid Arguements");
                return;
            } else {
                Node prevNode = getNodeAt(idx - 1);
                Node curr = prevNode.next;
                Node nextNode = curr.next;
                curr.next = null;
                prevNode.next = nextNode;
                size--;
            }
        }

        public Node getNodeAt(int idx) {
            if (size == 0) {
                System.out.println("Empty List");
                return null;
            }
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid index");
                return null;
            }
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public int getSize() {
            return size;
        }

        public void display() {
            if (size == 0) {
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println();
        }

        public void reverseDataIterative() {
            int stNodeIdx = 0;
            int endNodeIdx = getSize() - 1;
            while (stNodeIdx < endNodeIdx) {
                Node stNode = getNodeAt(stNodeIdx);
                Node endNode = getNodeAt(endNodeIdx);
                reverseData(stNode, endNode);
                stNodeIdx++;
                endNodeIdx--;
            }
        }

        public void reversePointerIterative() {
            Node newTail = head;
            Node prev = null;
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            this.head = prev;
            this.tail = newTail;
        }

        private Node traversingNode;

        public void reverseDataRecursive() {
            traversingNode = head;
            reverseDataRecursiveHelper(traversingNode, 0);
        }

        private void reverseDataRecursiveHelper(Node node, int count) {
            if (count == size) {
                return;
            }
            reverseDataRecursiveHelper(node.next, count + 1);
            if (count >= size / 2) {
                reverseData(node, traversingNode);
                traversingNode = traversingNode.next;
            }
        }

        public void reverseDataRecursiveReturnType() {
            traversingNode = head;
            reverseDataRecursiveHelperWithReturnType(head, head, 0);
        }

        private Node reverseDataRecursiveHelperWithReturnType(Node head, Node right, int count) {
            if (right == null) {
                return head;
            }
            Node left = reverseDataRecursiveHelperWithReturnType(head, right.next, count + 1);
            if (count >= size / 2) {
                reverseData(left, right);
            }
            return left.next;
        }

        Node prevNode;
        Node currNode;

        private void reversePointerRecursive() {
            prevNode = null;
            currNode = head;
            reversePointerRecursiveHelper(head);
            Node temp = this.head;
            this.head = this.tail;
            this.tail = temp;
        }

        private void reversePointerRecursiveHelper(Node node) {
            if (node == null)
                return;
            Node next = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = next;
            reversePointerRecursiveHelper(next);
        }

        private void reversePointerRecursive2() {
            reversePointerRecursiveHelper2(head);
            this.head.next = null;
            Node temp = this.head;
            this.head = this.tail;
            this.tail = temp;
        }

        private void reversePointerRecursiveHelper2(Node curr) {
            if (curr == tail)
                return;
            reversePointerRecursiveHelper2(curr.next);
            Node nextNode = curr.next;
            nextNode.next = curr;
        }

        private void displayReverseRecursive() {
            displayReverseRecursiveHelper(head);
            System.out.println();
        }

        private void displayReverseRecursiveHelper(Node node) {
            if (node == null)
                return;
            displayReverseRecursiveHelper(node.next);
            System.out.print(node.data + " -> ");
        }
    }

    private static void reverseData(Node n1, Node n2) {
        int temp = n1.data;
        n1.data = n2.data;
        n2.data = temp;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            LinkedList list = new LinkedList();
            list.addLast(12);
            list.addLast(13);
            list.addLast(14);
            list.addLast(15);
            list.addLast(16);
            list.addLast(17);
            list.addLast(18);
            list.addLast(19);
            System.out.println("Before Reverse");
            list.display();
            list.reverseDataIterative();
            System.out.println("After Data Iterative Reverse");
            list.display();
            list.reversePointerIterative();
            System.out.println("After Pointer Iterative Reverse");
            list.display();
            list.reverseDataRecursive();
            System.out.println("After Data Recursive Reverse");
            list.display();
            list.reverseDataRecursiveReturnType();
            System.out.println("After Data Recursive Reverse ");
            list.display();
            list.reversePointerRecursive();
            System.out.println("After Pointer Recursive");
            list.display();
            list.reversePointerRecursive2();
            System.out.println("After Pointer Recursive2");
            list.display();
            System.out.println("Reverse of above list");
            list.displayReverseRecursive();
        }
    }
}