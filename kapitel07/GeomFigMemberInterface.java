import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
public class GeomFigMemberInterface {
   public Shape shape;
   private int figurenTyp;
// Konstanten definieren, die den Typ der geometrischen 
// Figuren wiedergeben
   private static final int RECTANGLE = 0; 
   private static final int RECTANGLE2D = 1;
   private static final int ELLIPSE2D = 2; 
   private static final int POLYGON = 3; 
// Konstruktordefinition
   GeomFigMemberInterface(int figurenTyp) {
      this.figurenTyp = figurenTyp;
      switch(figurenTyp) {
         case RECTANGLE: {
            shape = new Rectangle(30,30,50,50);
            break;
         }
         case RECTANGLE2D: {
            shape = new Rectangle2D.Float(130,130,50,50);
            break;
         }
         case ELLIPSE2D: { 
            shape = new Ellipse2D.Float(80,80,50,50);
            break;
         }
         case POLYGON: {
            shape = new Polygon(new int[] {100,60,20}, 
              new int[] {150,175,90},3);
            break;
         }
      }
   } 
// Static-Member-Interface 
   public static interface FigMalen {
      public void drawFig(Graphics2D g, 
        GeomFigMemberInterface figur);
   }       
} 
