package uk.me.westmacott.lorenz;

public class LorenzWheelPhysics {
	private double angle = Math.PI / 2;
	private final int bucketCount;
	
	private double bucketsWeights[];
	private double wheelVelocity = 0;

	public LorenzWheelPhysics(int bucketCount) {
		this.bucketCount = bucketCount;
		bucketsWeights = new double[bucketCount];
		bucketsWeights[0] = 120.0;
	}

	public void tick() {
		for (int i = 0; i < bucketCount; i++) {
			wheelVelocity += accelerationOfBucket(i);
			
			if (Math.abs(getBucketAngle(i)) % (Math.PI * 2) < 1) {
				bucketsWeights[i] += 3;
				if (bucketsWeights[i] > 255) {
					bucketsWeights[i] = 255;
				}
			}
			
			bucketsWeights[i] -= 0.5;
			if (bucketsWeights[i] < 0) {
				bucketsWeights[i] = 0;
			}
		}
		wheelVelocity *= 0.99;
	    this.angle = (angle + wheelVelocity) % (Math.PI * 2);
	}

	private double accelerationOfBucket(int i) {
		double bucketAngle = getBucketAngle(i);
		double g = getBucketFillHeight(i) / 500000;
		double acc = g * Math.sin(bucketAngle);
		return acc;
	}

	public double getWheelAngleRadians() {
		return angle;
	}
	
	public double getBucketFillHeight(int bucketNo) {
		return bucketsWeights[bucketNo];
	}

	public double getBucketAngle(int i) {
		double angleBetweenBuckets = Math.PI * 2 / bucketCount;
		return angle + i * angleBetweenBuckets;
	}

}