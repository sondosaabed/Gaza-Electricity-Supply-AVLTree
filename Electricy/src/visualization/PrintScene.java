package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
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

public class PrintScene {
	private Button cancel;
	private TextArea print;
	
	public PrintScene(Stage stage, String print) {
		initialize(stage, print);
	}
	
	private void initialize(Stage stage, String print) {
		GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50));
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		gridPane.setBackground(background);
		
		setPrint(new TextArea());
		getPrint().setText(print);
		getPrint().setEditable(false);
		getPrint().setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
		getPrint().setPrefSize(600, 600);
		setCancel(createStyledButton("Cancel"));
		gridPane.add(getPrint(),0,0); 
		gridPane.add(getCancel(),0,1); 
		
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.centerOnScreen();
		stage.getIcons().add(new Image("resources/logo.png"));
        stage.show();
	}
    
	private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(170, 50);
        button.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 5; " +
                "-fx-background-radius: 7; -fx-background-color: #DDEDE5;");
        button.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
        GridPane.setHalignment(button, HPos.CENTER);
        return button;
    }
	/*
	 * Getters & Setters
	 */
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