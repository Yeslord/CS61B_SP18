public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	private static final double g=6.67E-11;
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img)
	{
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}
	public Planet(Planet P)
	{
		xxPos = P.xxPos;
        yyPos = P.yyPos;
        xxVel = P.xxVel;
        yyVel = P.yyVel;
        mass = P.mass;
        imgFileName = P.imgFileName;
	}
	public double calcDistance(Planet P)
	{
		double dx=P.xxPos-xxPos;
		double dy=P.yyPos-yyPos;
		return Math.sqrt(dx*dx+dy*dy);
	}
	public double calcForceExertedBy(Planet P) {
		double r = calcDistance(P);
		return g * mass * P.mass / (r * r);
	}
	public double calcForceExertedByX(Planet P) {
		double f = calcForceExertedBy(P);
		return f*(P.xxPos-xxPos)/calcDistance(P);
	}
	public double calcForceExertedByY(Planet P) {
		double f = calcForceExertedBy(P);
		return f*(P.yyPos-yyPos)/calcDistance(P);
	}
	public double calcNetForceExertedByX(Planet[] Ps) {
		double sum=0;
		for (Planet P:Ps){
			if (this.equals(P)) {
				continue;
			}
			sum += calcForceExertedByX(P);
		}
		return sum;
	}
	public double calcNetForceExertedByY(Planet[] Ps) {
		double sum=0;
		for (Planet P:Ps){
			if (this.equals(P)) {
				continue;
			}
			sum += calcForceExertedByY(P);
		}
		return sum;
	}
	public void update(double dt,double fx,double fy) {
		xxVel+=dt*fx/mass;
		yyVel+=dt*fy/mass;
		xxPos+=dt*xxVel;
		yyPos+=dt*yyVel;
	}
	public void draw(){
		StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
	}
}