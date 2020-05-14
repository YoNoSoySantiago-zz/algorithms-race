package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import model.AlgorithmsRace;

public class Main extends Application{
	private AlgorithmsRaceGUI algorithmsRaceGUI;
	private AlgorithmsRace algorithmsRace;
	public Main() {
		algorithmsRace = new AlgorithmsRace();
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WelcomeFX.fxml"));
		algorithmsRaceGUI = new AlgorithmsRaceGUI(algorithmsRace,stage);
		fxmlLoader.setController(algorithmsRaceGUI);
		
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		
		stage.setMaxHeight(480);
		stage.setMaxWidth(1200);
		stage.setTitle("Basic Algorithms Race");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[]args) {
		launch(args);
	}

}
