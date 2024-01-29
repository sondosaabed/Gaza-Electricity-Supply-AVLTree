package control;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import visualization.AnswerScene;

public class AnswerCtrl {
	private AnswerScene scene;
	private Button cancel;
	private TextArea answer;
	
	public AnswerCtrl(Stage stage, String answer){
		initialze(stage, answer);
	}
	
	private void initialze(Stage stage, String answer) {
		setScene(new AnswerScene(stage));
		setCancel(getScene().getCancel());
		setAnswer(getScene().getAnswer());
		getAnswer().setText(answer);
		handle_cancel(getCancel(), stage);
	}
	
	private void handle_cancel(Button cancel2, Stage stage) {
		cancel2.setOnAction(e->{
			stage.close();
		});
	}
	
	/*
	 * GEtters & Setters
	 */
	public AnswerScene getScene() {
		return scene;
	}
	public void setScene(AnswerScene scene) {
		this.scene = scene;
	}
	public Button getCancel() {
		return cancel;
	}
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
	public TextArea getAnswer() {
		return answer;
	}
	public void setAnswer(TextArea answer) {
		this.answer = answer;
	}
}