import javax.swing.*;
import java.util.*;
public class UserEventundListener {
// Static-Member-Klasse f�r den ersten Event
   public static class EventRot extends EventObject {
      String name;
      JComponent component;
      static int zaehler;
// Konstruktordefinition
      public EventRot(JComponent komponente, String name) {
// Die Komponente, welche das Ereignis ausl�st, wird im 
// Konstruktor der Oberklasse angegeben
         super(komponente);
         this.name = name;
         component = komponente;
         zaehler++;
      }
// Zugriffsmethoden der inneren Klasse
      public JComponent getComponent() {
         return component;
      }
      public String getName() {
         return name;
      }
   }
// Static-Member-Klasse f�r den zweiten Event
   public static class EventBlau extends EventObject {
      String name;
      JComponent component;
      static int zaehler;
// Konstruktordefinition
      public EventBlau(JComponent komponente, String name) {
// Die Komponente, welche das Ereignis ausl�st, wird im 
// Konstruktor der Oberklasse angegeben
         super(komponente);
         this.name = name;
         component = komponente;
         zaehler++;
      }
// Zugriffsmethoden der inneren Klasse
      public JComponent getComponent() {
         return component;
      }
      public String getName() {
         return name;
      }
   }
// Static-Member-Interfacess f�r die beiden Listener
   public static interface ListenerRot 
                               extends java.util.EventListener {
      public void selectRot(EventRot e);
   }
   public static interface ListenerBlau 
                               extends java.util.EventListener {
      public void selectBlau(EventBlau e);
   }
}
