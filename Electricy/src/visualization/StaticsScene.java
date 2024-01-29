package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StaticsScene {
	private Button minInDayButton;
	private Button maxInMonthButton;
	private Button avgInYearButton;
	private Button sumOfAllButton;
	
	public StaticsScene(Stage stage) {
		initialize(stage);
	}
	
	private void initialize(Stage stage) {
		VBox root = new VBox(50);
        root.setPadding(new Insets(50));

		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		root.setBackground(background);
		
        Text title = new Text("Electricity Statistics Options");
        title.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
        HBox optionsBoxAbove = new HBox(5);
        HBox optionsBoxBelow = new HBox(5);
        GridPane.setHalignment(title, HPos.CENTER);

		sumOfAllButton = createStyledButton("Sum of All");
	    avgInYearButton = createStyledButton("Average In Year");
	    maxInMonthButton = createStyledButton("Maximum In a Month");
	    minInDayButton = createStyledButton("Minimum In a Day");


        optionsBoxAbove.getChildren().addAll(sumOfAllButton, avgInYearButton);
        optionsBoxBelow.getChildren().addAll(maxInMonthButton, minInDayButton);
        root.getChildren().addAll(title, optionsBoxAbove, optionsBoxBelow);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
	}
	
    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(250, 70);
        button.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 5; " +
                "-fx-background-radius: 7; -fx-background-color: #DDEDE5;");
        button.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
        GridPane.setHalignment(button, HPos.CENTER);
        return button;
    }
    
	/*
	 * Getters & Setters
	 */
	public Button getMinInDayButton() {
		return minInDayButton;
	}

	public void setMinInDayButton(Button minInDayButton) {
		this.minInDayButton = minInDayButton;
	}

	public Button getMaxInMonthButton() {
		return maxInMonthButton;
	}

	public void setMaxInMonthButton(Button maxInMonthButton) {
		this.maxInMonthButton = maxInMonthButton;
	}

	public Button getAvgInYearButton() {
		return avgInYearButton;
	}

	public void setAvgInYearButton(Button avgInYearButton) {
		this.avgInYearButton = avgInYearButton;
	}

	public Button getSumOfAllButton() {
		return sumOfAllButton;
	}

	public void setSumOfAllButton(Button sumOfAllButton) {
		this.sumOfAllButton = sumOfAllButton;
	}
}