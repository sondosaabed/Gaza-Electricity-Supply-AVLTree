/**
 * 
 */
package model;

import control.BrowseFileCtrl;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * 		In this project an electricy records mangamnet system is cretaed 
 * 		regarding Gaza electricy
 * 
 */
public class Main extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		new BrowseFileCtrl(stage);
	}
}
