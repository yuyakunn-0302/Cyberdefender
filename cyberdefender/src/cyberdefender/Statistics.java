package cyberdefender;
import java.util.List;
public class Statistics {
    public void showStatistics(List<AnswerRecord> records) {

        System.out.println();
        System.out.println("===== 学習データ =====");

        if (records.isEmpty()) {
            System.out.println("まだデータがありません。");

            return;
        }
        int totalScore = 0;
        int correctCount = 0;
        for (AnswerRecord record : records) {
            totalScore += record.getScore();
            if (record.isCorrect()) {
                correctCount++;
            }
        }
        double average =(double) totalScore / records.size();
        double correctRate =(double) correctCount / records.size()* 100;

        System.out.println("回答数：" + records.size());
        System.out.printf("平均点：%.1f点%n",average);
        System.out.printf("正解率：%.1f%%%n",correctRate);
    }
    
    public void showStudentStatistics(List<AnswerRecord> records,int studentId) {
        System.out.println();
        System.out.println("===== 自分の成績 =====");
        int count = 0;
        int correct = 0;
        int score = 0;
        for (AnswerRecord record : records) {
            if (record.getStudentId() == studentId) {
                count++;
                score += record.getScore();
                if (record.isCorrect()) {
                    correct++;
                }
            }
        }
        if (count == 0) {
            System.out.println("まだ問題を解いていません。");
            return;
        }
        double rate =(double) correct/ count* 100;
        double average =(double) score/ count;

        System.out.println("回答数：" + count);
        System.out.println("正解数：" + correct);
        System.out.printf("正解率：%.1f%%%n",rate);
        System.out.printf("平均得点：%.1f点%n",average);
    }
}