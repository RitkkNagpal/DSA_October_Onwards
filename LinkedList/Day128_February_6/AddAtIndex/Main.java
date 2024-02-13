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

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public Node getTail() {
            return tail;
        }

        public void setTail(Node tail) {
            this.tail = tail;
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
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            LinkedList list = new LinkedList();
            String str = br.readLine();
            while (str.equals("quit") == false) {
                if (str.startsWith("addLast")) {
                    int val = Integer.parseInt(str.split(" ")[1]);
                    list.addLast(val);
                } else if (str.startsWith("addFirst")) {
                    int val = Integer.parseInt(str.split(" ")[1]);
                    list.addFirst(val);
                } else if (str.startsWith("addAt")) {
                    int idx = Integer.parseInt(str.split(" ")[1]);
                    int val = Integer.parseInt(str.split(" ")[2]);
                    list.addAtIndex(idx, val);
                    list.display();
                    System.out.println();
                }
                str = br.readLine();
            }
            list.display();
        }
    }

}