package cyberdefender;

public class Question {

    // 問題ID
    private int id;

    // 問題文
    private String text;

    // 選択肢
    private String[] choices;

    // 正解番号
    private int answer;

    // 解説
    private String explanation;

    // 分野
    private String category;

    // 難易度
    private String difficulty;

    // 問題を作成
    public Question(
            int id,
            String text,
            String[] choices,
            int answer,
            String explanation,
            String category,
            String difficulty) {

        this.id = id;
        this.text = text;
        this.choices = choices;
        this.answer = answer;
        this.explanation = explanation;
        this.category = category;
        this.difficulty = difficulty;
    }

    // IDを取得
    public int getId() {
        return id;
    }

    // 問題文を取得
    public String getText() {
        return text;
    }

    // 選択肢を取得
    public String[] getChoices() {
        return choices;
    }

    // 正解番号を取得
    public int getAnswer() {
        return answer;
    }

    // 解説を取得
    public String getExplanation() {
        return explanation;
    }

    // 分野を取得
    public String getCategory() {
        return category;
    }

    // 難易度を取得
    public String getDifficulty() {
        return difficulty;
    }

    // 問題文を変更
    public void setText(String text) {
        this.text = text;
    }

    // 選択肢を変更
    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    // 正解を変更
    public void setAnswer(int answer) {
        this.answer = answer;
    }

    // 解説を変更
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    // 分野を変更
    public void setCategory(String category) {
        this.category = category;
    }

    // 難易度を変更
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    // 問題を表示
    public void showQuestion() {

        System.out.println();
        System.out.println("問題ID：" + id);
        System.out.println("問題：" + text);

        // 選択肢を表示
        for (int i = 0; i < choices.length; i++) {

            System.out.println(
                    (i + 1) + ". " + choices[i]
            );
        }

        System.out.println("分野：" + category);
        System.out.println("難易度：" + difficulty);
    }
}