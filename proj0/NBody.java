public class NBody{

	/** returns radious from a file */
	public static double readRadius(String filename){
		In next = new In(filename);
		int skip = next.readInt();
		double radius = next.readDouble();

		return radius;

	}
	/** returns array of bodies from an input file */
	public static Body[] readBodies(String filename){
		In next = new In(filename);
		int numberOfBodies = next.readInt();
		double skip = next.readDouble();

		Body[] bodies = new Body[numberOfBodies];

		for (int i = 0; i< numberOfBodies; i++){

			double xVal = next.readDouble();
			double yVal = next.readDouble();
			double xPos = next.readDouble();
			double yPos = next.readDouble();
			double mass = next.readDouble();
			String img = next.readString();

			bodies[i] = new Body(xVal, yVal, xPos, yPos, mass, img);
		}

		return bodies;

	}

	public static void main(String[] args){

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		Body[] bodies = readBodies(filename);
		double radius = readRadius(filename);

		double time = 0;

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();

		while (time <= T){
			double[] xForces = new double[bodies.length];
			double[] yForces = new double[bodies.length];

			for (int i = 0; i<bodies.length; i++){
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
			}

			for (int i = 0; i<bodies.length;i++){
				Body b = bodies[i];

				b.update(dt, xForces[i], yForces[i]);
			}


			StdDraw.picture(0,0,"images/starfield.jpg");

			for (Body b : bodies){
				b.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);

			time = time + dt;

		}

		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
           	        bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}



	}

}












