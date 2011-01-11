import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.*;
public class CustomAreaUI extends BasicTextAreaUI {
// Eine unveränderbare Instanz der Klasse erzeugen
     private final static CustomAreaUI AreaUI = 
       new CustomAreaUI();
// Werte für Farbe und Schrift als Objekte der Klassen Color 
// und Font vom Programm aus für die Komponente setzen
   private static Color defaultColor = Color.green;
   private static Font defaultFont = new Font(
     "Lucida HandWriting", Font.PLAIN, 14);
// Den Cursor setzen
   private CustomCaret caret = new CustomCaret();
// Die Methoden von BasicTextAreaUI überschreiben   
   public static ComponentUI createUI(JComponent c) {
      return AreaUI;
   }
// Das Setzen von Eigenschaften für die Komponente erfolgt 
// in dieser Klasse in der Methode installDefaults()
   public void installUI(JComponent c) {
      super.installUI(c);
   }
   public void uninstallUI(JComponent c) {
      super.uninstallUI(c);
   }
// Mit getComponent() wird die Komponente, welche dem aktuellen
// Objekt dieser UI-Delegationsklasse zugeordnet wird, geholt
   public void installDefaults() {
      getComponent().setCaret(caret);
      getComponent().setCaretColor(Color.red);
      getComponent().setFont(defaultFont);
      getComponent().setForeground(defaultColor);
   }
}
