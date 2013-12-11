package uk.me.westmacott.lorenz;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import uk.me.westmacott.AbstractWorld;

public class LorenzWheel extends AbstractWorld {
	private static final int BUCKET_COUNT = 7;
	private static final double WHEEL_RADIUS = 100.0;
	private static final int CENTREPOINT = 150;
	
	private final LorenzWheelPhysics physics = new LorenzWheelPhysics(BUCKET_COUNT);

	public LorenzWheel(String name, int width, int height) {
		super(name, width, height);
	}

	@Override
	public void tick() {
		physics.tick();
	}

	@Override
	public void render(Graphics2D g2d) {
	    g2d.setColor(Color.BLACK);
	    drawBuckets(g2d, BUCKET_COUNT);
	    drawWheel(g2d);
	}

	private void drawBuckets(Graphics2D g2d, int bucketCount) {
		double angle = Math.PI * 2 / bucketCount;
		for (int i = 0; i < bucketCount; i++) {
			drawBucket(g2d, physics.getWheelAngleRadians() + i * angle);			
		}
	}

	private void drawWheel(Graphics2D g2d) {
		drawCircle(g2d, WHEEL_RADIUS, CENTREPOINT, CENTREPOINT);
	}

	private void drawBucket(Graphics2D g2d, double angle) {
		int x = (int) (WHEEL_RADIUS * Math.sin(angle));
	    int y = (int) (WHEEL_RADIUS * Math.cos(angle));
	    drawCircle(g2d, 10, CENTREPOINT + x, CENTREPOINT + y);
	}

	private void drawCircle(Graphics2D g2d, double radius, int x, int y) {
		Ellipse2D.Double hole = new Ellipse2D.Double();
	    hole.width = radius * 2;
	    hole.height = radius * 2;
	    hole.x = x - radius;
	    hole.y = y - radius;
	    g2d.draw(hole);
	}

}