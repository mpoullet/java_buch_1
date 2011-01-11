import java.awt.*;
public class VektorenMalen {
   private double x, y, z;
// Konstruktordefinition
   public VektorenMalen(double x, double y, double z) {
      this.x = x;
      this.y = y;
      this.z = z;
   }
// Zugriffsmethoden zum Setzen und Lesen der Komponenten von 
// Vektoren  
   public double getX() {
      return x; 
   }
   public double getY() {
      return y;
   }
   public double getZ() {
      return z;
   }
   public void setX(double x) {
      this.x = x;
   }
   public void setY(double y) {
      this.y = y;
   }
   public void setZ(double z) {
      this.z = z;
   }
// Alle Komponenten einer Instanz der Klasse gleichzeitig 
// abändern
   public void setVektor(double vx, double vy, double vz) { 
      x = vx;   
      y = vy;
      z = vz;
   }
 // Instanzmethode zum Addieren von Vektoren
   public VektorenMalen addVektor(VektorenMalen v) {
      return new VektorenMalen(x + v.x, y + v.y, z + v.z );
   }
// Instanzmethode zur r-Multiplikation eines Vektors mit einer 
// Zahl
   public VektorenMalen multiplVektor(double r) {
      return new VektorenMalen(r*x , r*y, r*z);
   }
// Klassenmethode zum Abbilden eines Punktes (x,y,z) auf (x,y,0) 
   public static VektorenMalen transformVektor(
                               VektorenMalen v, int dx, int dy) {
      double x1, y1, z1;
      x1 = (v.x+(v.y/2))*dx;
      y1 = (-v.z-(v.y/2))*dy;
      z1 = 0;
      return new VektorenMalen(x1, y1, z1);
   } 
// Klassenmethode zum Darstellen von Vektoren 
      public static void malenVektor(int orgx, int orgy,
        VektorenMalen v, VektorenMalen w, Canvas c, 
          boolean koordAchsen, int h, int b) {
// Die Komponenten von w werden für die Anzeige der Koordinaten
// des Endpunktes eines Vektors in Strings umgesetzt 
      String sx = Double.toString(w.x); 
      String sy = Double.toString(w.y); 
      String sz = Double.toString(w.z); 
// Den Abstand für das Berechnen der zugehörigen 
// zweidimensionalen Koordinatenwerten für dreidimensionale 
// Punktkoordinaten bestimmen
      int dx = h/25;
      int dy = b/25;
      v = transformVektor(v,dx,dy);
      w = transformVektor(w,dx,dy);
// Die Koordinatenwerte an die Größe der Canvas anpassen, 
// runden und zu int-Werten konvertieren
      int vx = (int)Math.round(v.x+c.getSize().width/2);
      int vy = (int)Math.round(v.y+c.getSize().height/2);
      int vz = (int)Math.round(v.z);
      int wx = (int)Math.round(w.x+c.getSize().width/2);
      int wy = (int)Math.round(w.y+c.getSize().height/2);
      int wz = (int)Math.round(w.z);
// Den Graphikkontext für die Malfläche ermitteln
      Graphics g = c.getGraphics();
// Ein Vektor wird als Gerade zwischen zwei Punkten dargestellt
      g.drawLine(orgx+vx, orgy+vy, orgx+wx, orgy+wy); 
// Sind es nicht die Koordinatenachsen die gemalt werden sollen
      if(! koordAchsen) {
// wird ein kleiner Kreis zur Punktanzeige gemahlt
         g.drawOval(orgx+wx,orgy+wy,4,4);
// und die Koordinaten des Punktes angeschrieben
         g.drawString("("+sx+" "+sy+" "+sz+")",orgx+wx, orgy+wy);
      }
// ansonsten wird die Bezeichnung von Achsen angeschrieben
      else {
         if(sx.equals("10.0"))
            g.drawString("Ox", orgx+wx+5, orgy+wy+5) ;
         else if(sy.equals("-10.0"))
            g.drawString("Oy", orgx+wx+5, orgy+wy+5) ;
         else if(sz.equals("10.0"))
            g.drawString("Oz", orgx+wx+5, orgy+wy+5) ;
      }
// Freigabe der von g belegten Ressourcen   
      g.dispose(); 
   } 
}
