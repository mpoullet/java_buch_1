public class GenericClass<T> {
// Instanzfeld vom generischen Typ Class<T> 
   private Class<T> tClass;
// Konstruktordefinition
   public GenericClass(Class<T> tClass) {
      this.tClass = tClass;
   }
// Die von der Methode newInstance() ausgelösten Exceptions 
// werden über die throws-Klausel an die aufrufende Methode 
// weitergereicht
   public T neuesProdukt() throws Exception {
      return tClass.newInstance();
   }
// Die von der Methode neuesProdukt() ausgelösten Exceptions 
// werden von der main()-Methode über die throws-Klausel 
// an die JVM weitergereicht
   public static void main(String[] args) throws Exception {
// Instanzen der Klasse GenericClass vom Typ der Klassen 
// SchreibProdukt und LeseProdukt erzeugen
      GenericClass<SchreibProdukt> genClass1 = 
        new GenericClass<SchreibProdukt>(SchreibProdukt.class);
      GenericClass<LeseProdukt> genClass2 = 
        new GenericClass<LeseProdukt>(LeseProdukt.class);
// Instanzen der Klassen SchreibProdukt und LeseProdukt dynamisch
// erzeugen
      SchreibProdukt schreibProdukt1 = genClass1.neuesProdukt();
      System.out.println("Produkt: " + schreibProdukt1.getName() 
        + SchreibProdukt.zaehler);
      SchreibProdukt schreibProdukt2 = genClass1.neuesProdukt();
      System.out.println("Produkt: " + schreibProdukt2.getName()
        + SchreibProdukt.zaehler);
      LeseProdukt leseProdukt1 = genClass2.neuesProdukt();
      System.out.println("Produkt: " + leseProdukt1.getName() 
        + LeseProdukt.zaehler);
      LeseProdukt leseProdukt2 = genClass2.neuesProdukt();
      System.out.println("Produkt: " + leseProdukt2.getName() 
        + LeseProdukt.zaehler);
   }
}
// Die Klasse SchreibProdukt
class SchreibProdukt {
   private String name = "Bleistift";
   public static int zaehler;
// Konstruktordefinition
   public SchreibProdukt() {
      zaehler++;
   }
// Zugriffsmethoden
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
}
// Die Klasse LeseProdukt
class LeseProdukt {
   private String name = "Buch";
   public static int zaehler;
// Konstruktordefinition
   public LeseProdukt() {
      zaehler++;
   }
// Zugriffsmethoden
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
}
