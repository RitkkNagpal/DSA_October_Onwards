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
            list.addLast(12);
            list.addLast(13);
            list.addLast(14);
            list.addLast(15);
            list.addLast(16);
            list.addLast(17);
            list.addLast(18);
            list.addLast(19);
            list.display();
            System.out.println();
            String str = br.readLine();
            while (str.equals("quit") == false) {
                if (str.startsWith("getLast")) {
                    int val = list.getLast();
                    System.out.println(val);
                } else if (str.startsWith("getFirst")) {
                    int val = list.getFirst();
                    System.out.println(val);
                } else if (str.startsWith("getAt")) {
                    int val = list.getAt(Integer.parseInt(str.split(" ")[1]));
                    System.out.println(val);
                }
                str = br.readLine();
            }
        }
    }
}