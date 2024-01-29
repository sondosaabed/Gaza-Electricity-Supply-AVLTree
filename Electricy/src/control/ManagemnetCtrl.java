package control;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import visualization.ManagementScene;

public class ManagemnetCtrl {
	private ManagementScene scene;
	private Button insert;
	private Button update;
	private Button Delete;
	private Button search;
	private Button printTree;
	private Button printHeights;
	
	public ManagemnetCtrl(Stage stage) {
		initialize(stage);
	}
	
	/*
	 * Handlers
	 */
	
	private void initialize(Stage stage) {
		setScene(new ManagementScene(stage));
		setSearch(getScene().getSearch());
		setInsert(getScene().getInsert());
		setUpdate(getScene().getUpdate());
		setDelete(getScene().getDelete());
		setPrintHeights(getScene().getPrintHeights());
		setPrintTree(getScene().getPrintTree());
		
		handle_search(getSearch());
		handle_insert(getInsert());
		handle_update(getUpdate());
		handle_delete(getDelete());
		handle_printHeights(getPrintHeights());
		handle_printTree(getPrintTree());		
	}

	private void handle_insert(Button insert2) {
		insert2.setOnAction(e->{
			new FormCtrl(new Stage(), "Insert", null);
		});		
	}
	private void handle_printHeights(Button printHeights2) {
		printHeights2.setOnAction(e->{
			new PickDateCtrl(new Stage(), "Print Heights");
		});
	}
	private void handle_printTree(Button printTree2) {
		printTree2.setOnAction(e->{
			new PickDateCtrl(new Stage(), "Print Trees");
		});		
	}
	private void handle_delete(Button delete2) {
		delete2.setOnAction(e->{
			new PickDateCtrl(new Stage(),"Delete");
		});
	}
	private void handle_update(Button update2) {
		update2.setOnAction(e->{
			new PickDateCtrl(new Stage(),"Update");
		});
	}
	private void handle_search(Button search2) {
		search2.setOnAction(e->{
			new PickDateCtrl(new Stage(),"Search");
		});		
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
		return Delete;
	}
	public void setDelete(Button delete) {
		Delete = delete;
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
	public ManagementScene getScene() {
		return scene;
	}
	public void setScene(ManagementScene scene) {
		this.scene = scene;
	}
}