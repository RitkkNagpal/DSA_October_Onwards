import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Main
 */
public class Main {

    public static class LLToQueueAdapter {
        LinkedList<Integer> list;

        public LLToQueueAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size();
        }

        void add(int val) {
            list.addLast(val);
        }

        int remove() {
            if (list.isEmpty()) {
                System.out.println("Queue underflow");
                return -1;
            }
            return list.removeFirst();
        }

        int peek() {
            if (list.isEmpty()) {
                System.out.println("Queue underflow");
                return -1;
            }
            return list.getFirst();
        }

        void display() {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        LLToQueueAdapter queue = new LLToQueueAdapter();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            while (str.equals("quit") == false) {
                if (str.startsWith("add")) {
                    int val = Integer.parseInt(str.split(" ")[1]);
                    queue.add(val);
                    queue.display();
                } else if (str.startsWith("remove")) {
                    int val = queue.remove();
                    System.out.println(val);
                    queue.display();
                } else if (str.startsWith("peek")) {
                    int val = queue.peek();
                    System.out.println(val);
                    queue.display();
                } else if (str.startsWith("size")) {
                    int size = queue.size();
                    System.out.println(size);
                }
                str = br.readLine();
            }
        } catch (Exception e) {
            // ignore
        }
    }
}