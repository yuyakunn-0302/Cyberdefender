package cyberdefender;
import java.time.LocalDateTime;
public class AnswerRecord {
    // 生徒ID
    private int studentId;
    // 問題ID
    private int questionId;
    // 選択した答え
    private int selectedAnswer;
    // 正解かどうか
    private boolean correct;
    // 得点
    private int score;
    // 解答日時
    private LocalDateTime date;
    // 解答履歴を作成
    public AnswerRecord(int studentId,int questionId,int selectedAnswer,boolean correct,int score) {
        this.studentId = studentId;
        this.questionId = questionId;
        this.selectedAnswer = selectedAnswer;
        this.correct = correct;
        this.score = score;
        this.date = LocalDateTime.now();
    }
    // 生徒IDを取得
    public int getStudentId() {
        return studentId;
    }
    // 問題IDを取得
    public int getQuestionId() {
        return questionId;
    }
    // 選択した答えを取得
    public int getSelectedAnswer() {
        return selectedAnswer;
    }
    // 正解か確認
    public boolean isCorrect() {
        return correct;
    }
    // 得点を取得
    public int getScore() {
        return score;
    }
    // 日時を取得
    public LocalDateTime getDate() {
        return date;
    }
}