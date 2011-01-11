import java.util.*;
public class GenericStackfuerInversWort <T> 
                                 implements StackInterface <T> {
// Implementierung eines Stapels für eine einfach verkettete 
// Struktur; ein Element des Stapels vom Typ der Klasse 
// LinkObjekt<T> definieren 
   private LinkObjekt<T> kopf; 
   private int anzahl;
// Konstruktordefinition
   GenericStackfuerInversWort() {
      kopf = null;
      anzahl = 0;
   }
// Methoden des externen Interface implementieren
   public int size() {
      return anzahl;
   }
   public boolean isEmpty() {
      if(kopf == null)
         return true;
      else 
         return false;
   }
   public boolean isFull() {
      if(size() == 5)
         return true;
      else 
         return false;
   }
   public void push(T objekt) { 
      if(isFull()) throw new FullStackException(
        "Der Stapel ist voll");
      LinkObjekt<T> knoten = new LinkObjekt<T>();
      knoten.setNext(kopf);
      knoten.setT(objekt);
      kopf = knoten;
      anzahl++;
   }
   public T pop() { 
      if(isEmpty()) throw new EmptyStackException ();
      T objekt = kopf.getT();
      kopf = kopf.getNext();
      anzahl--;
      return objekt;
   }
// Static-Member-Klasse, welche ein Element der verketteten
// Liste definiert
   public static class LinkObjekt <T> 
                                  implements LinkInterface <T> {
      LinkObjekt<T> next;
      T objekt;
// Die Methoden der inneren Schnittstelle implementieren
      public T getT() {
         return objekt;
      }
      public void setT(T objekt) {
         this.objekt = objekt;
      }
      public void setNext(LinkObjekt<T> linkObjekt) {
          next = linkObjekt;
      }
      public LinkObjekt<T> getNext() { 
         return next;
      } 
   } 
// Definition der inneren Schnittstelle, die von der inneren 
// Klasse implementiert wird
   public interface LinkInterface <T> { 
// Zugriffsmethoden zum Lesen und Setzen von Werten für die 
// Instanzfelder der Klasse 
      public T getT();
      public void setT(T objekt);
      public void setNext(LinkObjekt<T> linkObjekt);
      public LinkObjekt<T> getNext();
   } 
}
// Definition der externen Schnittstelle, die von der umgebenden 
// Klasse implementiert wird
interface StackInterface <T> {
// Der Stack ist leer
   public boolean isEmpty();
// Der Stack ist voll
   public boolean isFull(); 
// Ein Element einfügen
   public void push(T objekt);
// Ein Element herauslesen  
     public T pop(); 
}

