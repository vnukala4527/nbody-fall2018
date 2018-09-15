	

/**
 * @author YOUR NAME THE STUDENT IN 201
 * 
 * Simulation program for the NBody assignment
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NBody {
	
	/**
	 * Read the specified file and return the radius
	 * @param fname is name of file that can be open
	 * @return the radius stored in the file
	 * @throws FileNotFoundException if fname cannot be open
	 */
	public static double readRadius(String fname) throws FileNotFoundException  {
		Scanner s = new Scanner(new File(fname));
	
		// TODO: read values at beginning of file to
		// find the radius
		s.nextInt();
		double radius = s.nextDouble();
		
		s.close();
		
		// TODO: return radius read
		return radius;	
	}
	
	/**
	 * Read all data in file, return array of Celestial Bodies
	 * read by creating an array of Body objects from data read.
	 * @param fname is name of file that can be open
	 * @return array of Body objects read
	 * @throws FileNotFoundException if fname cannot be open
	 */
	public static Body[] readBodies(String fname) throws FileNotFoundException {
		
			Scanner s = new Scanner(new File(fname));
			
			// TODO: read # bodies, create array, ignore radius
			int nb = 0; // # bodies to be read
			//int bodies = s.nextInt();
			//double radius = s.nextDouble();
			/* while (s.hasNextDouble()) {
		          nb += 1;
		          s.nextDouble();
		         
		      }
			nb = (nb - 1)/5; */
			
			nb = s.nextInt();
			Body[] bod = new Body[nb];
			
			
			
			//s.reset();
			//s.nextInt();
			//double radius = s.nextDouble();
			//s.close();
			//Scanner t = new Scanner(new File(fname));
			double radius = s.nextDouble();
			
			for(int k=0; k < nb; k++) {
				
				// TODO: read data for each body
				// construct new body object and add to array
				
				double myXPos = s.nextDouble();
				double myYPos = s.nextDouble();
				double myXVel = s.nextDouble();
				double myYVel = s.nextDouble();
				double myMass = s.nextDouble();
				String myFileName = s.next();
				bod[k] = new Body(myXPos,myYPos,myXVel,myYVel,myMass,myFileName);
			
				//s.nextLine();
				
			}
			
			s.close();
			
			// TODO: return array of body objects read
			return bod;
	}
	public static void main(String[] args) throws FileNotFoundException{
		double totalTime = 157788000.0;
		double dt = 25000.0;
		
		String fname= "./data/planets.txt";
		if (args.length > 2) {
			totalTime = Double.parseDouble(args[0]);
			dt = Double.parseDouble(args[1]);
			fname = args[2];
		}	
		
		Body[] bodies = readBodies(fname);
		double radius = readRadius(fname);
		
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0,0,"images/starfield.jpg");
	
		for(double t = 0.0; t < totalTime; t += dt) {
			
			// TODO: create double arrays xforces and yforces
			// to hold forces on each body
			double[] xForces = new double[bodies.length];
			double[] yForces = new double[bodies.length];
			
			
			
			
			// TODO: loop over all bodies, calculate
			// net forces and store in xforces and yforces
			for (int k = 0;k < bodies.length; k++) {
				xForces[k] = bodies[k].calcNetForceExertedByX(bodies);
				yForces[k] = bodies[k].calcNetForceExertedByY(bodies);
				
				
				
			}
			
			// TODO: loop over all bodies and call update
			// with dt and corresponding xforces, yforces values
			for (int i = 0;i < bodies.length; i++) {
				bodies[i].update(dt,xForces[i],yForces[i]);
				
			}
			
			StdDraw.picture(0,0,"images/starfield.jpg");
			
			// TODO: loop over all bodies and call draw on each one
			
			StdDraw.show(10);
		}
		
		// prints final values after simulation
		
		System.out.printf("%d\n", bodies.length);
		System.out.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
		    System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		   		              bodies[i].getX(), bodies[i].getY(), 
		                      bodies[i].getXVel(), bodies[i].getYVel(), 
		                      bodies[i].getMass(), bodies[i].getName());	
		}
	}
}
