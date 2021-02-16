package Main;

public class Chrono implements Runnable {
	
	private final int PAUSE = 25; 

	@Override
	public void run() {
		while(true) {
			Tetris.scene.repaint();
			
			try {
				Thread.sleep(PAUSE);
			}catch(InterruptedException e) {}
		}
	}
}
