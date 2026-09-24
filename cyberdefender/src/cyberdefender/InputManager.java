package cyberdefender;
import java.util.Scanner;
public class InputManager {
    private Scanner scanner = new Scanner(System.in);
    public String readText(String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim();
            if (!text.isEmpty()) {
                return text;
            }
            System.out.println("エラー：入力してください。");
        }
    }
    public int readInt(String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim();
            try {
                int number = Integer.parseInt(text);
                if (number >= min && number <= max) {
                    return number;
                }
            } catch (NumberFormatException e) {
            }

            System.out.println("エラー：数字を入力してください。");
        }
    }
    public void close() {
        scanner.close();
    }
}