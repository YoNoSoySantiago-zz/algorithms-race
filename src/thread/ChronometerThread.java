package thread;

import javafx.application.Platform;
import ui.AlgorithmsRaceGUI;

public class ChronometerThread extends Thread{
	private int minutes,seconds,cSeconds;
	private AlgorithmsRaceGUI algorithmsRaceGUI;
	
	public ChronometerThread(AlgorithmsRaceGUI algorithmsRaceGUI) {
		this.algorithmsRaceGUI = algorithmsRaceGUI;
		minutes = 0;
		seconds=0;
		cSeconds=0;
	}
	
	@Override
	public void run() {
		while(algorithmsRaceGUI.isRunning()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cSeconds++;
			if(cSeconds>=100) {
				seconds++;
				cSeconds = 0;
			}
			if(seconds>=60) {
				minutes++;
				seconds=0;
			}
			algorithmsRaceGUI.updateTime(minutes, seconds, cSeconds);
			Platform.runLater(new Thread() {
				public void run() {
					algorithmsRaceGUI.updateTimer();
				}
			});
		}
	}
}
