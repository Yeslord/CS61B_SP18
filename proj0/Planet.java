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
}