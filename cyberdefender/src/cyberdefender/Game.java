package cyberdefender;
import java.util.List;
public class Game{
	private InputManager inputManager;
	private List<Question> questions;
	private List<AnswerRecord> records;
	
	public Game(
            InputManager inputManager,
            QuestionManager questionManager,
            List<AnswerRecord> records) {

        this.inputManager = inputManager;
        this.questions = questionManager.getQuestions();
        this.records = records;
    }
	public void play(Student student) {
		int totalScore = 0;
		int questionNumber = 1;
		
		System.out.println();
		System.out.println("=====学習開始=====");
		
		for(Question question : questions) {
			System.out.println();
			System.out.println("第" + questionNumber + "問");
			int score = askQuestion(student,question);
			totalScore += score;
			questionNumber++;
		}
		System.out.println();
		System.out.println("=====学習終了=====");
		System.out.println("合計点" + totalScore);
	}
	private int askQuestion(Student student, Question question) {
		question.showQuestion();
		int selectedAnswer = inputManager.readInt("答えを選択してください:", 1, 4);
		boolean correct = selectedAnswer == question.getAnswer();
		int score = 0;
		if(correct) {
			System.out.println("正解です！");
			score = 10;
		}else {
			System.out.println("不正解です。");
		}
		 System.out.println("解説：" + question.getExplanation());
	        saveRecord(
	                student.getId(),
	                question.getId(),
	                selectedAnswer,
	                correct,
	                score
	        );
	        return score;
	    }
	    private void saveRecord(
	            int studentId,
	            int questionId,
	            int selectedAnswer,
	            boolean correct,
	            int score) {

	        AnswerRecord record = new AnswerRecord(
	                studentId,
	                questionId,
	                selectedAnswer,
	                correct,
	                score
	        );
	        records.add(record);
	    }
	}