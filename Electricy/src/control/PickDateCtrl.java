package control;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import model.AVLTree;
import model.DailyElectrictyRecord;
import model.Data;
import model.Node;
import model.PrintTree;
import visualization.PickDatePrintScene;

public class PickDateCtrl {
	private PickDatePrintScene scene;
	private Button pick;
	private DatePicker date;

	public PickDateCtrl(Stage stage, String btnStr) {
		initialize(stage, btnStr);
	}
	
	private void initialize(Stage stage, String btnStr) {
		setScene(new PickDatePrintScene(stage, btnStr));
		setPick(getScene().getPick());
		setDate(getScene().getDate());
		
		handle_pick(getPick(), btnStr);
	}

	private void handle_pick(Button pick, String btnStr) {
		pick.setOnAction(e->{
			if(getDate().getValue() == null) {
				AlertBoxCtrl a=new AlertBoxCtrl("No date was picked","pick date null", true);
				a.show();
			}else {
				String date = getDate().getValue().toString();

				int year = Integer.parseInt(date.split("-")[0]);
				int month = Integer.parseInt(date.split("-")[1]);
				int day = Integer.parseInt(date.split("-")[2]);
				
				Node<AVLTree<AVLTree<DailyElectrictyRecord>>> yearNode = Data.getData().search(year);

				if (yearNode != null && yearNode.getData() != null
					&&  yearNode.getData().search(month) != null &&  yearNode.getData().search(month).getData() != null
					&&	yearNode.getData().search(month).getData().search(day) != null) {
		            
					if (btnStr.equals("Delete")) {
						/*
						 * The delete logic (must trace down till reaching the specific date
						 * records.delete(day)
						 */
						yearNode.getData().search(month).getData().delete(day);
		                AlertBoxCtrl a = new AlertBoxCtrl("Record was successfully deleted", "delete", false);
		                a.show();
		            } else if (btnStr.equals("Print Trees")) {
		            	// uses the printree class
		                StringBuilder trees = PrintTree.printTreeLevels(Data.getData(), date);;
		                new PrintCtrl(new Stage(), trees.toString());
		            } else if (btnStr.equals("Print Heights")) {
		            	// uses the printree class
		                StringBuilder heights = PrintTree.printTreeHeights(Data.getData(), date);;
		                new PrintCtrl(new Stage(), heights.toString());
		            } else if (btnStr.equals("Update")) {
		            	// redirect to the update form with the record old data
		                new FormCtrl(new Stage(), "Update", yearNode.getData().search(month).getData().search(day).getData());
		            } else if (btnStr.equals("Search")) {
		            	// shows the found record
		                String findRecord = yearNode.getData().search(month).getData().search(day).getData().toString();
		                if(findRecord != null)
		                	new PrintCtrl(new Stage(), findRecord);
		                else {
		                	AlertBoxCtrl a = new AlertBoxCtrl("Record was Not Found", "not found", false);
			                a.show();
		                }
		            }
		        } else {
		            AlertBoxCtrl a = new AlertBoxCtrl("This Date isn't in the records", "date not found", true);
		            a.show();
		        }
		    }
		});
	}

	/*
	 * Getters & setters
	 */
	public PickDatePrintScene getScene() {
		return scene;
	}

	public void setScene(PickDatePrintScene scene) {
		this.scene = scene;
	}

	public Button getPick() {
		return pick;
	}

	public void setPick(Button pick) {
		this.pick = pick;
	}

	public DatePicker getDate() {
		return date;
	}

	public void setDate(DatePicker date) {
		this.date = date;
	}
}