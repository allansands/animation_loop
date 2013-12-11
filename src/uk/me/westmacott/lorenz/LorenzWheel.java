package uk.me.westmacott.lorenz;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import uk.me.westmacott.AbstractWorld;

public class LorenzWheel extends AbstractWorld {
	private static final double WHEEL_RADIUS = 100.0;
	private static final int WHEEL_RADIUS_INT = 100;
	
	private static final int CENTREPOINT = 150;
	double a = 0.0;

	public LorenzWheel(String name, int width, int height) {
		super(name, width, height);
	}

	@Override
	public void tick() {
	    a += 0.01;
	}

	@Override
	public void render(Graphics2D g2d) {
	    int x = (int) (WHEEL_RADIUS * Math.sin(a));
	    int y = (int) (WHEEL_RADIUS * Math.cos(a));
	    g2d.setColor(Color.BLACK);
	    drawCircle(g2d, 10, CENTREPOINT + x, CENTREPOINT + y);

	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	    drawCircle(g2d, WHEEL_RADIUS, CENTREPOINT, CENTREPOINT);
	    
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