public class NBody {
    /** Reads a file and returns the radius. */
    public static double readRadius(String filename) {
        In in= new In(filename);
        int num_of_planets=in.readInt();
        double radius=in.readDouble();
        return radius;
    }
    public static Planet[] readPlanets(String filename) {
        In in= new In(filename);
        int num_of_planets=in.readInt();
        double radius=in.readDouble();
        Planet[] allplanets=new Planet[num_of_planets];  /**hard one: instantiate class array**/
        for (int i=0;i<num_of_planets;i++) {
            allplanets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return allplanets;
    }
    public static void main(String[] args) {
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);
        Planet[] allplanets=readPlanets(filename);
        StdDraw.setScale(-radius,radius);
        StdDraw.picture(0,0,"images/starfield.jpg");
        for (Planet b:allplanets){
            b.draw();
        }
        StdAudio.play("audio/2001.mid");
        StdDraw.enableDoubleBuffering();
        double time=0;
        while(time<T){
            double[] xForces=new double[allplanets.length];
            double[] yForces=new double[allplanets.length];
            for(int i=0;i<allplanets.length;i++){
                xForces[i]=allplanets[i].calcNetForceExertedByX(allplanets);
                yForces[i]=allplanets[i].calcNetForceExertedByY(allplanets);
            }
            for (int i=0;i<allplanets.length;i++){
                allplanets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for (Planet b:allplanets){
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10); 
            time += dt;  
        }

        /* Prints the final state of the universe. */
        StdOut.printf("%d\n", allplanets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < allplanets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  allplanets[i].xxPos, allplanets[i].yyPos, allplanets[i].xxVel,
                  allplanets[i].yyVel, allplanets[i].mass, allplanets[i].imgFileName);   
        }
    }
}