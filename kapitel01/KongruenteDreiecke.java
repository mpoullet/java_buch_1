class KongruenteDreiecke {
   private double x;
   private double y;
   private double z;
   private static final double PI = 3.14159;
 // Konstruktordefinition
   public KongruenteDreiecke (double x, double y, double z) {
      this.x = x;
      this.y = y;
      this.z = z;
       }
// Zugriffsmethoden   
   public double getX() {
      return x;
   }
   public double getY() {
      return y;
   }
   public double getZ() {
      return z;
   }
   public double setX(double a) { 
      return x = a;
   }
   public double setY(double b) {
      return y = b;
   }
   public double setZ(double c) { 
      return z  = c;
   }
   public static double winkelRadian (double winkelGrad) {
      return winkelGrad*PI/180;
   }
   public static double winkelGrad (double winkelRadian) {
      return winkelRadian*180/PI;
   }
   public KongruenteDreiecke sss() {
      double w1 = Math.round(winkelGrad(Math.acos((x*x-y*y-z*z)/
        (-2*y*z))));
      double w2 = Math.round(winkelGrad(Math.acos((y*y-x*x-z*z)/
        (-2*x*z))));
      double w3 = Math.round(winkelGrad(Math.acos((z*z-x*x-y*y)/
        (-2*x*y))));
      return new KongruenteDreiecke(w1,w2,w3);
   }
   public KongruenteDreiecke sws() {
      double s = Math.round(Math.sqrt(x*x+z*z-2*x*z*Math.cos(
        winkelRadian(y))));
      double w1 = Math.round(winkelGrad(Math.acos((x*x-z*z-s*s)/
        (-2*z*s))));
      double w2 = Math.round(winkelGrad(Math.acos((z*z-x*x-s*s)/
        (-2*x*s))));
      return new KongruenteDreiecke(w1,s,w2);
   }
   public KongruenteDreiecke wsw() {
      double w = 180-x-z;
      double s1 = Math.round(y*Math.sin(winkelRadian(x))/
        Math.sin(winkelRadian(w)));
      double s2 = Math.round(y*Math.sin(winkelRadian(z))/
        Math.sin(winkelRadian(w)));
      return new KongruenteDreiecke(s1,w,s2);
   }
   public KongruenteDreiecke ssw() {
      double w1 = Math.round(winkelGrad(Math.asin(
        x*Math.sin(winkelRadian(z))/y)));
      double w2 = 180-z-w1;
      double s = Math.round(y*Math.sin(winkelRadian(w2))/
        Math.sin(winkelRadian(z)));
      return new KongruenteDreiecke(w1,w2,s);
   }
}

