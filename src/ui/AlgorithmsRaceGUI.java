package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import model.AlgorithmsRace;

public class AlgorithmsRaceGUI {
	
	private AlgorithmsRace algorithmsRace;
	public AlgorithmsRaceGUI(AlgorithmsRace ar) {
		algorithmsRace =ar;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartRaceFX.fxml"));
		try {
			Pane startPane = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(startPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Main
	@FXML
	private BorderPane mainPane;
	
	//Start
    @FXML
    private TextField textN;

    @FXML
    private Label arrayListTime;

    @FXML
    private Label linkedlIstTime;

    @FXML
    private Label abbTime;

    @FXML
    private Label timer;

    @FXML
    private Circle bigCurcule;

    @FXML
    private Circle littleCircule;

    @FXML
    void IteractiveSelect(ActionEvent event) {

    }

    @FXML
    void RecursiveSelect(ActionEvent event) {

    }

    @FXML
    void addSelect(ActionEvent event) {

    }

    @FXML
    void btnRun(ActionEvent event) {

    }

    @FXML
    void dalateSelect(ActionEvent event) {

    }

    @FXML
    void searchSelect(ActionEvent event) {

    }
    
}
