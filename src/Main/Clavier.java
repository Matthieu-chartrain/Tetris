package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Tetris.scene.forme1.allerGauche();
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Tetris.scene.forme1.allerDroite();
		}
		else if (e.getKeyCode() == KeyEvent.VK_Q) {
			Tetris.scene.forme1.tournerGauche();
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			Tetris.scene.forme1.tournerDroite();
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (!(Tetris.scene.forme1.collisionBas())){
            	Tetris.scene.forme1.tomber();
            }
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			while (!(Tetris.scene.forme1.collisionBas())){
            	Tetris.scene.forme1.tomber();
            }
		}
		else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
