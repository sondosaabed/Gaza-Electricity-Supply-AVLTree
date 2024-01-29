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

/**
 * 	 in this class I created the main scene to be the first scene shown 
 * 	where the user decide what they want
 */
public class HomeScene {
	//Feilds
	private Button managemnet;
	private Button statics;
	private Button save;
	private HomeScene scene;

	/*
	 * Constructor
	 */
	public HomeScene(Stage stage) {
		initialize(stage);
	}
	/*
	 * this is a method that initialize the scene style and nodes
	 */
	private void initialize(Stage stage){
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(70, 150,70, 150));
		pane.setHgap(15);
		pane.setVgap(15);
		pane.setBackground(background);
		
		GridPane pane1 = new GridPane();
		pane1.setAlignment(Pos.CENTER);
		pane1.setHgap(15);
		pane1.setVgap(15);
		pane1.setBackground(background);
		pane.add(pane1, 1, 0);
		
		Image img1 = new Image("resources/csv.png");
		ImageView v1 = new ImageView(img1);
		v1.setFitWidth(190);
		v1.setFitHeight(190);
		
		Image img2 = new Image("resources/managmnet.png");
		ImageView v2 = new ImageView(img2);
		v2.setFitWidth(190);
		v2.setFitHeight(190);
		
		Image img = new Image("resources/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(100);
		v.setFitHeight(100);
		
		
		Image img3 = new Image("resources/statics.png");
		ImageView v3 = new ImageView(img3);
		v3.setFitWidth(190);
		v3.setFitHeight(190);
		
		Button logo = new Button();
		logo.setPrefSize(100, 100);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane1.add(logo, 0, 0);
		
		Label ms=new Label("Take an action?!");
		ms.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		ms.setTextFill(Color.BLACK);
		pane1.add(ms, 1, 0);
		
		managemnet = new Button();
		managemnet.setPrefSize(200, 200);
		managemnet.setGraphic(v2);
		managemnet.setStyle("-fx-border-color: black;-fx-border-width: 1;-fx-border-radius:5;-fx-background-radius: 7;-fx-background-color: transparent;");
		GridPane.setHalignment(managemnet, HPos.CENTER);
		pane.add(managemnet, 0, 2);
		
		Label search=new Label("Manage Records?");
		search.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		search.setTextFill(Color.BLACK);
		GridPane.setHalignment(search, HPos.CENTER);

		pane.add(search, 0, 1);
		
		statics = new Button();
		statics.setPrefSize(200, 200);
		statics.setGraphic(v3);
		statics.setStyle("-fx-border-color: black;-fx-border-width: 1;-fx-border-radius:5;-fx-background-radius: 7;-fx-background-color: transparent;");
		GridPane.setHalignment(statics, HPos.CENTER);
		pane.add(statics, 1, 2);
		
		
		Label segment=new Label("Statics?");
		segment.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		segment.setTextFill(Color.BLACK);
		GridPane.setHalignment(segment, HPos.CENTER);
		pane.add(segment, 1, 1);
		
		
		save = new Button();
		save.setPrefSize(200, 200);
		save.setGraphic(v1);
		save.setStyle("-fx-border-color: black;-fx-border-width: 1;-fx-border-radius:5;-fx-background-radius: 7;-fx-background-color: transparent;");
		GridPane.setHalignment(save, HPos.CENTER);
		pane.add(save, 2, 2);
		
		Label hash=new Label("Download CSV?");
		hash.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		hash.setTextFill(Color.BLACK);
		GridPane.setHalignment(hash, HPos.CENTER);
		pane.add(hash, 2, 1);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.getIcons().add(new Image("resources/logo.png"));
		stage.setTitle("Dashborad");
		stage.show();
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