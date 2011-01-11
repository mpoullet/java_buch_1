import java.awt.*;
import javax.swing.*;
public class GenericStack <T> {
// Implementierung eines Stapels für eine einfach verkettete 
// Struktur 
   private Knoten aktuellElem; 
   private T objekt;
// Konstruktordefinition 
   GenericStack() {
      aktuellElem = new Knoten();
   }
// Methode zum Einfügen von Objekten
   public void push(T objekt) {
      Knoten  knoten = new Knoten();
      knoten.vorElem = aktuellElem;
      knoten.objekt = objekt;
      aktuellElem = knoten;
   }
// Methode zum Herausholen von Objekten
   public T pop() {  
      T objekt = aktuellElem.objekt;
      aktuellElem = aktuellElem.vorElem;
      return objekt;
   }
   public static void main(String[] args) {
      JFrame frame = new JFrame();
   // JComboBox-Komponenten erzeugen
      JComboBox list1 = new JComboBox();
      JComboBox list2 = new JComboBox();
// Stacks vom Typ GenericStack<Integer> und GenericStack<String>
// erzeugen
      GenericStack<Integer> stack1 = new GenericStack<Integer>();
      GenericStack<String> stack2 = new GenericStack<String>();
      for(int i=0; i<26; i++) {
         char [] c = new char[1];
// Dem ersten Stack Integer-Objekte hinzufügen 
         stack1.push(new Integer(i));
         c[0] = (char)('A'+i); 
// Dem zweiten Stack String-Objekte hinzufügen 
         stack2.push(new String(c));
      }
// Die im Stack gespeicherten Objekte nacheinander herauslesen 
// und zu den Listen hinzufügen
      for(int i=0; i<26; i++) {
         stack1.objekt = stack1.pop();
         list1.addItem(stack1.objekt);
      }
      for(int i=0; i<26; i++) {
         stack2.objekt = stack2.pop();
         list2.addItem(stack2.objekt);
      }
// Die beiden Listen zu einem Fenster hinzufügen
      frame.add(list1, BorderLayout.WEST);
      frame.add(list2, BorderLayout.EAST);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(50,50);
      frame.setVisible(true);
   }
// Innere Klasse, die ein Element der verketteten Liste definiert
   public class Knoten { 
      T objekt;
      Knoten vorElem;
// Konstruktordefinition
      Knoten() {}
   }
// Innere Schnittstelle, welche die Methoden push() und pop() 
// definiert
   public interface GenInterface <T> { 
      public void push(T objekt);
      public T pop();
   }           
}
