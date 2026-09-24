package cyberdefender;

public class Question {
    private int id;
    private String text;
    private String[] choices;
    private int answer;
    private String explanation;
    private String category;
    private String difficulty;
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
    public int getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public String[] getChoices() {
        return choices;
    }
    public int getAnswer() {
        return answer;
    }
    public String getExplanation() {
        return explanation;
    }
    public String getCategory() {
        return category;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setChoices(String[] choices) {
        this.choices = choices;
    }
    public void setAnswer(int answer) {
        this.answer = answer;
    }
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public void showQuestion() {
        System.out.println();
        System.out.println("問題ID：" + id);
        System.out.println("問題：" + text);
        
        for (int i = 0; i < choices.length; i++) {
            System.out.println(
                    (i + 1) + ". " + choices[i]
            );
        }
        System.out.println("分野：" + category);
        System.out.println("難易度：" + difficulty);
    }
}