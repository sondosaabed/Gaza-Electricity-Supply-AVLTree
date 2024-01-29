package control;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Data;
import model.Statistics;
import visualization.StaticQuestionScene;

public class StaticQuestionCtrl {
	private StaticQuestionScene scene;
	private Label question;
	private ComboBox<String> values;
	private TextField year;
	private Button submit;
	
	public StaticQuestionCtrl(Stage stage, String staticval) {
		initialize(stage, staticval);
	}
	
	private void initialize(Stage stage, String staticval) {
		String quetsion ="";
		String type ="";

		if(staticval.equals("max")) {
			quetsion="Pick a month, to show it's max value";
			type= "month";
		}else if(staticval.equals("min")) {
			quetsion="Pick a day, to find the minimum electricty";
			type= "day";
		}else {
			//avg
			quetsion="Pick a year to get average electricty";
			type= "year";
		}
		setScene(new StaticQuestionScene(stage, quetsion, type));
		setQuestion(getScene().getQuestion());
		setSubmit(getScene().getSubmit());
		setValues(getScene().getValues());
		setYear(getScene().getYear());
		getQuestion().setText(quetsion);
		handle_submit(getSubmit(), staticval);
	}

	private void handle_submit(Button submit2, String staticval) {
		submit2.setOnAction(e->{
			String value="";
			if(staticval.equals("max") || staticval.equals("min")) {
				if(staticval.equals("max")) {
					String selectedMonth = getValues().getSelectionModel().getSelectedItem().toString();
					
					if(selectedMonth != null) {
						int monthValue =1;
	
						if ("January".equals(selectedMonth)) {
						    monthValue = 1;
						} else if ("February".equals(selectedMonth)) {
						    monthValue = 2;
						} else if ("March".equals(selectedMonth)) {
						    monthValue = 3;
						} else if ("April".equals(selectedMonth)) {
						    monthValue = 4;
						} else if ("May".equals(selectedMonth)) {
						    monthValue = 5;
						} else if ("June".equals(selectedMonth)) {
						    monthValue = 6;
						} else if ("July".equals(selectedMonth)) {
						    monthValue = 7;
						} else if ("August".equals(selectedMonth)) {
						    monthValue = 8;
						} else if ("September".equals(selectedMonth)) {
						    monthValue = 9;
						} else if ("October".equals(selectedMonth)) {
						    monthValue = 10;
						} else if ("November".equals(selectedMonth)) {
						    monthValue = 11;
						} else if ("December".equals(selectedMonth)) {
						    monthValue = 12;
						}
						value = String.valueOf(monthValue);
					}else {
						AlertBoxCtrl a = new AlertBoxCtrl("Enter required feild", "Empty feild", false);
						a.show();
					}
				}else {
					value = getValues().getSelectionModel().getSelectedItem().toString() ;
				}
			}else {
				value = getYear().getText().toString();
			}
			
			String answer ="";
			if(staticval.equals("max")) {
				answer="The maximum Overal Demand in "+value+ " is   ==> " + Statistics.maximumOverallDemand(Data.getData(), value);
			}else if(staticval.equals("min")) {
				answer="The min Total Daily Supply in "+value+ " is   ==> " +Statistics.minimumTotalDailySupply(Data.getData(), value);
			}else {
				answer="The average Power Cuts Hours per Day in "+value+ " is    ==> " +Statistics.averagePowerCutsHoursDay(Data.getData(), value);
			}
			new AnswerCtrl(new Stage(), answer);
		});
	}
	/*
	 * Getters & Setters
	 */
	public StaticQuestionScene getScene() {
		return scene;
	}
	public void setScene(StaticQuestionScene scene) {
		this.scene = scene;
	}
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