package cyberdefender;
import java.util.Scanner;
public class InputManager{
	private Scanner scanner = new Scanner(System.in);
	public String readText(String massage) {
		while(true) {
			System.out.println(massage);
			String text = scanner.nextLine();
			if(!text.trim().isEmpty()) {
				return text;
			}
			System.out.println("入力してください");
		}
	}
	public int readInt(String massage, int min, int max) {
		while(true) {
			System.out.println(massage);
			String text = scanner.nextLine();
			try {
				int number = Integer.parseInt(text);
				if(number >= min && number <= max) {
					return number;
				}
				System.out.println(min + "~" + max + "の数字を入力してください");
			}catch (NumberFormatException e) {
				System.out.println("数字を入力してください");
			}
		}
	}
	public void close() {
		scanner.close();
	}
}