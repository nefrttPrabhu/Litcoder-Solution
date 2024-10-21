import java.util.*;

class CustomStack {
    private StringBuilder text;
    private Stack<Command> history;

    public CustomStack() {
        text = new StringBuilder();
        history = new Stack<>();
    }

    public void insert(String value) {
        history.push(new Command(1, value.length()));
        text.append(value);
    }

    public void delete(int value) {
        if (value > text.length()) {
            value = text.length();
        }
        String deletedText = text.substring(text.length() - value);
        history.push(new Command(2, deletedText));
        text.delete(text.length() - value, text.length());
    }

    public char get(int index) {
        if (index < 1 || index > text.length()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return text.charAt(index - 1);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            if (lastCommand.type == 1) { // Undo insert
                text.delete(text.length() - lastCommand.value, text.length());
            } else if (lastCommand.type == 2) { // Undo delete
                text.append(lastCommand.deletedText);
            }
        }
    }

    private static class Command {
        int type; // 1 for insert, 2 for delete
        int value; // length for insert, deleted text for undo delete
        String deletedText; // stores deleted text for undoing delete

        Command(int type, int value) {
            this.type = type;
            this.value = value;
            this.deletedText = null;
        }

        Command(int type, String deletedText) {
            this.type = type;
            this.deletedText = deletedText;
        }
    }
}

public class L12 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CustomStack editor = new CustomStack();
        
        String[] commands = input.nextLine().split(",");
        for (String command : commands) {
            String[] parts = command.trim().split(" ");
            int cmdType = Integer.parseInt(parts[0]);
            switch (cmdType) {
                case 1 -> editor.insert(parts[1]);
                case 2 -> editor.delete(Integer.parseInt(parts[1]));
                case 3 -> {
                    char result = editor.get(Integer.parseInt(parts[1]));
                    System.out.println(result);
                }
                case 4 -> editor.undo();
                default -> {
                }
            }
        }
        
        input.close();
    }
    
    public static int doSomething(int x, int y) {
        return x + y; // Example functionality
    }
}
