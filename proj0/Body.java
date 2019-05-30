public class Body{

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	/** creates a body */
	public Body(double xP, double yP, double xV,
					double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img; 
	}

	/** creates identical body */
	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
	}

	/** calculates the distance between two bodies */
	public double calcDistance(Body b){
		double xdis = this.xxPos - b.xxPos;
		double ydis = this.yyPos - b.yyPos;
		double rsqred = Math.pow(xdis, 2) + Math.pow(ydis, 2);
		double r = Math.sqrt(rsqred);
		return r;	
	}

	public double calcForceExertedBy(Body b){
		return this.calcForceExertedByX(b) + this.calcForceExertedByY(b);
	}

	/** calculates force exerted by input body in
	x direction*/
	public double calcForceExertedByX(Body b){

		double g = 6.67 * Math.pow(10,-11);
		double xdis = b.xxPos - this.xxPos;
		double r = this.calcDistance(b);

		double f = (g * this.mass * b.mass)/Math.pow(r,2);
		double fx = f * xdis / r;
		return fx;
	}

	/** calculates force exerted by input body in
	x direction*/
	public double calcForceExertedByY(Body b){
		double g = 6.67 * Math.pow(10,-11);
		double ydis = b.yyPos - this.yyPos;
		double r = this.calcDistance(b);

		double f = (g * this.mass * b.mass)/Math.pow(r,2);
		double fy = f * ydis / r;
		return fy;
	}

	public double calcNetForceExertedByX(Body[] allBodies){

		double netForce = 0;
		for (Body b : allBodies){
			if (this.equals(b)){}
			else{
				netForce = netForce + this.calcForceExertedByX(b);
			}
		}
		return netForce;

	}

	public double calcNetForceExertedByY(Body[] allBodies){

		double netForce = 0;
		for (Body b : allBodies){
			if (this.equals(b)){}
			else{
				netForce = netForce + this.calcForceExertedByY(b);
			}
		}
		return netForce;

	}

	public void update(double dt,double fX, double fY){
		double accX = fX / this.mass;
		double accY = fY / this.mass;

		double newVelX = this.xxVel + dt*accX;
		double newVelY = this.yyVel + dt*accY;

		double newPosX = this.xxPos + dt*newVelX;
		double newPosY = this.yyPos + dt*newVelY;

		this.xxVel = newVelX;
		this.xxPos = newPosX;
		this.yyVel = newVelY;
		this.yyPos = newPosY;
	}

	public void draw(){

		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}

	// public static void main(String[] args){
	// 	Body samh = new Body(1, 0, 0, 0, 10, " ");
	// 	Body roc = new Body(5, -3, 0, 0, 50, " ");

	// 	double output = samh.calcForceExertedByX(roc);
	// 	System.out.println(output);
	// }







}