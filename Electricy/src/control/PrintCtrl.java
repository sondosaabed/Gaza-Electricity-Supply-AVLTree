package control;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import visualization.PrintScene;

public class PrintCtrl {
	private PrintScene scene;
	private Button cancel;
	private TextArea print;

	public PrintCtrl(Stage stage, String print) {
		setScene(new PrintScene(stage, print));
		setCancel(getScene().getCancel());
		setPrint(getScene().getPrint());
		getPrint().setText(print);
		handle_cancel(getCancel(), stage);
	}
	
	private void handle_cancel(Button cancel2, Stage stage) {
		cancel2.setOnAction(e->{
			stage.close();
		});
	}

	/*
	 * Getter & Setters
	 */
	public PrintScene getScene() {
		return scene;
	}

	public void setScene(PrintScene scene) {
		this.scene = scene;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public TextArea getPrint() {
		return print;
	}

	public void setPrint(TextArea print) {
		this.print = print;
	}
}