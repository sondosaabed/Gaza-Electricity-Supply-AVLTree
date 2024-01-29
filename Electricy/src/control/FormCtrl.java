package control;

import java.time.LocalDate;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AVLTree;
import model.DailyElectrictyRecord;
import model.Data;
import model.Node;
import visualization.FormScene;

public class FormCtrl {
	private FormScene scene;
	private Button submit;
	private DatePicker dateField;
	private TextField israeliLinesField;
	private TextField gazaPowerPlantField;
	private TextField egyptianLinesField;
	private TextField dailySupplyField;
	private TextField overallDemandField;
	private TextField powerCutsField;
	private TextField temp;

	public FormCtrl(Stage stage, String operation, DailyElectrictyRecord record) {
		initialize(stage, operation, record);
	}

	private void initialize(Stage stage, String operation, DailyElectrictyRecord record) {
		setScene(new FormScene(stage,operation));
		
		setSubmit(getScene().getSubmit());
		getSubmit().setText(operation);
		
		setDateField(getScene().getDatePicker());
		setIsraeliLinesField(getScene().getIsraeliLinesField());
		setGazaPowerPlantField(getScene().getGazaPowerPlantField());
		setEgyptianLinesField(getScene().getEgyptianLinesField());
		setDailySupplyField(getScene().getDailySupplyField());
		setOverallDemandField(getScene().getOverallDemandField());
		setPowerCutsField(getScene().getPowerCutsField());
		setTemp(getScene().getTempp());
		
		if(record != null) {
			//setting the old values to be updated
			getDateField().setValue(LocalDate.parse(record.getDate()));
			getIsraeliLinesField().setText(record.getIsraeli_Lines_MWs() +"");
			getGazaPowerPlantField().setText(record.getGaza_Power_Plant_MWs() +"");
			getEgyptianLinesField().setText(record.getEgyptian_Lines_MWs()+"");
			getDailySupplyField().setText(record.getTotal_daily_Supply_available_in_MWs()+"");
			getOverallDemandField().setText(record.getOverall_demand_in_MWs()+"");
			getPowerCutsField().setText(record.getPower_Cuts_hours_day_400mg()+"");
			getTemp().setText(record.getTemp()+"");
		}
		
		handle_submit(getSubmit(), operation, record);
	}

	private void handle_submit(Button submit, String operation, DailyElectrictyRecord record ) {
		submit.setOnAction(e->{
			if (getDateField().getValue() == null || getIsraeliLinesField().getText().isEmpty()
                    || getGazaPowerPlantField().getText().isEmpty() || getEgyptianLinesField().getText().isEmpty()
                    || getDailySupplyField().getText().isEmpty() || getOverallDemandField().getText().isEmpty()
                    || getPowerCutsField().getText().isEmpty()
                    || getTemp().getText().isEmpty()) {
                AlertBoxCtrl a = new AlertBoxCtrl("Please fill in all the required fields", "Empty field", true);
                a.show();
            } else{
	            AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> data = Data.getData();

            	
                LocalDate date = getDateField().getValue();
                double israeliLines = Double.parseDouble(getIsraeliLinesField().getText());
                double gazaPowerPlant = Double.parseDouble(getGazaPowerPlantField().getText());
                int egyptianLines = Integer.parseInt(getEgyptianLinesField().getText());
                double dailySupply = Double.parseDouble(getDailySupplyField().getText());
                double overallDemand = Double.parseDouble(getOverallDemandField().getText());
                double powerCuts = Double.parseDouble(getPowerCutsField().getText());
                double temp = Double.parseDouble(getTemp().getText());

                DailyElectrictyRecord newRecord = new DailyElectrictyRecord(date.toString(), israeliLines, gazaPowerPlant,
                        egyptianLines, dailySupply, overallDemand, powerCuts, temp);
                
                String msg ="";
            	if(operation.equals("Insert")) {             
	                msg = "Record successfully inserted";

		            String dateString =newRecord.getDate();
		            int year = Integer.parseInt(dateString.split("-")[0]);
		            int month = Integer.parseInt(dateString.split("-")[1]);
		            int day = Integer.parseInt(dateString.split("-")[2]);

		            Node<AVLTree<AVLTree<DailyElectrictyRecord>>> monthsNode = data.search(year);

		            if (monthsNode == null) {
		                // If the year node doesn't exist, create it
		                AVLTree<DailyElectrictyRecord> daysTree = new AVLTree<>();
		                daysTree.insert(day, record);

		                AVLTree<AVLTree<DailyElectrictyRecord>> monthsTree = new AVLTree<>();
		                monthsTree.insert(month, daysTree);

		                data.insert(year, monthsTree);
		            } else {
		                // If the year node already exists, update its months and days
		                AVLTree<AVLTree<DailyElectrictyRecord>> monthsTree = monthsNode.getData();
		                Node<AVLTree<DailyElectrictyRecord>> daysNode = monthsTree.search(month);

		                if (daysNode == null) {
		                    // If the month node doesn't exist, create it
		                    AVLTree<DailyElectrictyRecord> daysTree = new AVLTree<>();
		                    daysTree.insert(day, record);
		                    monthsTree.insert(month, daysTree);
		                } else {
		                    // If the month node exists, add the day
		                    daysNode.getData().insert(day, record);
		                }
		                data.insert(year, monthsTree);
		            }
		            
		            Data.setData(data);
            	}else {
					msg ="Record successfully updated";
					String dateString =newRecord.getDate();
		            int day = Integer.parseInt(dateString.split("-")[2]);
		            int year = Integer.parseInt(dateString.split("-")[0]);
		            int month = Integer.parseInt(dateString.split("-")[1]);

		            Node<AVLTree<AVLTree<DailyElectrictyRecord>>> monthsNode = data.search(year);
	                AVLTree<AVLTree<DailyElectrictyRecord>> monthsTree = monthsNode.getData();
	                Node<AVLTree<DailyElectrictyRecord>> daysNode = monthsTree.search(month);
                    
	                daysNode.getData().update(day, record);
                    monthsTree.update(month, daysNode.getData());
                    data.update(year, monthsTree);
		            Data.setData(data);
				}
	        	AlertBoxCtrl a = new AlertBoxCtrl(msg, operation, false);
	            a.show();
            }
		});
	}
	
	/*
	 * Getters & setters
	 */
	public DatePicker getDateField() {
		return dateField;
	}

	public void setDateField(DatePicker dateField) {
		this.dateField = dateField;
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
	public FormScene getScene() {
		return scene;
	}

	public void setScene(FormScene scene) {
		this.scene = scene;
	}

	public Button getSubmit() {
		return submit;
	}

	public void setSubmit(Button submit) {
		this.submit = submit;
	}

	public TextField getTemp() {
		return temp;
	}

	public void setTemp(TextField temp) {
		this.temp = temp;
	}
}