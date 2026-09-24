package cyberdefender;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        InputManager input = new InputManager();
        
        QuestionManager questionManager = new QuestionManager();
        
        ArrayList<AnswerRecord> answerRecords = new ArrayList<>();
        
        Statistics statistics = new Statistics();
        
        Game game = new Game(input,questionManager,answerRecords);
        
        String[] choices = {
                "すぐにURLをクリックする",
                "公式サイトを自分で開いて確認する",
                "メールに返信する",
                "友達に転送する"
        };

        Question question = new Question(
                1,
                "不審なメールが届きました。安全な対応はどれ？",
                choices,
                2,
                "メールのURLを直接クリックせず、公式サイトを自分で開いて確認しましょう。",
                "フィッシング詐欺",
                "初級"
        );
        questionManager.addQuestion(question);
        Teacher teacher = new Teacher(1,"田中先生","teacher");
        Student student = new Student(101,"田中太郎","student");

        while (true) {
            System.out.println();
            System.out.println("==============================");
            System.out.println("       CYBERDEFENDER");
            System.out.println("==============================");
            System.out.println("1. 教師");
            System.out.println("2. 生徒");
            System.out.println("3. 終了");

            int choice = input.readInt("選択してください：",1,3);
            
            if (choice == 3) {
                System.out.println("Cyberdefenderを終了します。");
                break;
            }
            if (choice == 1) {
                teacherMenu(input,teacher,questionManager,statistics,answerRecords);
            }else 
            	if (choice == 2) {
                studentMenu(input,student,game,statistics,answerRecords);
            }
        }
        input.close();
    }

    private static void teacherMenu(
            InputManager input,
            Teacher teacher,
            QuestionManager questionManager,
            Statistics statistics,
            ArrayList<AnswerRecord> answerRecords) {
       
    	while (true) {
            teacher.showMenu();
            int choice = input.readInt("選択してください：",1,8);
            if (choice == 1) {
                questionManager.createQuestion(input);
            }else 
            	if (choice == 2) {
                questionManager.showQuestions();
            }else 
            	if (choice == 3) {
                questionManager.updateQuestion(input);
            }else 
            	if (choice == 4) {
                questionManager.deleteQuestion(input);
            }else 
            	if (choice == 5) {
                questionManager.searchQuestion(input);
            }else 
            	if (choice == 6) {
                questionManager.sortQuestions(input);
            }else 
            	if (choice == 7) {
                statistics.showStatistics(answerRecords);
            }else 
            	if (choice == 8) {
                System.out.println("ログアウトしました。");
                break;
            }
        }
    }
    private static void studentMenu(
            InputManager input,
            Student student,
            Game game,
            Statistics statistics,
            ArrayList<AnswerRecord> answerRecords) {

        while (true) {
            student.showMenu();
            int choice = input.readInt("選択してください：",1,4);
            if (choice == 1) {
                game.start(student);
            }else if (choice == 2) {
                game.showHistory(student.getId());
            }else 
            	if (choice == 3) {
                statistics.showStudentStatistics(answerRecords,student.getId());
            }else 
            	if (choice == 4) {
                System.out.println("ログアウトしました。");
                break;
            }
        }
    }
}