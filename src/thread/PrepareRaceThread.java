package thread;

import javafx.application.Platform;
import model.AlgorithmsRace;
import ui.AlgorithmsRaceGUI;

public class PrepareRaceThread extends Thread{
	private AlgorithmsRace algorithmsRace;
	private AlgorithmsRaceGUI alGUI;
	private long n;
	public PrepareRaceThread( AlgorithmsRaceGUI alGUI,AlgorithmsRace algorithmsRace,long n) {
		this.algorithmsRace=algorithmsRace;
		this.n = n;
		this.alGUI = alGUI;
	}
	
	@Override
	public void run() {
		algorithmsRace.prepareRace(n);
		algorithmsRace.setOn(false);
		Platform.runLater(new Thread() {
			public void run() {
				alGUI.eneableStart();
			}
			
		});
		
	}
}
