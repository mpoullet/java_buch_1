import java.lang.reflect.*;
public class GenericClassmitGenericArray<T> {
// Instanzfeld vom generischen Typ Class<T>
   private Class<T> tClass;
// Die Methode erzeugt ein generisches Array 
   public <T> T[] returnArray() {
      return (T[])java.lang.reflect.Array.newInstance(tClass,10);
   }
// Konstruktordefinition
   public GenericClassmitGenericArray(Class<T> tClass) {
      this.tClass = tClass;
   }
// Die von den Methoden der Klassen Class und Field 
// ausgelösten Exceptions werden von der main()-Methode 
// über die throws-Klausel an die JVM weitergereicht.
   public static void main(String[] args)throws Exception {
// Instanzen dieser Klasse vom Typ der Klassen Integer und 
// Produkt erzeugen
      GenericClassmitGenericArray<Integer> iClass = 
        new GenericClassmitGenericArray<Integer>(Integer.class);
      GenericClassmitGenericArray<Produkt> pClass = 
        new GenericClassmitGenericArray<Produkt>(Produkt.class);
// Arrays vom Typ dieser Klassen generieren
      Integer[] integer = iClass.returnArray();
      Produkt[] produkt = pClass.returnArray();
// Auf Felder der Klassen zugreifen und deren Werte ausgeben 
      for(int i=0; i<2; i++) {
         produkt[i] = new Produkt();
         integer[i] = new Integer(i);
         Field f1 = produkt[i].getClass().getDeclaredField(
           "name");
         Field f2 = integer[i].getClass().getDeclaredField(
           "MAX_VALUE");
         Field f3 = integer[i].getClass().getDeclaredField(
           "MIN_VALUE");
         System.out.println(produkt[i].getClass().getName()
           + ":" + f1.get(produkt[i]) + i);
         System.out.println(integer[i].getClass().getName()
           + ":" + " MAX_VALUE = " + f2.get(integer[i]) 
             + " MIN_VALUE = " + f3.get(integer[i]));
      }
   }
}
// Die Klasse Produkt
class Produkt {
   public String name = "Buch";
}
