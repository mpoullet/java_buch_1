import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
import javax.swing.plaf.TextUI;
public class CustomLookAndFeel extends BasicLookAndFeel {
// Schrift und Farben definieren
   private FontUIResource lucidaHand = new FontUIResource(
     "Lucida HandWriting",Font.PLAIN,12);
   private ColorUIResource white = new ColorUIResource(
     Color.white);
   private ColorUIResource gray = new ColorUIResource(Color.gray);
   private ColorUIResource red = new ColorUIResource(Color.red);
   private ColorUIResource orange = new ColorUIResource(
     Color.orange);
   private ColorUIResource blue = new ColorUIResource(Color.blue);
   private ColorUIResource pink = new ColorUIResource(Color.pink);
// Die User-Interfaces-Klassen (UI-Delegationsklassen) setzen; 
// die f�r JButton und die davon abgeleiteten Klassen wird 
// ausgetauscht und die anderen werden �ber den Aufruf der 
// Methode der Oberklasse initialisiert 
   protected void initClassDefaults(UIDefaults defaults ) {
      super.initClassDefaults(defaults);
      Object[] uiDefaults = {"ButtonUI", "CustomBasicButtonUI"};
      defaults.putDefaults(uiDefaults);
   }
// Die nachfolgenden Methoden aus der Klasse LookAndFeel 
// m�ssen �berschrieben werden damit die Klasse nicht als 
// abstract deklariert werden muss
// Gibt eine Klassen-Id zur�ck
   public String getID() {
      return "Custom";
   }
// Gibt den Namen f�r das LookAndFeel zur�c
   public String getName() {
      return "Custom LookandFeel";
   }
// Gibt eine Beschreibung f�r das LookandFeel zur�ck
   public String getDescription() {
      return "Ein benutzerdefiniertes LookAndFeel";
   }
// Dieses LookAndFeel ist nicht das native-LookAndFeel
   public boolean isNativeLookAndFeel() {
      return false;
   }
// Dieses LookAndFeel wird generell unterst�tzt
   public boolean isSupportedLookAndFeel() {
      return true;
   }
// Externe Defaultwerte f�r Farben und Schrift von Komponenten 
// der UIDefaults-Tabelle hinzuf�gen
   protected void initComponentDefaults(UIDefaults table) { 
      super.initComponentDefaults(table);
      Object[] defaults = {"Button.HighBackground", 
        getHighBackground(), "Button.LowBackground", 
        getLowBackground(), "Button.font", getFont()};
      table.putDefaults(defaults);
      UIManager.getDefaults().put("Button.foreground", blue);
   }
// Eigene Methoden zum Setzen von Schrift und Farbe als Objekte 
// der Klassen FontUIResource und ColorUIResource definieren
   public FontUIResource getFont() {
      return lucidaHand;
   }
   public ColorUIResource getHighBackground() {
      return orange;
   }
   public ColorUIResource getLowBackground() {
      return red;
   }
}
