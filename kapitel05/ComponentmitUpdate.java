import java.awt.*;
public class ComponentmitUpdate extends ComponentmitPaint {
// Konstruktordefinition
   public ComponentmitUpdate(Point[] array) {
      super(array);
   }
// Die Methode update() der Klasse Canvas wird �berschrieben
   public void update(Graphics g) {
// Nur f�r die zuletzt im Point-Array gespeicherten 
// Koordinatenwerte wird die Methode paintString() aufgerufen
      paintString(g, letztElem);
   }
}
