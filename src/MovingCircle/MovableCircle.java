package MovingCircle;

import javafx.scene.shape.Circle;

public class MovableCircle extends Circle {

	private float dx = 0, dy = 0;

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}

	public MovableCircle(double centerX, double centerY, double radius, float dx, float dy) {
		super(centerX, centerY, radius);
		this.dx = dx;
		this.dy = dy;
	}

}
