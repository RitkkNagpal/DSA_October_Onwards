import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Main
 */
public class Main {

    public static class LLToStackAdapter {
        LinkedList<Integer> list;

        public LLToStackAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);
        }

        int pop() {
            if (list.isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }
            return list.removeFirst();
        }

        int top() {
            if (list.isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }
            return list.getFirst();
        }

        void display() {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        LLToStackAdapter st = new LLToStackAdapter();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            while (str.equals("quit") == false) {
                if (str.startsWith("push")) {
                    int val = Integer.parseInt(str.split(" ")[1]);
                    st.push(val);
                    st.display();
                } else if (str.startsWith("pop")) {
                    int val = st.pop();
                    System.out.println(val);
                    st.display();
                } else if (str.startsWith("top")) {
                    int val = st.top();
                    System.out.println(val);
                    st.display();
                } else if (str.startsWith("size")) {
                    int size = st.size();
                    System.out.println(size);
                }
                str = br.readLine();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}