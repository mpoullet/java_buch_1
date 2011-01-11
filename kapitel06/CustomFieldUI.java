import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
public class CustomFieldUI extends BasicTextFieldUI {
// Eine unveränderbare Instanz der Klasse erzeugen
   private final static CustomFieldUI fieldUI = 
     new CustomFieldUI();
// Eine unveränderbare Instanz der Klasse CompoundBorder erzeugen
   private final static Border compoundBorder = 
     new CompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5),
       BorderFactory.createLineBorder(Color.gray));
// Werte für Farbe und Schrift als Objekte der Klassen Color und 
// Font vom Programm aus setzen
   private static Color defaultColor = UIManager.getColor(
     "Field.foreground");
   private static Font defaultFont = UIManager.getFont(
     "Field.font");
// Die Methoden der Klasse BasicTextFieldUI überschreiben
   public static ComponentUI createUI(JComponent c) {
      return fieldUI;
   }
// Das Setzen von Eigenschaften für Komponenten erfolgt in der 
// Methode installDefaults()
   public void installUI(JComponent c) {
      super.installUI(c);
   }
   public void uninstallUI(JComponent c) {
      super.uninstallUI(c);
   }
// Mit getComponent() wird die Komponente, welche einer Instanz 
// der UI-Delegationsklasse zugeordnet wird, geholt
   public void installDefaults() {
      getComponent().setCaret(new CustomCaret());
      getComponent().setCaretColor(Color.pink);
      getComponent().setFont(defaultFont);
      getComponent().setBorder(compoundBorder); 
      getComponent().setForeground(defaultColor);
   }
}
