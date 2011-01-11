import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
public class CustomFieldLookAndFeel extends BasicLookAndFeel {
// Werte für Schrift und Farben als Objekte der Klassen 
// FontUIResource und ColorUIResource definieren, um zu 
// unterstreichen, dass diese von der LookAndFeel-Komponente 
// gesetzt werden
   private FontUIResource lucidaHand = new FontUIResource(
     "Lucida HandWriting", Font.PLAIN, 12);
   private ColorUIResource red = new ColorUIResource(Color.red);
// Die abstrakten Methoden der Klasse LookAndFeel implementieren
// Gibt eine Klassen-Id zurück
   public String getID() {
      return "CustomField";
   }
// Gibt den Namen für das LookAndFeel zurück
   public String getName() {
      return "CustomField-LookAndFeel";
   }
// Gibt eine Beschreibung für das LookAndFeel zurück
   public String getDescription() {
      return "Ein benutzerdefiniertes LookAndFeel";
   }
// Dieses LookAndFeel ist nicht das native-LookAndFeel
   public boolean isNativeLookAndFeel() {
      return false;
   }
// Dieses LookAndFeel wird standardmäßig unterstützt
   public boolean isSupportedLookAndFeel() {
      return true;
   }
// Externe Defaultwerte für Farben und Schrift von Komponenten 
// zur UIDefaults-Tabelle hinzufügen
   protected void initComponentDefaults(UIDefaults table) { 
      super.initComponentDefaults(table);
      Object[] defaults = {"Field.foreground", getForeground(),
         "Field.font", getFont()};
      table.putDefaults(defaults);
   }
// Eigene Methoden zum Setzen von Schrift und Farbe definieren
   public FontUIResource getFont() {
      return lucidaHand;
   }
   public ColorUIResource getForeground() {
      return red; 
   }
} 
