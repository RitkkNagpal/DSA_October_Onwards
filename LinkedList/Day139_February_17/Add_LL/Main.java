import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

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
        }

        public static LinkedList addLL(LinkedList l1, LinkedList l2) {
            LinkedList res = new LinkedList();
            int c = addLLHelper(l1.head, l1.size - 1, l2.head, l2.size - 1, res);
            if (c > 0) {
                res.addFirst(c);
            }
            return res;
        }

        private static int addLLHelper(Node h1, int pv1, Node h2, int pv2, LinkedList res) {
            if (h1 == null && h2 == null) {
                return 0;
            }

            if (pv1 == pv2) {
                int c = addLLHelper(h1.next, pv1 - 1, h2.next, pv2 - 1, res);
                int val = h1.data + h2.data + c;
                res.addFirst(val % 10);
                return val / 10;
            } else if (pv1 > pv2) {
                int c = addLLHelper(h1.next, pv1 - 1, h2, pv2, res);
                int val = h1.data + c;
                res.addFirst(val % 10);
                return val / 10;
            } else {
                int c = addLLHelper(h1, pv1, h2.next, pv2 - 1, res);
                int val = h2.data + c;
                res.addFirst(val % 10);
                return val / 10;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        LinkedList list1 = new LinkedList();
        list1.addLast(1);
        LinkedList list2 = new LinkedList();
        list2.addLast(9);
        list2.addLast(9);
        list2.addLast(9);
        System.out.println("List 1 - ");
        list1.display();
        System.out.println();
        System.out.println("List 2 - ");
        list2.display();
        System.out.println();
        System.out.println("Result List");
        LinkedList resList = LinkedList.addLL(list1, list2);
        resList.display();
    }
}