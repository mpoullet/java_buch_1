public class WrapperKlassenmitAutoBoxingTest {
   public static void main(String args[]) {
// Objekt der Klasse erzeugen
      WrapperKlassenmitAutoBoxing wrapper = 
        new WrapperKlassenmitAutoBoxing 
          ((byte)1, 2,'3',(short)4,(long)5,(float)1.0,2.0,true);
      System.out.print("Basistypwerte der Wrapper-Objekte:");
// und ihre Methoden aufrufen
      wrapper.objectTonumber();
      System.out.print("Auto(un)boxing in Methoden-aufrufen und "
        + "-rueckgaben: "); 
      System.out.println(wrapper.konvert(true)); 
      System.out.println("Typumwandlungen in einem Ausdruck:"); 
      wrapper.rechnen(1, 2.0);
      System.out.println("Unboxing in Kontrollanweisungen:");
      wrapper.vergleichen(1, 2);
      wrapper.vergleichen(new Integer(1), new Integer(1));
      Integer zahl1 = new Integer(1);
      Integer zahl2 = zahl1;
      wrapper.vergleichen(zahl1,zahl2); 
   }
}
