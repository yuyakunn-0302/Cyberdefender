package cyberdefender;
import java.util.ArrayList;
import java.util.Comparator;
public class QuestionManager {
    // 問題を保存
    private ArrayList<Question> questions = new ArrayList<Question>();
    // 初期問題を登録
    public QuestionManager() {
        // 問題1
        questions.add(new Question(
                1,
                "銀行を名乗るメールが届きました。安全な対応はどれ？",
                new String[]{
                        "メールのリンクをすぐにクリックする",
                        "メールを友達に送る",
                        "公式サイトを自分で開いて確認する",
                        "メールに書かれた電話番号へすぐ電話する"
                },
                3,
                "メール内のリンクを直接クリックせず、公式サイトを自分で開いて確認することが安全です。",
                "フィッシング詐欺",
                "初級"
        ));

        // 問題2
        questions.add(new Question(
                2,
                "不審なメールの特徴として正しいものはどれ？",
                new String[]{
                        "「今すぐ対応してください」など急がせる",
                        "必ず自分の名前が書かれている",
                        "文章が短い",
                        "画像がない"
                },
                1,
                "「今すぐ」「緊急」などの言葉で利用者を焦らせ、リンクをクリックさせようとするメールには注意が必要です。",
                "不審なメール",
                "初級"
        ));

        // 問題3
        questions.add(new Question(
                3,
                "知らない人からSNSでURLが送られてきました。どうする？",
                new String[]{
                        "すぐに開く",
                        "友達にも送る",
                        "安全か確認せず保存する",
                        "開かずに送信者や内容を確認する"
                },
                4,
                "知らない人から送られてきたURLは、不用意に開かず、送信者や内容を確認しましょう。",
                "SNS",
                "初級"
        ));

        // 問題4
        questions.add(new Question(
                4,
                "パスワードの管理方法として正しいものはどれ？",
                new String[]{
                        "すべてのサービスで同じパスワードを使う",
                        "他人に教える",
                        "サービスごとに異なるパスワードを使う",
                        "SNSにパスワードを書く"
                },
                3,
                "同じパスワードを使い回すと、1つのサービスで情報が漏れた場合に他のサービスにも被害が広がる可能性があります。",
                "パスワード",
                "初級"
        ));

        // 問題5
        questions.add(new Question(
                5,
                "個人情報を守るためにSNSで注意することはどれ？",
                new String[]{
                        "住所を公開する",
                        "学校名を公開する",
                        "個人情報を必要以上に公開しない",
                        "知らない人からのメッセージに個人情報を送る"
                },
                3,
                "住所や学校名などの個人情報は、必要以上に公開しないことが大切です。",
                "個人情報",
                "初級"
        ));
    }

