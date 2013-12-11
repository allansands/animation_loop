package uk.me.westmacott.lorenz;

public class LorenzWheelPhysics {
	private double angle = 0.0;
	private final int bucketCount;

	public LorenzWheelPhysics(int bucketCount) {
		this.bucketCount = bucketCount;
	}

	public void tick(LorenzWheel lorenzWheel) {
		tick();
	}

	public void tick() {
	    this.angle = angle + 0.01;
	}

	public double getWheelAngleRadians() {
		return angle;
	}
}