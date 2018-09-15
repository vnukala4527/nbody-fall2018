
public class Body {
	private double myXPos, myYPos, myXVel, myYVel, myMass;
	private String myFileName;
	public Body(double xp, double yp, double xv, double yv, double mass, String filename) {
		
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
		
			
		
		
	}
	public Body(Body b) {
		this.myXPos = b.myXPos;
		this.myYPos = b.myYPos;
		this.myXVel = b.myXVel;
		this.myYVel = b.myYVel;
		this.myMass = b.myMass;
		this.myFileName = b.myFileName;
		
		
				
		
		
	}
	
	public double getX() {
		return myXPos;
		
	}
	
	public double getY() {
		return myYPos;
		
		
	}
	public double getXVel() {
		return myXVel;
		
		
	}
	public double getYVel() {
		return myYVel;
		
		
	}
	public double getMass() {
		return myMass;
		
	}
	public String getName() {
		return myFileName;
		
		
	}
	
	

	public double calcDistance(Body b) {
		double dsqrd = (Math.pow((this.getY() - b.getY()),2) + Math.pow((this.getX() - b.getX()), 2));
		double dist = Math.sqrt(dsqrd);
		return dist;
		
		
		
		
	}
	
	
	public double calcForceExertedBy(Body p) {
		double Gravity = 6.67 * Math.pow(10, -11);
		double Force;
		Force = (Gravity * (this.getMass() * p.getMass()))/ (Math.pow(this.calcDistance(p), 2));
		return Force;
		
		
	}
	
	
	public double calcForceExertedByX(Body p) {
		double xcomp;
		xcomp = ((this.calcForceExertedBy(p) * (p.getX()-this.getX())) / this.calcDistance(p));
		return xcomp;
		
		
		
		
	}
	public double calcForceExertedByY(Body p) {
		double ycomp;
		ycomp = ((this.calcForceExertedBy(p) * (p.getY()-this.getY())) / this.calcDistance(p));
		return ycomp;
		
		
	}
	
	
	public double calcNetForceExertedByX(Body[] bodies) {
		double xnet = 0.0;
		for(Body b : bodies) {
			if (! b.equals(this)) {
				xnet += this.calcForceExertedByX(b);
				
			}
		}
		
		return xnet;
		
		
	}
	
	
	public double calcNetForceExertedByY(Body[] bodies) {
		double ynet = 0.0;
		for(Body b : bodies) {
			if (! b.equals(this)) {
				ynet += this.calcForceExertedByY(b);
				
			}
		}
		
		return ynet;
		
		
	}
	/*
	public void update(double deltaT, double xforce, double yforce) {
		
	}
	
	public void draw() {
		
	} */
}

