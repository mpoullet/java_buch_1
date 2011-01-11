import java.awt.*;
public class ComponentmitUpdate extends ComponentmitPaint {
// Konstruktordefinition
   public ComponentmitUpdate(Point[] array) {
      super(array);
   }
// Die Methode update() der Klasse Canvas wird überschrieben
   public void update(Graphics g) {
// Nur für die zuletzt im Point-Array gespeicherten 
// Koordinatenwerte wird die Methode paintString() aufgerufen
      paintString(g, letztElem);
   }
}
