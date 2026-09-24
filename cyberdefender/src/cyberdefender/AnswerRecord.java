package cyberdefender;
import java.time.LocalDateTime;
public class AnswerRecord{
	private int studentId;
	private int questionId;
	private int selectedAnswer;
	private boolean correct;
	private int score;
	private LocalDateTime date;
	
	public AnswerRecord(int studentId, int questionId, int selectedAnswer, boolean correct, int score){
		this.studentId = studentId;
		this.questionId = questionId;
		this.selectedAnswer = selectedAnswer;
		this.correct = correct;
		this.score = score;
		this.date = LocalDateTime.now();
	}

	public int getStudentId() {
		return studentId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public int getSelectedAnswer() {
		return selectedAnswer;
	}

	public boolean isCorrect() {
		return correct;
	}

	public int getScore() {
		return score;
	}

	public LocalDateTime getDate() {
		return date;
	}
	
}