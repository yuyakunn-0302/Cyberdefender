package cyberdefender;
import java.util.ArrayList;
public class Main{
	public static void main(String[] args) {
		InputManager input = new InputManager();
		QuestionManager questionManager = new QuestionManager();
		ArrayList<AnswerRecord> answerRecords = new ArrayList<AnswerRecord>();
		Statistics statistics = new Statistics();
		Game game = new Game(input, questionManager, answerRecords);
		Teacher teacher = new Teacher(1,"田中先生","teacher" );
		Student student = new Student(101,"田中太郎","student");
		
		while(true){
			System.out.println();
			System.out.println("=====Cyberdefender=====");
			System.out.println("1. 教師");
			System.out.println("2. 生徒");
			System.out.println("3. 終了");
			
			int userType = input.readInt("選択してください:", 1, 3);
			
			if(userType == 1) {
				while(true) {
					teacher.showMenu();
					int menu = input.readInt("選択してください:", 1,8);
					if(menu == 1) {
						questionManager.createQuestion(input);
					}else if(menu == 2){
						questionManager.showQuestions();
					}else if(menu == 3){
						questionManager.updateQuestion(input);
					}else if(menu == 4){
						questionManager.deleteQuestion(input);
					}else if(menu == 5){
						questionManager.searchQuestion(input);
					}else if(menu == 6){
						questionManager.sortQuestions(input);
					}else if(menu == 7) {
						statistics.showStatistics(answerRecords);
					}else if(menu == 8) {
						System.out.println("ログアウトしました");
						break;
					}
				}
			}else if(userType == 2) {
				while(true) {
					student.showMenu();
					int menu = input.readInt("選択してください:",1,4);
					if(menu == 1) {	
						game.play(student);
					}else if(menu == 2) {
						game.showHistory(student.getId());
					}else if(menu == 3) {
						statistics.showStudentStatistics(answerRecords, student.getId());
					}else if(menu == 4) {
						System.out.println("ログアウトしました");
						break;
					}
				}
			}else if(userType == 3) {
				System.out.println("Cyberdefenderを終了します");
				break;
			}
		}
		input.close();
	}
}