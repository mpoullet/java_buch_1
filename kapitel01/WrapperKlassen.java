public class WrapperKlassen {
// Globale Referenzen vom Typ der Hüllenklassen
   private Byte einByte;
   private Character einCharacter;
   private Integer einInteger;
   private Short einShort;
   private Long einLong;
   private Float einFloat;
   private Double einDouble;
   private Boolean einBoolean;
// Konstruktordefinition
   WrapperKlassen(byte by, int i, char c, short s, long l, 
                  float f, double d, boolean bo) {
// Objekte der Hüllenklassen erzeugen 
      einByte = new Byte(by);
      einCharacter = new Character(c);
      einInteger = new Integer(i);
      einShort = new Short(s);
      einLong = new Long(l);
      einFloat = new Float(f);
      einDouble = new Double(d);
      einBoolean = new Boolean(bo);
   }
// Umwandlungen in Zahlensysteme mit einer anderen Basis, 
// am Beispiel von int-Werten
   public void konvert(int i) { 
      System.out.println("Der Binaerwert von " + i + " = "+
               Integer.toBinaryString(i));
      System.out.println("Der Octalwert von " + i + " = "+
               Integer.toOctalString(i));
      System.out.println("Der Hexadecimalwert von " + i + " = "+
               Integer.toHexString(i));
   }
// Beispiele von Typumwandlungen mit Methoden von Wrapper-Klassen
   public int charToUnicodeint(char c) { 
// Der Unicode-Wert des Zeichens wird der Variablen i 
// zugewiesen
      int i  =  Character.getNumericValue(c);
      return i;
   }
   public char intTochar(int i) { 
      char c = Character.forDigit(i,10);
      return c;
   }
   public int charToint(char c) { 
      int i  =  Character.digit(c,10);
      return i;
   }
// Liefern des Basistyp-Wertes eines Wrapper-Objektes
   public void objectTonumber() {
      System.out.print(" "+einByte.byteValue());
      System.out.print(" "+einInteger.intValue());
      System.out.print(" "+einLong.longValue());
      System.out.print(" "+einShort.shortValue());
      System.out.print(" "+einFloat.floatValue());
      System.out.print(" "+einDouble.doubleValue());
      System.out.print(" "+einCharacter.charValue());
      System.out.print(" "+einBoolean.booleanValue());
      System.out.println();
   }
// Wrapper-Klassen exportieren auch eine Menge von nützlichen 
// Konstanten, wie z. B. Wertebereiche für primitive Datentypen
   public void werteBereiche() {
      System.out.println("Der Datentyp byte nimmt Werte von "+
        Byte.MIN_VALUE+ " bis "+Byte.MAX_VALUE);
      System.out.println("Der Datentyp int nimmt Werte von "+ 
        Integer.MIN_VALUE+ " bis "+Integer.MAX_VALUE);
   }   
// Einen Beitrag zum sicheren Rechnen mit Wrapper-Klassen liefern 
// deren unendliche Werte
   public void unendlicheWerte() {
      double d1 = Double.MAX_VALUE;
      double dMax = 2*d1;
      double dMin = -1.0/0.0;
      double d = 0.0/0.0;
      System.out.println(dMax+" * "+dMin+" * "+d);
   }   
}
