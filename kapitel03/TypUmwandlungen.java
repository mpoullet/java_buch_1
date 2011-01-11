import java.math.*;
import java.util.Arrays;
public class TypUmwandlungen {
// Definition von Klassenmethoden 
   public static Number[] add(Number zahl1, Number zahl2) {
      Number[] zahlen = new Number[5];
      zahlen[0] = zahl1.intValue()+zahl2.intValue();
      zahlen[1] = zahl1.floatValue()+zahl2.floatValue();
      zahlen[2] = zahl1.doubleValue()+zahl2.doubleValue();
      zahlen[3] = zahl1.intValue()+zahl2.floatValue();
      zahlen[4] = zahl1.floatValue()+zahl2.doubleValue();
      return zahlen;
   }
   public static void main(String[] args) {
// Im Methodenaufruf von add() werden Referenzen auf Objekte von 
// Unterklassen des Parametertyps übergeben (ein Beispiel 
// für den "impliziten Polymorphismus")
      Number[] zahlen1 = add(new Integer(1), new Integer(2)); 
      System.out.println("Ergebnisse der Addition:"+ 
        Arrays.asList(zahlen1));
      Number[] zahlen2 = add(new Float(-0.56f), new Float(2E-2)); 
      System.out.println("Ergebnisse der Addition:"+ 
        Arrays.asList(zahlen2));
      Number[] zahlen3 =add(new Double(-0.56d), new Double(2E-2)); 
      System.out.println("Ergebnisse der Addition:"+ 
        Arrays.asList(zahlen3));
// Die Klasse BigDecimal gibt dem Benutzer die Möglichkeit, 
// Rundungen für Zahlen vorzunehmen
      Number[] zahlen4 = add((new BigDecimal(-0.56d)).ROUND_DOWN,
        (new BigDecimal(2E-2)).ROUND_DOWN); 
      System.out.println("Ergebnisse der Addition:"+ 
        Arrays.asList(zahlen4));
      Number[] zahlen5 =add((new BigDecimal(-0.56d)).ROUND_FLOOR,
        (new BigDecimal(2E-2)).ROUND_FLOOR); 
      System.out.println("Ergebnisse der Addition:"+ 
        Arrays.asList(zahlen5));
      Number[] zahlen6 = add((new BigDecimal(-0.56d)).
        ROUND_CEILING,(new BigDecimal(2E-2)).ROUND_CEILING); 
      System.out.println("Ergebnisse der Addition:"
        + Arrays.asList(zahlen6));
   }
}
