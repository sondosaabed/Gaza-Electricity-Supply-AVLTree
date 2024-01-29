package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
/*
 * I Create a scene that shows a new window with some specific alert for the user
 */
public class AlertBoxScene {
	//Attributes
	private Stage window;
	private Label message;
	private Button cancel;
	/*
	 * Constructor
	 */
	public AlertBoxScene(boolean warn) {
		initialize(warn);
	}
	/*
	 * Initialize objects
	 */
	private void initialize(boolean warn) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 100, 100, 100));
		pane.setHgap(15);
		pane.setVgap(15);
		pane.setBackground(background);

		Image img = new Image("resources/warning.png");
		Image img1 = new Image("resources/done.png");
		
		ImageView v = null;
		if(warn == true) {
			 v = new ImageView(img);
		}else {
			 v = new ImageView(img1);
		}
		
		v.setFitWidth(170);
		v.setFitHeight(170);

		Button logo = new Button();
		logo.setPrefSize(170, 170);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);
		
		message=new Label();
		message.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		message.setTextFill(Color.DARKRED);
		pane.add(message, 0, 1);
		
		//User button to exit
		cancel = new Button("Okay");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		cancel.setPrefSize(80, 20);
		GridPane.setHalignment(cancel,HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#DDEDE5;");
		pane.add(cancel,0,2); 

		Scene scene = new Scene(pane);
		window=new Stage();
		window.setScene(scene);
		window.getIcons().add(new Image("resources/logo.png"));
	}
	/*
	 * Getters and Setters
	 */

	/**
	 * @return the window
	 */
	public Stage getWindow() {
		return window;
	}

	/**
	 * @param window the window to set
	 */
	public void setWindow(Stage window) {
		this.window = window;
	}

	/**
	 * @return the message
	 */
	public Label getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(Label message) {
		this.message = message;
	}

	/**
	 * @return the cancel
	 */
	public Button getCancel() {
		return cancel;
	}

	/**
	 * @param cancel the cancel to set
	 */
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
}