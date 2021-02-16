package Forme;

import Main.Point;
import Main.Tetris;

public class LInverse extends Forme {

	public LInverse(Point b) {
		super(new Point(b.getX(), b.getY()+ Tetris.TAILLE),b,
				new Point(b.getX()- Tetris.TAILLE,b.getY()),
				new Point(b.getX()- (Tetris.TAILLE * 2),b.getY()), 6);
	}

	@Override
	public void descendre(int vitesse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void miseForme1() {
		super.getA().setX(super.getB().getX());
		super.getA().setY(super.getB().getY()+ Tetris.TAILLE);
		super.getC().setX(super.getB().getX()- Tetris.TAILLE);
		super.getC().setY(super.getB().getY());
		super.getD().setX(super.getB().getX()- (Tetris.TAILLE*2));
		super.getD().setY(super.getB().getY());
	}

	@Override
	public void miseForme2() {
		super.getA().setX(super.getB().getX()- Tetris.TAILLE);
		super.getA().setY(super.getB().getY());
		super.getC().setX(super.getB().getX());
		super.getC().setY(super.getB().getY()- Tetris.TAILLE);
		super.getD().setX(super.getB().getX());
		super.getD().setY(super.getB().getY()- (Tetris.TAILLE*2));
	}

	@Override
	public void miseForme3() {
		super.getA().setX(super.getB().getX());
		super.getA().setY(super.getB().getY()- Tetris.TAILLE);
		super.getC().setX(super.getB().getX()+ Tetris.TAILLE);
		super.getC().setY(super.getB().getY());
		super.getD().setX(super.getB().getX()+ (Tetris.TAILLE*2));
		super.getD().setY(super.getB().getY());
	}

	@Override
	public void miseForme4() {
		super.getA().setX(super.getB().getX()+ Tetris.TAILLE);
		super.getA().setY(super.getB().getY());
		super.getC().setX(super.getB().getX());
		super.getC().setY(super.getB().getY()+ Tetris.TAILLE);
		super.getD().setX(super.getB().getX());
		super.getD().setY(super.getB().getY()+ (Tetris.TAILLE*2));
	}

}
