public class ArraysKlonen {
   public static void main(String args[]) { 
// Definition der Array-Objekte
      String [] zahlen1 = new String[]{"123", "345", "678"};   
      Integer [] zahlen2 = new Integer[]{123, 345, 678};
      Punkt [] punkte = new Punkt[] {new Punkt(1,1), 
        new Punkt(2,2), new Punkt(3,3)};
//  Aufruf der clone()-Methode auf die Array-Objekte
      String[] kopie1 = (String[])zahlen1.clone();
      Integer[] kopie2 = (Integer[])zahlen2.clone();
      Punkt[] kopie3 = (Punkt[])punkte.clone();
      System.out.println("Vergleich der Referenzen auf die Array"
        +"-Objekte: "+(kopie1 == zahlen1)+" * "+
          (kopie2 == zahlen2)+" * "+(kopie3 == punkte));
      for(int i= 0; i<3; i++) {
         System.out.println("Vergleich der Referenzen der "
           +"Elemente auf Position "+i+" : "+(kopie1[i] == 
             zahlen1[i])+" * "+(kopie2[i] == zahlen2[i])+
               " * "+(kopie3[i] == punkte[i]));
      }
   }
}   
