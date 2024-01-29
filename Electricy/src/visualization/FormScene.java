package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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

public class FormScene {
	private Button submit;
    private DatePicker datePicker;
    private TextField israeliLinesField;
	private TextField gazaPowerPlantField;
	private TextField egyptianLinesField;
	private TextField dailySupplyField;
	private TextField overallDemandField;
	private TextField powerCutsField;
	private TextField tempp;

	public FormScene(Stage stage, String strbtn) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50));
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		gridPane.setBackground(background);

        Label titleLabel = new Label("Record");
        Label dateLabel = new Label("Date:");
        Label israeliLinesLabel = new Label("Israeli Lines (MWs):");
        Label gazaPowerPlantLabel = new Label("Gaza Power Plant (MWs):");
        Label egyptianLinesLabel = new Label("Egyptian Lines (MWs):");
        Label dailySupplyLabel = new Label("Total Daily Supply (MWs):");
        Label overallDemandLabel = new Label("Overall Demand (MWs):");
        Label powerCutsLabel = new Label("Power Cuts (hours/day - 400mg):");
        Label temp = new Label("Temp:");

	     titleLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
	     dateLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
	     israeliLinesLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
	     gazaPowerPlantLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
	     egyptianLinesLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
	     dailySupplyLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
	     overallDemandLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
	     powerCutsLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));
	     temp.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 14));

	     datePicker = new DatePicker();
        israeliLinesField = new TextField();
        gazaPowerPlantField = new TextField();
        egyptianLinesField = new TextField();
        dailySupplyField = new TextField();
        overallDemandField = new TextField();
        powerCutsField = new TextField();
        tempp = new TextField();
        
        int textFieldWidth = 40;
        datePicker.setPrefHeight(textFieldWidth);
        israeliLinesField.setPrefHeight(textFieldWidth);
        gazaPowerPlantField.setPrefHeight(textFieldWidth);
        egyptianLinesField.setPrefHeight(textFieldWidth);
        dailySupplyField.setPrefHeight(textFieldWidth);
        overallDemandField.setPrefHeight(textFieldWidth);
        powerCutsField.setPrefHeight(textFieldWidth);
        tempp.setPrefHeight(textFieldWidth);
        submit = createStyledButton(strbtn);
        
        gridPane.add(titleLabel,  0, 0);
        gridPane.add(dateLabel, 0, 1);
        gridPane.add(datePicker, 1, 1);
        gridPane.add(israeliLinesLabel, 0, 2);
        gridPane.add(israeliLinesField, 1, 2);
        gridPane.add(gazaPowerPlantLabel, 0, 3);
        gridPane.add(gazaPowerPlantField, 1, 3);
        gridPane.add(egyptianLinesLabel, 0, 4);
        gridPane.add(egyptianLinesField, 1, 4);
        gridPane.add(dailySupplyLabel, 0, 5);
        gridPane.add(dailySupplyField, 1, 5);
        gridPane.add(overallDemandLabel, 0, 6);
        gridPane.add(overallDemandField, 1, 6);
        gridPane.add(powerCutsLabel, 0, 7);
        gridPane.add(powerCutsField, 1, 7);
        gridPane.add(temp, 0, 8);
        gridPane.add(tempp, 1, 8);
        gridPane.add(submit, 0, 9, 2, 1);
        
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
	 * getters & Setters
	 */
	public Button getSubmit() {
		return submit;
	}

	public void setSubmit(Button submit) {
		this.submit = submit;
	}

	public DatePicker getDateField() {
		return datePicker;
	}

	public void setDateField(DatePicker dateField) {
		this.datePicker = dateField;
	}

	public TextField getIsraeliLinesField() {
		return israeliLinesField;
	}

	public void setIsraeliLinesField(TextField israeliLinesField) {
		this.israeliLinesField = israeliLinesField;
	}

	public TextField getGazaPowerPlantField() {
		return gazaPowerPlantField;
	}

	public void setGazaPowerPlantField(TextField gazaPowerPlantField) {
		this.gazaPowerPlantField = gazaPowerPlantField;
	}

	public TextField getEgyptianLinesField() {
		return egyptianLinesField;
	}

	public void setEgyptianLinesField(TextField egyptianLinesField) {
		this.egyptianLinesField = egyptianLinesField;
	}

	public TextField getDailySupplyField() {
		return dailySupplyField;
	}

	public void setDailySupplyField(TextField dailySupplyField) {
		this.dailySupplyField = dailySupplyField;
	}

	public TextField getOverallDemandField() {
		return overallDemandField;
	}

	public void setOverallDemandField(TextField overallDemandField) {
		this.overallDemandField = overallDemandField;
	}

	public TextField getPowerCutsField() {
		return powerCutsField;
	}

	public void setPowerCutsField(TextField powerCutsField) {
		this.powerCutsField = powerCutsField;
	}

	public DatePicker getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(DatePicker datePicker) {
		this.datePicker = datePicker;
	}

	public TextField getTempp() {
		return tempp;
	}

	public void setTempp(TextField tempp) {
		this.tempp = tempp;
	}	
}