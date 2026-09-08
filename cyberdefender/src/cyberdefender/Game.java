package cyberdefender;

import java.util.List;

public class Game {

    // 入力処理
    private InputManager input;

    // 問題管理
    private QuestionManager questionManager;

    // 解答履歴
    private List<AnswerRecord> answerRecords;

    // ゲームを作成
    public Game(
            InputManager input,
            QuestionManager questionManager,
            List<AnswerRecord> answerRecords) {

        this.input = input;
        this.questionManager = questionManager;
        this.answerRecords = answerRecords;
    }

    // ゲーム開始
    public void start(Student student) {

        System.out.println();
        System.out.println("==============================");
        System.out.println("       CYBERDEFENDER");
        System.out.println("==============================");

        // 問題がない場合
        if (questionManager.getQuestions().isEmpty()) {

            System.out.println(
                    "問題がありません。"
            );

            return;
        }

        // 得点
        int score = 0;

        // 問題番号
        int number = 1;

        // 問題を順番に出す
        for (Question question :
                questionManager.getQuestions()) {

            System.out.println();
            System.out.println(
                    "第" + number + "問"
            );

            // 問題を表示
            question.showQuestion();

            // 回答
            int answer =
                    input.readInt(
                            "回答：",
                            1,
                            4
                    );

            // 正解判定
            boolean correct =
                    answer == question.getAnswer();

            // 1問の得点
            int point = 0;

            // 正解
            if (correct) {

                System.out.println("★ 正解！");
                point = 10;
                score += 10;
            }

            // 不正解
            else {

                System.out.println("✕ 不正解...");
                System.out.println(
                        "正解は"
                        + question.getAnswer()
                        + "番です。"
                );
            }

            // 解説
            System.out.println();
            System.out.println("【解説】");
            System.out.println(
                    question.getExplanation()
            );

            // 解答履歴
            AnswerRecord record =
                    new AnswerRecord(
                            student.getId(),
                            question.getId(),
                            answer,
                            correct,
                            point
                    );

            // 履歴を保存
            answerRecords.add(record);

            number++;
        }

        // 最終結果
        System.out.println();
        System.out.println("==============================");
        System.out.println("ゲーム終了！");
        System.out.println(
                "あなたの得点：" + score + "点"
        );
        System.out.println("==============================");
    }

    // 解答履歴を表示
    public void showHistory(int studentId) {

        System.out.println();
        System.out.println("===== 解答履歴 =====");

        boolean found = false;

        // 履歴を確認
        for (AnswerRecord record :
                answerRecords) {

            if (record.getStudentId() == studentId) {

                found = true;

                System.out.println(
                        "問題ID："
                        + record.getQuestionId()
                );

                // 正解か確認
                if (record.isCorrect()) {

                    System.out.println(
                            "判定：正解"
                    );

                } else {

                    System.out.println(
                            "判定：不正解"
                    );
                }

                System.out.println(
                        "得点："
                        + record.getScore()
                );

                System.out.println(
                        "日時："
                        + record.getDate()
                );

                System.out.println(
                        "----------------------"
                );
            }
        }

        // 履歴がない場合
        if (!found) {

            System.out.println(
                    "まだ解答履歴がありません。"
            );
        }
    }
}