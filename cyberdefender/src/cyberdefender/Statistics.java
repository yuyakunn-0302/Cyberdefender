package cyberdefender;
import java.util.List;
public class Statistics {
    // 全体の学習データを表示
    public void showStatistics(List<AnswerRecord> records) {

        System.out.println();
        System.out.println("===== 学習データ =====");
        // データがない場合
        if (records.isEmpty()) {
            System.out.println("まだデータがありません。");

            return;
        }
        // 合計点
        int totalScore = 0;
        // 正解数
        int correctCount = 0;
        // データを計算
        for (AnswerRecord record : records) {
            totalScore += record.getScore();
            if (record.isCorrect()) {
                correctCount++;
            }
        }
        // 平均点
        double average =(double) totalScore / records.size();
        // 正解率
        double correctRate =(double) correctCount / records.size()* 100;

        System.out.println("回答数：" + records.size());

        System.out.printf("平均点：%.1f点%n",average);

        System.out.printf("正解率：%.1f%%%n",correctRate);
    }
    // 生徒個人の成績を表示
    public void showStudentStatistics(List<AnswerRecord> records,int studentId) {
        System.out.println();
        System.out.println("===== 自分の成績 =====");
        // 回答数
        int count = 0;
        // 正解数
        int correct = 0;
        // 合計点
        int score = 0;
        // 生徒のデータを計算
        for (AnswerRecord record : records) {
            if (record.getStudentId() == studentId) {
                count++;
                score += record.getScore();
                if (record.isCorrect()) {
                    correct++;
                }
            }
        }
        // データがない場合
        if (count == 0) {
            System.out.println("まだ問題を解いていません。");
            return;
        }
        // 正解率
        double rate =(double) correct/ count* 100;
        // 平均点
        double average =(double) score/ count;

        System.out.println("回答数：" + count);

        System.out.println("正解数：" + correct);

        System.out.printf("正解率：%.1f%%%n",rate);

        System.out.printf("平均得点：%.1f点%n",average);
    }
}