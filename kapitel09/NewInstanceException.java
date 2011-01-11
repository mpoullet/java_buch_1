import java.lang.reflect.*;
public class NewInstanceException<T> {
// Instanzfeld vom generischen Typ Class<T>
   private Class<T> tClass;
// Konstruktordefinition
   public NewInstanceException(Class<T> tClass) {
      this.tClass = tClass;
   }
// Objekte von Klassen, die einen Konstruktor mit einer Referenz 
// vom Typ String definieren, dynamisch erzeugen
   public T neueInstanz(String string) throws Exception {
      Constructor<T> tConstructor = tClass.getConstructor(
        String.class);
      T instanz = tConstructor.newInstance(string);
      return instanz;
   }
   public static void main(String[] args) throws Exception {
// Eine Instanz der Klasse NewInstanceException vom Typ String
// erzeugen
      NewInstanceException<String> sInstanz = 
        new NewInstanceException<String>(String.class);
// Instanzen der Klasse String dynamisch erzeugen
      System.out.println("String: " 
        + sInstanz.neueInstanz("ABCD"));
      System.out.println("String: " 
        + sInstanz.neueInstanz("1234"));
// Eine Instanz der Klasse NewInstanceException vom Typ Name 
// erzeugen
      NewInstanceException<Name> nInstanz = 
        new NewInstanceException<Name>(Name.class);
// Instanzen der Klasse Name dynamisch erzeugen
      System.out.println("Name: " 
        + nInstanz.neueInstanz("Daniel").toString());
      System.out.println("Name: " 
        + nInstanz.neueInstanz("Diana").toString());
// Eine Instanz der Klasse NewInstanceException vom Typ Integer 
// erzeugen
      NewInstanceException<Integer> iInstanz = 
        new NewInstanceException<Integer>(Integer.class);
// Instanzen der Klasse Integer dynamisch erzeugen
      System.out.println("Integer: " 
        + iInstanz.neueInstanz("1234"));
// Dadurch, das "ABCD" kein konvertierbarer String für den 
// Konstruktor der Klasse Integer ist, werden Ausnahmen vom Typ
// NumberFormatException und InvocationTargetException erzeugt 
      System.out.println("Integer: " 
        + iInstanz.neueInstanz("ABCD"));
   }
}
// Definition der externen Klasse 
class Name { 
   String s;
// Konstruktordefinition
   public Name(String s) {
      this.s = s;
   }
// toString-Methode überschreiben
   public String toString() {
      return s;
   }
} 
