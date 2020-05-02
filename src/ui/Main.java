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
		algorithmsRaceGUI = new AlgorithmsRaceGUI(algorithmsRace);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WelcomeFX.fxml"));
		fxmlLoader.setController(algorithmsRaceGUI);
		
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		
		stage.setTitle("Basic Algorithms Race");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[]args) {
		launch(args);
	}

}
