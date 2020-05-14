package thread;

import javafx.application.Platform;
import ui.AlgorithmsRaceGUI;

public class ProgressRaceThread extends Thread{
	private AlgorithmsRaceGUI algorithmsRaceGUI;
	private int i;
	
	public ProgressRaceThread(AlgorithmsRaceGUI algorithmsRaceGUI, int i) {
		this.algorithmsRaceGUI = algorithmsRaceGUI;
		this.i = i;
	}
	
	@Override
	public void run() {
		while(algorithmsRaceGUI.isRunning()) {
			
			Platform.runLater(new Thread() {
				public void run() {
					if(i ==1) {
						algorithmsRaceGUI.updateProgressAL();
					}else if(i ==2) {
						algorithmsRaceGUI.updateProgressLE();
					}else {
						algorithmsRaceGUI.updateProgressAbb();
					}
				}
			});
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
