import java.util.*;

class CustomQueue {
    @SuppressWarnings("FieldMayBeFinal")
    private Stack<Integer> stack1;
    @SuppressWarnings("FieldMayBeFinal")
    private Stack<Integer> stack2;

    public CustomQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int x) {
        stack1.push(x);
    }

    public void dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            stack2.pop();
        }
    }

    public int front() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        throw new NoSuchElementException("Queue is empty");
    }
}

public class L13 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CustomQueue queue = new CustomQueue();
        
        String[] commands = input.nextLine().split(",");
        for (String command : commands) {
            String[] parts = command.trim().split(" ");
            int cmdType = Integer.parseInt(parts[0]);
            switch (cmdType) {
                case 1 -> queue.enqueue(Integer.parseInt(parts[1]));
                case 2 -> queue.dequeue();
                case 3 -> {
                    int result = queue.front();
                    System.out.println(result);
                }
                default -> {
                }
            }
        }
        
        input.close();
    }
    
    public static int doSomething(int x, int y) {
        return x + y; // Example functionality, replace as needed
    }
}
