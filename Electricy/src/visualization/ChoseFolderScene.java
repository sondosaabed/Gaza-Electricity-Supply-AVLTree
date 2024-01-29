package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.Scene;

/*
 * In this class I have created a scene that will be used in many controllers in this project 
 * where the user sets the directory an choses it
 * 
 */
public class ChoseFolderScene {
	//fields
    private GridPane pane;
    private Label label;
    private Button browse;
	private Button cancel;
  		
    //Constructor accepts a stage
	public ChoseFolderScene(Stage stage) {
      initialize(stage);
    }
	
    public void initialize(Stage stage) {
    	pane = new GridPane();
    	pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(70));
		pane.setHgap(7);
		pane.setVgap(10);
		
		Background bGround = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
		pane.setBackground(bGround); 
		
		label = new Label("Choose the directory you want to save the file in..");
		label.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(label, 0,0);
		
		browse = createStyledButton("Browse"); 
		cancel = createStyledButton("Cancel");
		
		pane.add(browse , 1,0);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Browse for the directory");
		stage.getIcons().add(new Image("resources/logo.png"));
		stage.centerOnScreen();
		stage.show();
    }
    
    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(100, 30);
        button.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 5; " +
                "-fx-background-radius: 7; -fx-background-color: #DDEDE5;");
        button.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 18));
        GridPane.setHalignment(button, HPos.CENTER);
        return button;
    }
    
    /*
     * Getters and Setters
     */
	public GridPane getPane() {
		return pane;
	}
	public void setPane(GridPane pane) {
		this.pane = pane;
	}
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public Button getBrowse() {
		return browse;
	}
	public void setBrowse(Button browse) {
		this.browse = browse;
	}
	public Button getCancel() {
		return cancel;
	}
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
}