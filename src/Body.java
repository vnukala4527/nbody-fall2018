
public class Body {
	private double myXPos, myYPos, myXVel, myYVel, myMass;
	private String myFileName;
	
	
	/**
	 * initialize instance variables
	 * @param xp
	 * @param yp
	 * @param xv
	 * @param yv
	 * @param mass
	 * @param filename
	 */
	public Body(double xp, double yp, double xv, double yv, double mass, String filename) {
		
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
		
		
			
	/**
	 * create copy constructor for Body b
	 */
	}
	public Body(Body b) {
		this.myXPos = b.myXPos;
		this.myYPos = b.myYPos;
		this.myXVel = b.myXVel;
		this.myYVel = b.myYVel;
		this.myMass = b.myMass;
		this.myFileName = b.myFileName;
		
		
				
		
	
	}
	
	
	/**
	 * 
	 * @return x position
	 */
	public double getX() {
		return myXPos;
		
	}
	/**
	 * 
	 * @return y position
	 */
	public double getY() {
		return myYPos;
		
	
	}
	/**
	 * 
	 * @return x velocity
	 */
	public double getXVel() {
		return myXVel;
		
	
	}
	/**
	 * 
	 * @return y velocity
	 */
	public double getYVel() {
		return myYVel;
		
	
	}
	/**
	 * 
	 * @return mass
	 */
	public double getMass() {
		return myMass;
	
	}
	/**
	 * 
	 * @return file name
	 */
	public String getName() {
		return myFileName;
		
		
	}
	
	
	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(Body b) {
		double dsqrd = (Math.pow((this.getY() - b.getY()),2) + Math.pow((this.getX() - b.getX()), 2));
		double dist = Math.sqrt(dsqrd);
		return dist;
		
		
		
		
	}
	
	/**
	 * calculate force exerted by
	 * @param p the body of which the force is calculated
	 * @return force exerted by body p
	 */
	public double calcForceExertedBy(Body p) {
		double Gravity = 6.67 * Math.pow(10, -11);
		double Force;
		Force = (Gravity * (this.getMass() * p.getMass()))/ (Math.pow(this.calcDistance(p), 2));
		return Force;
		
		
	}
	
	/**
	 * calculate force in x direction
	 * @param p body exerting force
	 * @return force in x direction
	 */
	public double calcForceExertedByX(Body p) {
		double xcomp;
		xcomp = ((this.calcForceExertedBy(p) * (p.getX()-this.getX())) / this.calcDistance(p));
		return xcomp;
		
		
		
		
	}
	/**
	 * calculate force in y direction
	 * @param p body exerting force
	 * @return force in y direction
	 */
	public double calcForceExertedByY(Body p) {
		double ycomp;
		ycomp = ((this.calcForceExertedBy(p) * (p.getY()-this.getY())) / this.calcDistance(p));
		return ycomp;
		
		
	}
	
	/**
	 * 
	 * @param bodies array of bodies in file
	 * @return net force exerted on this body by all the bodies in the array in the x direction
	 */
	public double calcNetForceExertedByX(Body[] bodies) {
		double xnet = 0.0;
		for(Body b : bodies) {
			if (! b.equals(this)) {
				xnet += this.calcForceExertedByX(b);
				
			}
		}
		
		return xnet;
		
		
	}
	
	/**
	 * 
	 * @param bodies array of bodies in file
	 * @return net force exerted on this body by all the bodies in the array in the y direction
	 */
	public double calcNetForceExertedByY(Body[] bodies) {
		double ynet = 0.0;
		for(Body b : bodies) {
			if (! b.equals(this)) {
				ynet += this.calcForceExertedByY(b);
				
			}
		}
		
		return ynet;
		
		
	}
	
	/**
	 * 
	 * @param deltaT change in time
	 * @param xforce force in x direction
	 * @param yforce force in y direction
	 * does not return anything, updates body
	 */
	public void update(double deltaT, double xforce, double yforce) {
		double ax = xforce / this.getMass();
		double ay = yforce / this.getMass();
		double nvx = myXVel + (deltaT * ax);
		double nvy = myYVel + (deltaT * ay);
		double nx = myXPos + deltaT*nvx;
		double ny = myYPos + deltaT*nvy;
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
					
		
		
	}
	
	/**
	 * draws body
	 */
	public void draw() {
		StdDraw.picture(myXPos, myYPos, "images/"+myFileName);
		
	} 
}

