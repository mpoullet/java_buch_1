import javax.swing.plaf.basic.*;
import javax.swing.plaf.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
public class MyLookAndFeel extends BasicLookAndFeel {
// Die nachfolgenden abstrakten Methoden der Klasse LookAndFeel 
// müssen überschrieben werden, weil die Klasse nicht als 
// abstrakt deklariert wird
// Gibt den Namen für das LookAndFeel zurück
   public String getName() {
      return "My";
   }
// Gibt eine Klassen-Id zurück
   public String getID() {
      return "My Look and Feel";
   }
// Gibt eine Beschreibung für das LookAndFeel zurück
   public String getDescription() {
      return "Ein benutzerdefiniertes Look and Feel";
   }
// Dieses LookAndFeel ist nicht das native-LookAndFeel
   public boolean isNativeLookAndFeel() {
      return false;
   }
// Dieses LookAndFeel wird standardmäßig unterstützt
   public boolean isSupportedLookAndFeel() {
      return true; 
   }
// Initialisieren von Klassen-Eigenschaften: den Namen der 
// UI-Delegationsklasse für JButton- und JSlider-Komponeten 
// zuweisen
   protected void initClassDefaults(UIDefaults table) {
      super.initClassDefaults(table);
      Object[] uiDefaults = {
// Die UIDefaults-Tabelle kann hiermit um einen Eintrag
// erweitert werden
//   "ButtonUI", "MyStdButtonUI",    // korrekt
// Dieser Eintrag ist nicht erforderlich, weil er dem
// Standard-Eintrag entspricht 
         "SliderUI", "javax.swing.plaf.basic.BasicSliderUI",
      };
      table.putDefaults(uiDefaults);
// Für JButton-Komponenten nutzen wir eine andere Art, die 
// Defaults hinzuzufügen; die Methode forName() der Klasse 
// Class wirft mehrere Exceptions die abgefangen werden müssen     
      try {
         String className ="MyStdButtonUI";
         Class buttonClass = Class.forName(className);
         table.put("ButtonUI", className);
         table.put(className, buttonClass);
      }
      catch(Exception e) {
         e.printStackTrace();
      }
   }
// Initialisieren von Komponenten-Eigenchaften
   protected void initComponentDefaults(UIDefaults table) {
      super.initComponentDefaults(table);
// Neue Farben und Schriftarten als Objekte von Klassen, welche 
// das Interface UIRessource implementieren, definieren 
      ColorUIResource pink = new ColorUIResource(Color.pink);
      ColorUIResource white = new ColorUIResource(Color.white);
// Setzen eines benutzerdefinierten Borders für einen Buttons mit
// einer Instanz der Klasse CustomBorder
      Object buttonBorder = new BorderUIResource(
        new CustomBorder());
// Für ein JSlider-Objekt einen neuen Rand definieren
      Object sliderBorder = new 
      BorderUIResource.LineBorderUIResource(Color.red, 2);
//Die neuen Eigenschaftswerte für Komponenten in die 
// UIDefaults-Tabelle einfügen
      Object[] defaults = {
         "Button.border", buttonBorder,
         "Button.background", pink,
         "Button.foreground", white,
         "Button.focus", white,
         "Button.pressed", white,
         "Slider.foreground", white,
         "Slider.background", pink,
         "Slider.border", sliderBorder
      };
      table.putDefaults(defaults);
   }
}
