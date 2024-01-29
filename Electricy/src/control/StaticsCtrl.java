package control;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Data;
import model.Statistics;
import visualization.StaticsScene;

public class StaticsCtrl {
	private StaticsScene scene;
	private Button minInDayButton;
	private Button maxInMonthButton;
	private Button avgInYearButton;
	private Button sumOfAllButton;
	
	public StaticsCtrl(Stage stage) {
		initialize(stage);
	}
	
	private void initialize(Stage stage) {
		setScene(new StaticsScene(stage));
		setMaxInMonthButton(getScene().getMaxInMonthButton());
		setMinInDayButton(getScene().getMinInDayButton());
		setAvgInYearButton(getScene().getAvgInYearButton());
		setSumOfAllButton(getScene().getSumOfAllButton());
		
		handle_max(getMaxInMonthButton());
		handle_min(getMinInDayButton());
		handle_avg(getAvgInYearButton());
		handle_sum(getSumOfAllButton());
	}
	
	/*
	 * Buttons Handlers
	 */
	private void handle_sum(Button sumOfAllButton2) {
		sumOfAllButton2.setOnAction(e->{
			new AnswerCtrl(new Stage(), Statistics.totalStatistics(Data.getData()).toString());
		});
	}

	private void handle_avg(Button avgInYearButton2) {
		avgInYearButton2.setOnAction(e->{
			new StaticQuestionCtrl(new Stage(),"avg");
		});
	}

	private void handle_min(Button minInDayButton2) {
		minInDayButton2.setOnAction(e->{
			new StaticQuestionCtrl(new Stage(),"min");
		});
	}

	private void handle_max(Button maxInMonthButton2) {
		maxInMonthButton2.setOnAction(e->{
			new StaticQuestionCtrl(new Stage(),"max");
		});		
	}

	/*
	 * Getters & Setters
	 */
	public StaticsScene getScene() {
		return scene;
	}

	public void setScene(StaticsScene scene) {
		this.scene = scene;
	}

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