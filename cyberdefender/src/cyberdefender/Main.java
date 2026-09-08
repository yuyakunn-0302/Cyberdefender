package cyberdefender;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        // 入力処理
        InputManager input = new InputManager();
        // 問題管理
        QuestionManager questionManager = new QuestionManager();
        // 解答履歴
        ArrayList<AnswerRecord> answerRecords = new ArrayList<>();
        // 統計
        Statistics statistics = new Statistics();
        // ゲーム
        Game game = new Game(input,questionManager,answerRecords);

        // サンプル問題
        String[] choices = {
                "すぐにURLをクリックする",
                "公式サイトを自分で開いて確認する",
                "メールに返信する",
                "友達に転送する"
        };

        // 問題を作成
        Question question = new Question(
                1,
                "不審なメールが届きました。安全な対応はどれ？",
                choices,
                2,
                "メールのURLを直接クリックせず、公式サイトを自分で開いて確認しましょう。",
                "フィッシング詐欺",
                "初級"
        );

        // 問題を登録
        questionManager.addQuestion(question);

        // 教師を作成
        Teacher teacher = new Teacher(1,"田中先生","teacher");

        // 生徒を作成
        Student student = new Student(101,"田中太郎","student");

        // メインメニュー
        while (true) {

            System.out.println();
            System.out.println("==============================");
            System.out.println("       CYBERDEFENDER");
            System.out.println("==============================");
            System.out.println("1. 教師");
            System.out.println("2. 生徒");
            System.out.println("3. 終了");

            int choice = input.readInt("選択してください：",1,3);

            // 終了
            if (choice == 3) {
                System.out.println("Cyberdefenderを終了します。");
                break;
            }

            // 教師
            if (choice == 1) {
                teacherMenu(input,teacher,questionManager,statistics,answerRecords);
            }

            // 生徒
            else if (choice == 2) {
                studentMenu(input,student,game,statistics,answerRecords);
            }
        }
        // Scannerを終了
        input.close();
    }

    // 教師メニュー
    private static void teacherMenu(
            InputManager input,
            Teacher teacher,
            QuestionManager questionManager,
            Statistics statistics,
            ArrayList<AnswerRecord> answerRecords) {
       
    	while (true) {
            // 教師メニューを表示
            teacher.showMenu();
            int choice = input.readInt("選択してください：",1,8);
            // 問題登録
            if (choice == 1) {
                questionManager.createQuestion(input);
            }
            // 問題一覧
            else if (choice == 2) {
                questionManager.showQuestions();
            }
            // 問題更新
            else if (choice == 3) {
                questionManager.updateQuestion(input);
            }
            // 問題削除
            else if (choice == 4) {
                questionManager.deleteQuestion(input);
            }
            // 問題検索
            else if (choice == 5) {
                questionManager.searchQuestion(input);
            }
            // 並び替え
            else if (choice == 6) {
                questionManager.sortQuestions(input);
            }
            // 学習データ
            else if (choice == 7) {
                statistics.showStatistics(answerRecords);
            }
            // ログアウト
            else if (choice == 8) {
                System.out.println("ログアウトしました。");
                break;
            }
        }
    }
    // 生徒メニュー
    private static void studentMenu(
            InputManager input,
            Student student,
            Game game,
            Statistics statistics,
            ArrayList<AnswerRecord> answerRecords) {

        while (true) {
            // 生徒メニューを表示
            student.showMenu();
            int choice = input.readInt("選択してください：",1,4);

            // 問題を解く
            if (choice == 1) {
                game.start(student);
            }

            // 解答履歴
            else if (choice == 2) {
                game.showHistory(student.getId());
            }

            // 自分の成績
            else if (choice == 3) {
                statistics.showStudentStatistics(answerRecords,student.getId());
            }
            // ログアウト
            else if (choice == 4) {
                System.out.println("ログアウトしました。");
                break;
            }
        }
    }
}