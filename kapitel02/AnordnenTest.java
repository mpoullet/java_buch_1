public class AnordnenTest {
   public static void main(String args[]) {
// Erzeugen eines Permutationen-Objektes  
      Permutationen p = new Permutationen(4);
// Aufruf der Methode der Oberklasse 
      int perm = p.anordnen(); 
// und deren Zugriffsmethode an dieser Instanz
      System.out.println("Mit " +p.getN()+ " verschiedenen Zei"
        +"chen koennen "+perm+" Permutationen gebildet werden");
// Vergrößernde Konvertierung, für die nachfolgende Zuweisung 
// ist kein Casting nötig
      Permutationen p1 = new Variationen(4,2);
// An dem so erzeugten Objekt die Methode der Unterklasse 
// Variationen aufrufen (dynamisches Binden von Methoden)      
      int var1 = p1.anordnen(); 
// Da der Wert, auf welchen die Referenzvariable p1 zeigt, ein 
// gültiges Variationen-Objekt bleibt, kann eine verkleinernde 
// Konvertierung erfolgen, welche ein Casting erforderlich macht
      Variationen v1 = (Variationen)p1;
// Auch nachfolgend wird die Methode der Unterklasse aufgerufen 
      int var = v1.anordnen(); 
// Aufruf der Zugriffsmethoden am Variationen-Objekt      
      System.out.println("Mit "+v1.getN()+" verschiedenen "
        +"Zeichen koennen "+var+" "+v1.getK()+
          "-stellige Variationen gebildet werden");
// Erzeugen eines Kombinationen-Objektes
      Kombinationen k = new Kombinationen(5,3);
// Die Methode der Unterklasse wird aufgerufen 
      int komb = k.anordnen(); 
// Aufruf der Zugriffsmethoden am Kombinationen-Objekt      
      System.out.println("Mit "+k.getN()+" verschiedenen "
        +"Zeichen koennen "+komb+" "+k.getK()+
          "-stellige Kombinationen gebildet werden");
// Erzeugen eines KombinationenausVariationen-Objektes 
      KombinationenausVariationen kv = 
        new KombinationenausVariationen(5,3);
// Die Methode der Unterklasse wird aufgerufen 
      int kombvar = kv.anordnen(); 
// Aufruf der Zugriffsmethoden an der 
// KombinationenausVariationen-Instanz      
      System.out.println("Mit "+kv.getN()+" verschiedenen "
        +"Zeichen koennen "+kombvar+" "+kv.getK()+
          "-stellige Kombinationen gebildet werden");
   }
}   
