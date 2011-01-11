public class Menge implements Services {
// Array für das Speichern der Elemente einer Menge
   private int[] element;
// Dimension des Array  
   private int dimension;
// Zaehler für Mengenelemente 
   private int anzahl;
// Konstruktordefinition
   Menge(int dimension) {
      this.dimension = dimension;
      element = new int[dimension];
      anzahl = 0;
   }
// Die Methoden der Schnittstelle implementieren
   public int numberOfElem() {
      return anzahl; 
   } 
   public int isElem(int value) {
      int index = 0;
      for(int i=0; i<dimension; i++) {
         if(element[i] == value) {
            index = i;
            break;
         }
         else {
            index = -1;
         }
      }
      return index;
   } 
   public boolean addElem(int value) {
      if((this.isElem(value))!= -1) {
         return false;
      }
      else {
         element[anzahl] = value;
         anzahl++;
         return true;
      }
   }
// Die Methode der Klasse Object wird überschrieben
   public String toString() {
      String s = "{";
      for(int i=0; i<this.numberOfElem()-1; i++)
         s = s.concat((new Integer(element[i])).toString())+",";
      s = s.concat((new Integer(element[numberOfElem()-1])).
        toString())+"}";
      return s;
   }
// Instanzmethoden für Operationen mit Mengen
   public Menge vereinigung(Menge m) {
      Menge menge = new Menge(this.numberOfElem() + 
        m.numberOfElem());
// Die Elemente der 1.Menge hinzufügen 
      for(int i=0; i<this.numberOfElem(); i++)
         menge.addElem(this.element[i]);
// Die Elemente der 2.Menge hinzufügen
      for(int i=0; i<m.numberOfElem(); i++)
         menge.addElem(m.element[i]);
      return menge;
   }
   public Menge durchschnitt(Menge m) {
      Menge menge = new Menge(this.numberOfElem());
// Ist ein Elemment aus der 1. Menge auch in der 2. enthalten, 
// wird dieses der ersten Menge hinzugefügt
      for(int i=0; i<this.numberOfElem(); i++) {
         if(m.isElem(this.element[i])!= -1){
            menge.addElem(this.element[i]);
         }
      }   
      return menge;
   }
}