    // 問題を追加
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // 問題登録
    public void createQuestion(InputManager input) {

        // 新しいIDを決める
        int id = 1;

        for (Question question : questions) {
            if (question.getId() >= id) {
                id = question.getId() + 1;
            }
        }

        System.out.println();
        System.out.println("===== 問題登録 =====");

        // 問題文
        String text = input.readText("問題文：");

        // 選択肢
        String[] choices = new String[4];

        for (int i = 0; i < 4; i++) {
            choices[i] = input.readText("選択肢" + (i + 1) + "：");
        }

        // 正解
        int answer = input.readInt("正解番号（1～4）：", 1, 4);

        // 解説
        String explanation = input.readText("解説：");

        // 分野
        String category = input.readText("分野：");

        // 難易度
        String difficulty = input.readText("難易度：");

        // 問題を作成
        Question question = new Question(id,text,choices,answer,explanation,category,difficulty);

        // 問題を追加
        questions.add(question);
        System.out.println();
        System.out.println("問題を登録しました！");
        System.out.println("問題ID：" + id);
    }
    // 問題一覧
    public void showQuestions() {
        System.out.println();
        System.out.println("===== 問題一覧 =====");
        // 問題がない場合
        if (questions.isEmpty()) {
            System.out.println("問題がありません。");
            return;
        }
        // 問題を表示
        for (Question question : questions) {
            question.showQuestion();
            System.out.println("正解：" + question.getAnswer());
            System.out.println("解説：" + question.getExplanation());
            System.out.println("分野：" + question.getCategory());
            System.out.println("難易度：" + question.getDifficulty());
            System.out.println("------------------------------");
        }
    }
    // IDから問題を探す
    public Question findQuestion(int id) {
        for (Question question : questions) {
            if (question.getId() == id) {
                return question;
            }
        }
        return null;
    }
    // 問題を更新
    public void updateQuestion(InputManager input) {
        System.out.println();
        System.out.println("===== 問題更新 =====");
        // IDを入力
        int id = input.readInt(
                "更新する問題ID：",
                1,
                999999
        );
        // 問題を探す
        Question question = findQuestion(id);
        // 問題がない場合
        if (question == null) {
            System.out.println("問題が見つかりません。");
            return;
        }
        // 問題文
        String text = input.readText("新しい問題文：");
        // 選択肢
        String[] choices = new String[4];
        for (int i = 0; i < 4; i++) {
            choices[i] = input.readText(
                    "新しい選択肢" + (i + 1) + "："
            );
        }
        // 正解
        int answer = input.readInt("新しい正解番号（1～4）：",1,4);
        // 解説
        String explanation = input.readText("新しい解説：");
        // 分野
        String category = input.readText("新しい分野：");
        // 難易度
        String difficulty = input.readText("新しい難易度：");
        // データを更新
        question.setText(text);
        question.setChoices(choices);
        question.setAnswer(answer);
        question.setExplanation(explanation);
        question.setCategory(category);
        question.setDifficulty(difficulty);
        System.out.println("問題を更新しました！");
    }
    // 問題を削除
    public void deleteQuestion(InputManager input) {
        System.out.println();
        System.out.println("===== 問題削除 =====");
        // IDを入力
        int id = input.readInt("削除する問題ID：",1,999999);

        // 問題を探す
        Question question = findQuestion(id);

        // 問題がない場合
        if (question == null) {
            System.out.println("問題が見つかりません。");
            return;
        }

        // 削除確認
        int confirm = input.readInt("本当に削除しますか？ 1.はい 2.いいえ：",1,2);
        // 削除
        if (confirm == 1) {
            questions.remove(question);
            System.out.println("問題を削除しました。");
        } else {
            System.out.println("削除をキャンセルしました。");
        }
    }
    // 問題を検索
    public void searchQuestion(InputManager input) {
        System.out.println();
        System.out.println("===== 問題検索 =====");
        // キーワード
        String keyword = input.readText(
                "検索キーワード："
        ).toLowerCase();
        
        boolean found = false;
        // 問題を検索
        for (Question question : questions) {
            if (
                    question.getText().toLowerCase().contains(keyword)
                    || question.getCategory().toLowerCase().contains(keyword)
                    || question.getDifficulty().toLowerCase().contains(keyword)
            ) {

                question.showQuestion();
                found = true;
            }
        }
        // 見つからない場合
        if (!found) {
            System.out.println("問題が見つかりませんでした。");
        }
    }
    // 問題を並び替える
    public void sortQuestions(InputManager input) {
        System.out.println();
        System.out.println("===== 並び替え =====");
        System.out.println("1. ID順");
        System.out.println("2. 難易度順");
        System.out.println("3. 分野順");

        int choice = input.readInt("選択：",1,3);

        // ID順
        if (choice == 1) {

            questions.sort(Comparator.comparingInt(Question::getId));
        // 難易度順
        } else if (choice == 2) {
            questions.sort(Comparator.comparing(Question::getDifficulty));
        // 分野順
        } else if (choice == 3) {
            questions.sort(Comparator.comparing(Question::getCategory));
        }
        System.out.println("並び替えました。");
        // 結果を表示
        showQuestions();
    }
    // 問題一覧を取得
    public ArrayList<Question> getQuestions() {
        return questions;
    }
}