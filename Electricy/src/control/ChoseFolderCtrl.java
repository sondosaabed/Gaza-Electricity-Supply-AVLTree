package control;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import model.CSVandAVL;
import model.Data;
import visualization.ChoseFolderScene;

public class ChoseFolderCtrl {
	private ChoseFolderScene scene;
    private Label label;
    private Button browse;
	private Button cancel;
	
	private DirectoryChooser directoryChooser;
	private File savingPath;
	
	public ChoseFolderCtrl(Stage stage) {
		initilaize(stage);
	}
	
	
	private void initilaize(Stage stage) {
		setScene(new ChoseFolderScene(stage));
		setLabel(getScene().getLabel());
		setBrowse(getScene().getBrowse());
		setCancel(getScene().getCancel());
		setDirectoryChooser(new DirectoryChooser());
		handle_browse(getBrowse());
		handle_cancel(getCancel(), stage);		
	}


	private void handle_cancel(Button cancel2, Stage stage) {
		cancel2.setOnAction(e->{
			stage.close();
		});		
	}

	private void handle_browse(Button browse2) {
		browse2.setOnAction(e->{
			setSavingPath(getDirectoryChooser().showDialog(new Stage()));

			if (getSavingPath() == (null)) {
				AlertBoxCtrl a = new AlertBoxCtrl("You haven't chose a Directory!", "No Directory", true);
				a.show();
			} else {
				if(CSVandAVL.readAVLCSV(Data.getData(), getSavingPath())) {
					AlertBoxCtrl a = new AlertBoxCtrl("File created successfully!", "file created", false);
					a.show();
				}else {
					AlertBoxCtrl a = new AlertBoxCtrl("There was an error of creating the file!", "No file created", true);
					a.show();
				}
			}
		});
	}

	/*
	 * Getters & Setters
	 */
	public ChoseFolderScene getScene() {
		return scene;
	}
	public void setScene(ChoseFolderScene scene) {
		this.scene = scene;
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
	public DirectoryChooser getDirectoryChooser() {
		return directoryChooser;
	}
	public void setDirectoryChooser(DirectoryChooser directoryChooser) {
		this.directoryChooser = directoryChooser;
	}
	public File getSavingPath() {
		return savingPath;
	}
	public void setSavingPath(File savingPath) {
		this.savingPath = savingPath;
	}
}