package thread;

import javafx.application.Platform;
import model.AlgorithmsRace;
import ui.AlgorithmsRaceGUI;

public class AlgorithmsThread extends Thread{
	private AlgorithmsRace algorithmsRace;
	private AlgorithmsRaceGUI algorithmsRaceGUI;
	private int algorithm;
	private int mode;
	private int data;
	private long n;
	
	public AlgorithmsThread(AlgorithmsRaceGUI algorithmsRaceGUI,AlgorithmsRace algorithmsRace,int algorithm,int mode,int data,long n) {
		this.algorithmsRace = algorithmsRace;
		this.algorithmsRaceGUI=algorithmsRaceGUI;
		this.algorithm = algorithm;
		this.mode = mode;
		this.data = data;
		this.n = n;
	}
	
	@Override
	public void run() {
		algorithmsRace.startRace(algorithm, mode, data,n);
		Platform.runLater(new Thread() {
			public void run() {
				if(data ==1) {
					algorithmsRaceGUI.updateTimerAL();
				}else if(data ==2) {
					algorithmsRaceGUI.updateTimerLE();
				}else {
					algorithmsRaceGUI.updateTimerAbb();
				}
			}
		});
		
	}
}
