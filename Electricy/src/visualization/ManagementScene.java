package visualization;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ManagementScene {
	private Button insert;
	private Button update;
	private Button delete;
	private Button search;
	private Button printTree;
	private Button printHeights;
	
	public ManagementScene(Stage stage) {
		initialize(stage);
	}
	
	private void initialize(Stage stage) {
		VBox root = new VBox(50);
        root.setPadding(new Insets(50));
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		root.setBackground(background);
        
        Text title = new Text("Management Options");
        title.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
        HBox optionsBoxAbove = new HBox(5);
        HBox optionsBoxBelow = new HBox(5);
        GridPane.setHalignment(title, HPos.CENTER);

        insert = createStyledButton("Insert");
        update = createStyledButton("Update");
        delete = createStyledButton("Delete");
        search = createStyledButton("Search");
        printTree = createStyledButton("Print Tree");
        printHeights = createStyledButton("Print Heights");

        optionsBoxAbove.getChildren().addAll(insert, update, delete);
        optionsBoxBelow.getChildren().addAll(search, printTree, printHeights);
        root.getChildren().addAll(title, optionsBoxAbove, optionsBoxBelow);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
		stage.getIcons().add(new Image("resources/logo.png"));
        stage.show();
	}
	
    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(250, 70);
        button.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 5; " +
                "-fx-background-radius: 7; -fx-background-color: #DDEDE5;");
        button.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
        GridPane.setHalignment(button, HPos.CENTER);
        return button;
    }
	/*
	 * Getters & Setters
	 */
	public Button getInsert() {
		return insert;
	}
	public void setInsert(Button insert) {
		this.insert = insert;
	}
	public Button getUpdate() {
		return update;
	}
	public void setUpdate(Button update) {
		this.update = update;
	}
	public Button getDelete() {
		return delete;
	}
	public void setDelete(Button delete) {
		this.delete = delete;
	}
	public Button getSearch() {
		return search;
	}
	public void setSearch(Button search) {
		this.search = search;
	}
	public Button getPrintTree() {
		return printTree;
	}
	public void setPrintTree(Button printTree) {
		this.printTree = printTree;
	}
	public Button getPrintHeights() {
		return printHeights;
	}
	public void setPrintHeights(Button printHeights) {
		this.printHeights = printHeights;
	}
	
}