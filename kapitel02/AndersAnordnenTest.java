public class AndersAnordnenTest {
   public static void main(String args[]) {
// Erzeugen eines Permutationen-Objektes 
      Permutationen p = new Permutationen(4);
// und die Methode der Klasse aufrufen 
      int perm = p.anordnen();
// Anzeige der Anzahl von Permutationen
   System.out.println("Mit "+p.getN()+" verschiedenen Zeichen "
     +"koennen "+perm+" Permutationen gebildet werden");
// Erzeugen eines VariationenhabenPermutationen-Objektes mit der 
// Übergabe von Referenzen auf Permutationen-Objekte
   VariationenhabenPermutationen v = 
     new VariationenhabenPermutationen(
       new Permutationen(4), new Permutationen(2));
   int var = v.anordnen(); 
// Anzeige der Anzahl von Variationen 
   System.out.println("Mit "+v.getP1().getN()+" verschiedenen "
     +"Zeichen koennen "+var+" "+ v.getP2().getN()+
       "-stellige Variationen gebildet werden");
// Erzeugen eines KombinationenhabenPermutationen-Objektes mit
// der Übergabe von Referenzen auf Permutationen-Objekte
   KombinationenhabenPermutationen k = new 
     KombinationenhabenPermutationen(new Permutationen(5),
       new Permutationen(2), new Permutationen(3));
   int komb = k.anordnen(); 
// Anzeige der Anzahl von Kombinationen 
    System.out.println("Mit "+k.getP1().getN()+" verschiedenen "
      +"Zeichen koennen "+komb+" "+k.getP3().getN()+
        "-stellige Kombinationen gebildet werden");
   }
}
