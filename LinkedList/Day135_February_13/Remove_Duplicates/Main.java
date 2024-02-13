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

        private Node getNodeAt(int idx) {
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

        public int midOfLL() {
            return midOfLL(head).data;
        }

        private Node midOfLL(Node head) {
            Node slow = head;
            Node fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private void removeDuplicatesFromSortedList() {
            LinkedList newList = new LinkedList();
            while (this.size != 0) {
                int data = this.getFirst();
                if (newList.size == 0 || newList.tail.data != data) {
                    newList.addLast(data);
                }
                this.removeFirst();
            }

            this.head = newList.head;
            this.tail = newList.tail;
            this.size = newList.size;
        }

    }

    public static LinkedList mergeTwoSortedLinkedList(LinkedList l1, LinkedList l2) {
        LinkedList mergedLinkedList = new LinkedList();
        Node l1Node = l1.head;
        Node l2Node = l2.head;
        while (l1Node != null && l2Node != null) {
            if (l1Node.data < l2Node.data) {
                mergedLinkedList.addLast(l1Node.data);
                l1Node = l1Node.next;
            } else {
                mergedLinkedList.addLast(l2Node.data);
                l2Node = l2Node.next;
            }
        }

        while (l1Node != null) {
            mergedLinkedList.addLast(l1Node.data);
            l1Node = l1Node.next;
        }

        while (l2Node != null) {
            mergedLinkedList.addLast(l2Node.data);
            l2Node = l2Node.next;
        }
        return mergedLinkedList;
    }

    public static LinkedList mergeSort(LinkedList list) {
        return mergeSort(list.head, list.tail);
    }

    private static LinkedList mergeSort(Node head, Node tail) {
        if (head == tail) {
            LinkedList list = new LinkedList();
            list.addLast(head.data);
            return list;
        }
        Node mid = middleOfLL(head, tail);
        LinkedList left = mergeSort(head, mid);
        LinkedList right = mergeSort(mid.next, tail);
        return mergeTwoSortedLinkedList(left, right);
    }

    private static Node middleOfLL(Node head, Node tail) {
        if (head != tail || head.next != tail) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node kthNodeFromEnd(LinkedList list, int k) {
        if (list.head == null)
            return null;
        Node slow = list.head;
        Node fast = list.head;

        for (int i = 0; i <= k && fast != null; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    private static void removeDuplicatesFromSortedList(LinkedList list) {
        Node headNode = list.head;
        Node tailNode = list.head;

        while (true) {
            Node traversingNode = tailNode;
            while (traversingNode.next != null && traversingNode.data == traversingNode.next.data) {
                traversingNode = traversingNode.next;
            }
            if (traversingNode.next != null) {
                tailNode = tailNode.next = traversingNode.next;
            } else {
                break;
            }
        }
        tailNode.next = null;
        list.head = headNode;
        list.tail = tailNode;
    }

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.addLast(2);
        list.addLast(2);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.addLast(5);
        list.addLast(5);
        list.addLast(5);
        list.addLast(5);
        list.addLast(5);
        System.out.println("List before removing duplicates");
        list.display();
        System.out.println();
        // removeDuplicatesFromSortedList(list);
        list.removeDuplicatesFromSortedList();
        list.display();
    }
}