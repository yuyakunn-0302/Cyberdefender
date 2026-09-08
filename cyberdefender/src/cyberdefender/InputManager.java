package cyberdefender;

import java.util.Scanner;

public class InputManager {

    // Scanner
    private Scanner scanner = new Scanner(System.in);

    // 文字を入力
    public String readText(String message) {

        while (true) {

            System.out.print(message);

            String text = scanner.nextLine().trim();

            // 入力されている場合
            if (!text.isEmpty()) {
                return text;
            }

            // 空欄の場合
            System.out.println("エラー：入力してください。");
        }
    }

    // 数字を入力
    public int readInt(String message, int min, int max) {

        while (true) {

            System.out.print(message);

            String text = scanner.nextLine().trim();

            try {

                int number = Integer.parseInt(text);

                // 範囲内か確認
                if (number >= min && number <= max) {
                    return number;
                }

            } catch (NumberFormatException e) {

                // 数字ではない場合
            }

            System.out.println(
                    "エラー：数字を入力してください。"
            );
        }
    }

    // Scannerを終了
    public void close() {
        scanner.close();
    }
}