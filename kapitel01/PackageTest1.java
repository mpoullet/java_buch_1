import paket1.Klasse1;
//import paket2.Klasse2; // Fehler
import paket1.paket2.Klasse2; 
class PackageTest1 {
   public static void main(String args[]) {
      Klasse1 kls1 = new Klasse1();
      Klasse2 kls2 = new Klasse2();
// Compilerfehler:
// Das Feld aus paket1.Klasse1 verf�gt �ber privaten Zugriff 
   //   System.out.println(Klasse1.privatesFeld);
// Das Feld aus paket1.Klasse1 verf�gt �ber geschuetzten Zugriff 
   //   System.out.println(Klasse1.geschuetztesFeld);
// Das Feld feld aus paket1.Klasse1 besitzt keinen Modifikator 
// und darauf kann nicht von au�erhalb des Paketes zugegriffen 
// werden 
   //   System.out.println(Klasse1.feld);
// Zugriff erlaubt, weil uneingeschr�nkt �ffentlich durch die 
// Definition mit public
      System.out.println(Klasse1.oeffentlichesFeld);
   }
} 
