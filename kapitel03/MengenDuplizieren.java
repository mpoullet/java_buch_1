public class MengenDuplizieren implements Cloneable { 
   private int n;   
   private int[] array;
// Konstruktordefinition
   MengenDuplizieren(int n) {
      this.n = n;
      array = new int[n];
// Initialisieren der Arrayelemente
      for(int i=0; i<n; i++)
         array[i] = i;
   }
// Duplizieren von Objekten mit dem Copy-Konstruktor
   MengenDuplizieren(MengenDuplizieren m) {
// Die Zuweisung von Referenzen und das Kopieren der 
// Arrayelemente reichen nicht aus, um gleiche Array-Objekte zu 
// erzeugen
/*   this.array = m.array;
      for(int i = 0; i<n; i++)
         this.array[i] = m.array[i];  */ 
// Es muss ein neues Array-Objekt erzeugt werden, dessen Elemente
// gleich den Elementen der Instanz sind, auf welche m zeigt.
      n = m.numberOfElem();
      this.array = new int[n];
      for(int i=0; i<n; i++)
         this.array[i] = m.array[i]; 
   }
   public Object clone() throws CloneNotSupportedException {
      MengenDuplizieren kopie = (MengenDuplizieren)super.clone(); 
// Für ein tiefes Klonen muss das Array-Objekt auch dupliziert 
// werden
      kopie.array = (int[])array.clone(); 
      return kopie;
   } 
// Für die Anzeige von Mengen wird die Methode toString() der 
// Klasse Object überschrieben   
   public String toString() {
      String s = "{";
      for(int i=0; i<this.numberOfElem()-1; i++)
// und die Methode toString() der Klasse Integer aufgerufen
         s = s.concat((new Integer(array[i])).toString())+",";
      s = s.concat((new Integer(array[numberOfElem()-1])).
        toString())+"}";
      return s;
   }
// Instanzenmethoden zum Ermitteln der Anzahl von Arrayelementen 
// (Dimension des Array)   
   public int numberOfElem() {
      return array.length; 
   } 
}
