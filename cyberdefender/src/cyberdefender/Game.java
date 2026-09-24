package cyberdefender;
import java.util.List;
public class Game {
    private InputManager input;
    private QuestionManager questionManager;
    private List<AnswerRecord> answerRecords;
    public Game(InputManager input,QuestionManager questionManager,List<AnswerRecord> answerRecords) {
        this.input = input;
        this.questionManager = questionManager;
        this.answerRecords = answerRecords;
    }
    public void start(Student student) {
        System.out.println();
        System.out.println("==============================");
        System.out.println("       CYBERDEFENDER");
        System.out.println("==============================");

        if (questionManager.getQuestions().isEmpty()) {
            System.out.println("問題がありません。");
            return;
        }
        int score = 0;
        int number = 1;
        
        for (Question question :questionManager.getQuestions()) {
            System.out.println();
            System.out.println("第" + number + "問");

            question.showQuestion();
            int answer =input.readInt("回答：",1,4);
            boolean correct =answer == question.getAnswer();
            int point = 0;
            
            if (correct) {
                System.out.println("★ 正解！");
                point = 10;
                score += 10;
            }else {
                System.out.println("✕ 不正解...");
                System.out.println( "正解は" + question.getAnswer()+ "番です。");
            }
            System.out.println();
            System.out.println("【解説】");
            System.out.println(question.getExplanation()
            );

            AnswerRecord record =new AnswerRecord(student.getId(),question.getId(),answer,correct, point);
            answerRecords.add(record);
            number++;
        }
        System.out.println();
        System.out.println("==============================");
        System.out.println("ゲーム終了！");
        System.out.println("あなたの得点：" + score + "点");
        System.out.println("==============================");
    }
    public void showHistory(int studentId) {
        System.out.println();
        System.out.println("===== 解答履歴 =====");
        boolean found = false;
        
        for (AnswerRecord record :answerRecords) {
            if (record.getStudentId() == studentId) {
                found = true;
                System.out.println("問題ID："+ record.getQuestionId());
                if (record.isCorrect()) {
                    System.out.println("判定：正解");
                } else {
                    System.out.println("判定：不正解" );
                }
                System.out.println("得点："+ record.getScore());
                System.out.println("日時："+ record.getDate());
                System.out.println("----------------------");
            }
        }
        if (!found) {
            System.out.println("まだ解答履歴がありません。");
        }
    }
}