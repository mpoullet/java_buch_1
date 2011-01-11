public class KopievonReferenzTypen implements Cloneable {
   private Zahl z = new Zahl();
   private Wort w = new Wort();
// Die Methode clone() ruft die Methode der Oberklasse Object 
// auf und die der Klasse Zahl (und ggf. der Klasse Wort)
   public  KopievonReferenzTypen clone() 
                              throws CloneNotSupportedException {
      KopievonReferenzTypen kopie = 
        (KopievonReferenzTypen)super.clone();
      kopie.z = z.clone(); 
      return kopie;
   } 
// Durch das Klonen einer Instanz vom Typ der Klasse 
// KopievonReferenzTypen wird ein tiefes Klonen der Instanz vom 
// Typ der Klasse Zahl durchgeführt  
   public static void main(String args[])
                           throws CloneNotSupportedException {
      KopievonReferenzTypen k1 = new KopievonReferenzTypen();
      KopievonReferenzTypen k2 = k1.clone();
// Das Feld z referenziert in verschiedenen Objektreferenzen 
// vom Typ Zahl verschiedene Objekte
      System.out.println("Ein Vergleich der Referenzen von Typ "
        +"Zahl ergibt "+(k1.z == k2.z)); 
// Das Feld w referenziert in jeder Objektreferenz vom Typ Wort
// das gleiche Objekt, wenn dieses nicht geklont wurde
      System.out.println("Ein Vergleich der Referenzen vom Typ "
        +"Wort ergibt "+(k1.w == k2.w));
      System.out.println("Ein Vergleich der Referenzen von Typ "
        +"KopievonReferenzTypen ergibt "+(k1 == k2));
// Ausgabe von Feldwerten
      System.out.println("Ein Vergleich der Feldwerte von Zahl-"
        +"Instanzen ergibt fuer "+k1.z.toString()+" und "
          +k2.z.toString()+" "+(k1.z.zahl == k2.z.zahl)); 
      System.out.println("Ein Vergleich der Feldwerte vom Wort-"
        +"Instanzen ergibt fuer "+k1.w.toString()+" und "
          +k2.w.toString()+" "+(k1.w.wort == k2.w.wort));
   }
}   
