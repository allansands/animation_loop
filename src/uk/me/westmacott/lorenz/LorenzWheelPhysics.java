package uk.me.westmacott.lorenz;

public class LorenzWheelPhysics {
	private double angle = Math.PI / 2;
	private final int bucketCount;
	
	private double bucketsWeights[];
	private double bucketsVelocities[];

	public LorenzWheelPhysics(int bucketCount) {
		this.bucketCount = bucketCount;
		bucketsWeights = new double[bucketCount];
		bucketsWeights[0] = 120.0;
		bucketsVelocities = new double[bucketCount];
	}

	public void tick() {
		double wheelVelocity = 0.0;
		for (int i = 0; i < bucketCount; i++) {
			bucketsVelocities[i] += accelerationOfBucket(i);
			wheelVelocity += bucketsVelocities[i];
		}
		
	    this.angle = angle + wheelVelocity;
	    System.out.println(wheelVelocity);
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
		return angle  + i * angleBetweenBuckets;
	}

}