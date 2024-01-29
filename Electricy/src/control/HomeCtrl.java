package control;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import visualization.HomeScene;

/**
 * I have created this class to control the main scene
 */
public class HomeCtrl {
	//Feilds
	private Button managemnet;
	private Button statics;
	private Button save;
	private HomeScene scene;
	/*
	 * Constructot
	 */
	public HomeCtrl(Stage stage) {
		initialize(stage);
	}
	/*
	 * Initializer
	 */
	private void initialize(Stage stage) {
		setScene(new HomeScene(stage));
		setStatics(getScene().getStatics());
		setManagemnet(getScene().getManagemnet());
		setSave(getScene().getSave());
		
		handle_managemnet(getManagemnet());
		handle_statics(getStatics());
		handle_save(getSave());
	}
	/*
	 * Handlers
	 */
	private void handle_statics(Button statics) {
		statics.setOnAction(r->{
			/*
			 * Statics Screen
			 */
			new StaticsCtrl(new Stage());
		});
	}
	
	private void handle_managemnet(Button managemnet) {
		managemnet.setOnAction(r->{
			/*
			 * Managemnet Scene
			 */
			new ManagemnetCtrl(new Stage());
		});
	}
	
	private void handle_save(Button save) {
		save.setOnAction(e->{
			/*
			 * Save the CSV File scene
			 */
			new ChoseFolderCtrl(new Stage());
		});
	}

	/*
	 * Getters and Setters
	 */
	public Button getManagemnet() {
		return managemnet;
	}
	public void setManagemnet(Button managemnet) {
		this.managemnet = managemnet;
	}
	public Button getStatics() {
		return statics;
	}
	public void setStatics(Button statics) {
		this.statics = statics;
	}
	public HomeScene getScene() {
		return scene;
	}
	public void setScene(HomeScene scene) {
		this.scene = scene;
	}
	public Button getSave() {
		return save;
	}
	public void setSave(Button save) {
		this.save = save;
	}
}