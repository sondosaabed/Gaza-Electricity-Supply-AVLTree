package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

public class StaticQuestionScene {
	private Label question;
	private ComboBox<String> values;
	private TextField year;
	private Button submit;
	
	public StaticQuestionScene(Stage stage,String question, String type){
		initialize(stage, question, type);
	}
	
	private void initialize(Stage stage, String question2, String type) {
		GridPane pane = new GridPane();
    	pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 150,100,150));
		pane.setHgap(60);
		pane.setVgap(20);
		
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		pane.setBackground(background);
		
		setQuestion(new Label(question2));
		getQuestion().setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));

		setSubmit(new Button("Calculate"));		
		getSubmit().setPrefSize(170, 30);
		getSubmit().setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 5;-fx-background-color:#DDEDE5;");
		getSubmit().setTextFill(Color.valueOf("#000000"));
		getSubmit().setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
        GridPane.setHalignment(getSubmit(), HPos.CENTER);

		setValues(new ComboBox<String>());
		getValues().setPrefSize(170, 30);
		getValues().setStyle("-fx-font-size: 16;-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 5;-fx-background-color:#FFFFFF;");
        GridPane.setHalignment(getValues(), HPos.CENTER);

		setYear(new TextField());
		getYear().setPrefSize(10, 50);
		getYear().setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
        GridPane.setHalignment(getYear(), HPos.CENTER);
		
		if(type.equals("month")) {
			getValues().getItems().add("January");
			getValues().getItems().add("February");
			getValues().getItems().add("March");
			getValues().getItems().add("April");
			getValues().getItems().add("May");
			getValues().getItems().add("June");
			getValues().getItems().add("July");
			getValues().getItems().add("August");
			getValues().getItems().add("September");
			getValues().getItems().add("October");
			getValues().getItems().add("November");		
			getValues().getItems().add("December");
			pane.add(getValues(),0,1); 
		}else if(type.equals("day")) {
			for (int i = 1; i <= 31; i++) {
			    getValues().getItems().add(String.valueOf(i));
			}
			pane.add(getValues(),0,1); 
		}else {
			pane.add(getYear(),0,1); 
		}
				
		pane.add(getQuestion(),0,0); 
		pane.add(getSubmit(),0,2); 
		
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.centerOnScreen();
		stage.getIcons().add(new Image("resources/logo.png"));
        stage.show();
	}

	/*
	 * Getters & Setters
	 */
	public Label getQuestion() {
		return question;
	}
	public void setQuestion(Label question) {
		this.question = question;
	}

	public Button getSubmit() {
		return submit;
	}

	public void setSubmit(Button submit) {
		this.submit = submit;
	}

	public ComboBox<String> getValues() {
		return values;
	}

	public void setValues(ComboBox<String> values) {
		this.values = values;
	}

	public TextField getYear() {
		return year;
	}

	public void setYear(TextField year) {
		this.year = year;
	}
}