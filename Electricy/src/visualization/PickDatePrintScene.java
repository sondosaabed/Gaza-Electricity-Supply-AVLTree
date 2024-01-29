package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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

public class PickDatePrintScene {
	private Button pick;
	private DatePicker date;
	
	public PickDatePrintScene(Stage stage, String btnStr) {
		initialize(stage, btnStr);
	}

	private void initialize(Stage stage, String btnStr) {
		GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(100));
        gridPane.setVgap(60);
        gridPane.setHgap(60);
		
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		gridPane.setBackground(background);
		
        Label titleLabel = new Label("Pick a date");
        Label dateLabel = new Label("Date:");
        titleLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
	    dateLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
	     
	    pick = createStyledButton(btnStr);
		date = new DatePicker();
        date.setPrefHeight(40);

		gridPane.add(titleLabel,  0, 0 , 2, 1);
        gridPane.add(dateLabel, 0, 1 , 2, 1);
        gridPane.add(date, 1, 1);
        gridPane.add(pick, 0, 2, 2, 1);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.centerOnScreen();
		stage.getIcons().add(new Image("resources/logo.png"));
        stage.show();
	}

	private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(170, 40);
        button.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 5; " +
                "-fx-background-radius: 7; -fx-background-color: #DDEDE5;");
        button.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
        GridPane.setHalignment(button, HPos.CENTER);
        return button;
    }
	/*
	 * Getters & setters
	 */
	public DatePicker getDate() {
		return date;
	}

	public void setDate(DatePicker date) {
		this.date = date;
	}

	public Button getPick() {
		return pick;
	}

	public void setPick(Button pick) {
		this.pick = pick;
	}
}
