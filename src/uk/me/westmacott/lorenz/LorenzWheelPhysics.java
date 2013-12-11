package uk.me.westmacott.lorenz;

public class LorenzWheelPhysics {
	private double angle = Math.PI / 2;
	private final int bucketCount;
	
	private double buckets[];

	public LorenzWheelPhysics(int bucketCount) {
		this.bucketCount = bucketCount;
		buckets = new double[bucketCount];
		buckets[0] = 120.0;
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
	
	public double getBucketFillHeight(int bucketNo) {
		return buckets[bucketNo];
	}
}