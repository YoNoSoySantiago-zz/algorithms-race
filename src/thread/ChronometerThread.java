package thread;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.Timer;

import javafx.application.Platform;
import ui.AlgorithmsRaceGUI;

public class ChronometerThread extends Thread{
	private Timer t;
	private int minutes,seconds,cSeconds;
	private ActionListener acciones;
	AlgorithmsRaceGUI algorithmsRaceGUI;
	
	public ChronometerThread(AlgorithmsRaceGUI algorithmsRaceGUI) {
		minutes = 0;
		seconds=0;
		cSeconds=0;
		this.algorithmsRaceGUI=algorithmsRaceGUI;
		acciones = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
						algorithmsRaceGUI.updateCircule();
					}
				});
				
			}
			
		};
		t = new Timer(10,acciones);
	}
	
	@Override
	public void run() {
		t.start();
		while(algorithmsRaceGUI.isRunning()) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		t.stop();
	}
}
