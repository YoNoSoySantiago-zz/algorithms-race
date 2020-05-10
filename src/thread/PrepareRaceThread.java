package thread;

import model.AlgorithmsRace;

public class PrepareRaceThread extends Thread{
	private AlgorithmsRace algorithmsRace;
	private long n;
	public PrepareRaceThread(AlgorithmsRace algorithmsRace,long n) {
		this.algorithmsRace=algorithmsRace;
		this.n = n;
	}
	
	@Override
	public void run() {
		algorithmsRace.prepareRace(n);
	}
}
