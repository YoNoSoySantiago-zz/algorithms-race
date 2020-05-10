package thread;

import model.AlgorithmsRace;

public class PrepareRaceThread extends Thread{
	private AlgorithmsRace algorithmsRace;
	private boolean many;
	private long n;
	public PrepareRaceThread(AlgorithmsRace algorithmsRace, boolean algorithm,long n) {
		this.algorithmsRace=algorithmsRace;
		many = algorithm;
		this.n = n;
	}
	
	@Override
	public void run() {
		algorithmsRace.prepareRace(n);
	}
}
