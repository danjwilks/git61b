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

	}

}












