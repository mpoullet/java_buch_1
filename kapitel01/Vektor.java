public class Vektor {   
   private int x;
   private int y;
   private int z;
// Konstruktordefinitionen 
   public Vektor() {
      this(0,0,0);
   }
// Besitzen Methoden- oder Konstruktorenparameter die gleichen 
// Namen wie Instanzfelder, müssen die Instanzfelder über this 
// angesprochen werden
   public Vektor(int x, int y, int z) { 
      this.x = x; 
      this.y = y;
      this.z = z;
      this.y = y;
      this.z = z;
   }
// Ein mit dem Copy-Konstruktor erzeugtes Objekt hat die 
// gleichen Feldwerte wie das übergebene 
   public Vektor(Vektor v) { 
      x = v.x;
      y = v.y;
      z = v.z;
   }
// Methodendefinitionen 
   public Vektor neu(int a, int b, int c) {
      this.x = this.x+a; 
      this.y = this.y+b;
      this.z = this.z+c;
      return this;
   }
   public Vektor neu(Vektor v) {
      x = x+v.x; 
      y = y+v.y;
      z = z+v.z;
      return this;
   }
   public Vektor neu1(int a, int b, int c) {
      Vektor vektor = new Vektor(this);
      vektor.x = x+a; 
      vektor.y = y+b;
      vektor.z = z+c;
      return vektor;
   }
   public void anzeige() {
      System.out.print("("+ x +","+ y +","+ z +") ");
   }
}
