public class WrapperKlassenmitAutoBoxing {
// Globale Referenzen vom Typ der Hüllenklassen   
   private Byte einByte;
   private Character einCharacter;
   private Integer einInteger;
   private Short einShort;
   private Long einLong;
   private Float einFloat;
   private Double einDouble;
   Boolean einBoolean;	
// Konstruktordefinition
   WrapperKlassenmitAutoBoxing(byte by, int i, char c, short s,
                        long l, float f, double d, boolean bo) { 
// Instanzen von Hüllenklassen erzeugen
      einByte = by;
      einCharacter = c;
      einInteger = i;
      einShort = s;
      einLong = l;
      einFloat = f;
      einDouble = d;
      einBoolean = bo;
      }
// Lieferung des Basistyp-Wertes eines Wrapper-Objektes über 
// Unboxing
   public void objectTonumber() {
      System.out.print(" "+einByte);
      System.out.print(" "+einInteger);
      System.out.print(" "+einLong);
      System.out.print(" "+einShort);
      System.out.print(" "+einFloat);
      System.out.print(" "+einDouble);
      System.out.print(" "+einCharacter);
      System.out.print(" "+einBoolean);
      System.out.println();
   }
// Das Autoboxing macht möglich, das der Methodenaufruf über 
// konvert(boolean) erfolgen kann
   public boolean konvert(Boolean b) { 
// Unboxing vom Wrapper-Typ Boolean zum primitiven Typen boolean
      return b;
   }
// Beispiele von Typumwandlungen in einem Ausdruck
   public void rechnen(float zahl1, double zahl2) { 
// Die Werte von primitiven Detentypen werden eingehüllt,  
      Float zahlFloat = zahl1;
      Double zahlDouble = zahl2;
// zum Rechnen entkapselt und als Ergebnis wieder eingehüllt  
      Double ergebnis = zahlFloat*zahlDouble+zahlFloat/
        zahlDouble;
      System.out.println("Wert vor Inkrementieren: "+
        ergebnis);
// Das Wrapper-Objekt ergebnis wird entkapselt, der gewonnene 
// Wert inkrementiert und wieder eingehüllt 
      ergebnis++;
      System.out.println("Wert nach Inkrementieren: "+ergebnis);
      System.out.print(
        "Ausdruck vom Typ Integer in einer for-Schleife ");
      for(Integer i=0; i<=2; i++)
         System.out.print(i+" ");
      System.out.println();
   }
// Unboxing in Kontrollanweisungen
   public void vergleichen(Integer zahl1Integer, 
                           Integer zahl2Integer) {
// Unboxing von Wrapper-Objekten 
      int zahl1 = zahl1Integer;
      int zahl2 = zahl2Integer;
// Vergleich von Referenzen
      if(zahl1Integer == zahl2Integer){
         System.out.print("Gleiche Referenzen");
// Vergleich von primitiven Datentypen
         if(zahl1 == zahl2)
            System.out.println(" und gleiche Werte");
         else
            System.out.println(" und verschiedene Werte");
      }
      else {
         System.out.print("Verschiedene Referenzen");
         if(zahl1 == zahl2)
            System.out.println(" und gleiche Werte");
         else
            System.out.println(" und verschiedene Werte");
      }
   }   
}
