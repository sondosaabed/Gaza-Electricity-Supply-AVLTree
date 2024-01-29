package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AnswerScene {
	private Button cancel;
	private TextArea answer;
	
	public AnswerScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
        GridPane pane;

    	pane = new GridPane();
    	pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(50));
		pane.setHgap(60);
		pane.setVgap(20);
		
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		pane.setBackground(background);
		
		answer = new TextArea();
		answer.setEditable(false);
		answer.setPrefSize(500, 300);
		answer.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));

		
		cancel = new Button("Cancel");
		cancel.setPrefSize(100, 30);
		cancel.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 5;-fx-background-color:#DDEDE5;");
		cancel.setTextFill(Color.valueOf("#000000"));
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
        GridPane.setHalignment(cancel, HPos.CENTER);

		pane.add(answer,0,0); 
		pane.add(cancel,0,1); 
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Answer");
		stage.getIcons().add(new Image("resources/logo.png"));
		stage.centerOnScreen();
		stage.show();
	}
	
	/*
	 * Getters and Setters
	 */
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