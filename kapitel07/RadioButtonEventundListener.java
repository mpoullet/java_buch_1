import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.util.*;
public class RadioButtonEventundListener extends JRadioButton {
// Globale Referenz vom Typ RadioButtonListener
   private RadioButtonListener listener;
// Globale String-Referenz
   private String eventTyp;
// Konstantendefinitionen für Eventtypen
   private static final String ACTION_EVENT = "ACTION"; 
   private static final String CHANGE_EVENT = "CHANGE"; 
   private static final String ITEM_EVENT = "ITEM";
// Konstruktordefinition 
   public RadioButtonEventundListener(String name) {
      super(name);
// Interne Event-Listener für das aktuelle Objekt der Klasse 
// registrieren und mittels anonymer Klassen implementieren; beim 
// Empfangen eines internen Event wird die Methode erzeugeEvent()
// am aktuellen Objekt der Klasse aufgerufen, um eine 
// benutzerdefinierte RadioButtonEvent-Komponente zu erzeugen
      addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e) {
            RadioButtonEventundListener.this.
              erzeugeEvent(CHANGE_EVENT);  
         }
      }); 
      addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            RadioButtonEventundListener.this.
              erzeugeEvent(ACTION_EVENT);  
         }
          });
      addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            RadioButtonEventundListener.this.
              erzeugeEvent(ITEM_EVENT);
         }
      });
   }
// Zugriffsmethoden für die Instanzfelder der umgebenden Klasse
   public String geteventTyp() {
      return eventTyp;
   }
   public void seteventTyp(String eventTyp) {
      this.eventTyp = eventTyp;
   }
// Methode für das Registrieren von RadioButtonListener
   public void addRadioButtonListener(
     RadioButtonEventundListener.RadioButtonListener l) {
      listener = l;
   } 
// Ein RadioButtonEvent-Objekt erzeugen
   public void erzeugeEvent(String eventTyp) {
      this.eventTyp = eventTyp;  
      RadioButtonEventundListener.RadioButtonEvent ke =
        new RadioButtonEventundListener.
          RadioButtonEvent(this, eventTyp);
// und den RadioButtonListener benachrichtigen
      listener.eventErzeugt(ke); 
   } 
// Definition von inneren Klassen und Interfaces
// Innere Klasse, die den RadioButtonEvent-Typ definiert. 
// Erzeuger des Events ist hier die Klasse selbst, darum wird sie
// als Argument im Konstruktoraufruf übergeben 
   public static class RadioButtonEvent extends EventObject {
// Standard Eventtyp, welcher umgesetzt werden soll  
      String typ;  
// Konstruktordefinition 
      public RadioButtonEvent(RadioButtonEventundListener rbel,
        String typ) {
         super(rbel);
         this.typ = typ;
      }
// Zugriffsmethoden der inneren Klasse
      public RadioButtonEventundListener 
        getRadioButtonEventundListener () { 
         return (RadioButtonEventundListener)getSource();
      }
      public String getTyp() {
        return typ;
      }
   }
// Static-Member-Interface 
   public static interface RadioButtonListener 
                                         extends EventListener {
      public void eventErzeugt(RadioButtonEventundListener.
        RadioButtonEvent e);
   }
}
