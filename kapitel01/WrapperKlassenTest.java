public class WrapperKlassenTest {
   public static void main(String args[]) {
      WrapperKlassen wrapper = new WrapperKlassen((byte)1, 2,'3',
        (short)4,(long)5,(float)1.0,2.0,true);
      System.out.print("Basistypwerte der Wrapper-Objekte: ");
      wrapper.objectTonumber();
      System.out.println(
       "Umwandlungen in Zahlensysteme mit einer anderen Basis:"); 
      wrapper.konvert(100); 
      System.out.print("Typumwandlungen: "); 
      System.out.print(" "+wrapper.charToUnicodeint('3'));
      System.out.print(" "+wrapper.charToint('3'));
      System.out.print(" "+wrapper.intTochar(3));
      System.out.println();
      wrapper.werteBereiche();
      wrapper.unendlicheWerte();
   }
} 
