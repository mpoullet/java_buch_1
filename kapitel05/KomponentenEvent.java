import java.awt.*;
import java.util.*;
public class KomponentenEvent extends java.util.EventObject {
// Globale Referenzen
   private String name;    
   private Component component;
// Konstruktordefinition
   public KomponentenEvent(Component komponente, String name) {
// Im Konstruktor der Oberklasse wird der Name der Komponente, 
// die das Event erzeugt, angegeben 
      super(komponente);
      this.name = name;
      component = komponente;
   }
// Zugriffsmethoden der Klasse
   public Component getComponent() {
      return component;
   }
   public String getName() {
      return name;
   }
}
