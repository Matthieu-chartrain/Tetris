package Forme;

import Main.Point;
import Main.Tetris;

public class FormeL extends Forme {

	public FormeL(Point b) {
		super(new Point(b.getX(),b.getY()-Tetris.TAILLE),b,
				new Point(b.getX(),b.getY()+ Tetris.TAILLE),
				new Point(b.getX()+ Tetris.TAILLE, b.getY()+Tetris.TAILLE),5);
	}

	@Override
	public void descendre(int vitesse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void miseForme1() {
		super.getA().setX(super.getB().getX());
		super.getA().setY(super.getB().getY() - Tetris.TAILLE);
		super.getC().setX(super.getB().getX());
		super.getC().setY(super.getB().getY() + Tetris.TAILLE);
		super.getD().setX(super.getB().getX() + Tetris.TAILLE);
		super.getD().setY(super.getB().getY() + Tetris.TAILLE);
	}

	@Override
	public void miseForme2() {
		super.getA().setX(super.getB().getX() + Tetris.TAILLE);
		super.getA().setY(super.getB().getY());
		super.getC().setX(super.getB().getX() - Tetris.TAILLE);
		super.getC().setY(super.getB().getY());
		super.getD().setX(super.getB().getX() - Tetris.TAILLE);
		super.getD().setY(super.getB().getY() + Tetris.TAILLE);
	}

	@Override
	public void miseForme3() {
		super.getA().setX(super.getB().getX());
		super.getA().setY(super.getB().getY() + Tetris.TAILLE);
		super.getC().setX(super.getB().getX());
		super.getC().setY(super.getB().getY() - Tetris.TAILLE);
		super.getD().setX(super.getB().getX() - Tetris.TAILLE);
		super.getD().setY(super.getB().getY() - Tetris.TAILLE);
	}

	@Override
	public void miseForme4() {
		super.getA().setX(super.getB().getX() - Tetris.TAILLE);
		super.getA().setY(super.getB().getY());
		super.getC().setX(super.getB().getX() + Tetris.TAILLE);
		super.getC().setY(super.getB().getY());
		super.getD().setX(super.getB().getX() + Tetris.TAILLE);
		super.getD().setY(super.getB().getY() - Tetris.TAILLE);
	}

}
