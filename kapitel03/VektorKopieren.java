public class VektorKopieren implements Cloneable {   
   private int x;
   private int y;
   private int z;
// Die Klasse definiert zwei Konstruktoren
   public VektorKopieren(int x, int y, int z) { 
      this.x = x; 
      this.y = y;
      this.z = z;
   }
// Der Copy-Konstruktor erhält als Argument eine Referenz vom 
// Typ der eigenen Klasse 
   public VektorKopieren(VektorKopieren v) { 
      this.x = v.x;
      this.y = v.y;
      this.z = v.z;
   } 
// Beim Überschreiben von Methoden sind kovariante Rückgabetypen
// zugelassen
   public VektorKopieren clone() 
                              throws CloneNotSupportedException {
      VektorKopieren kopie = (VektorKopieren)super.clone(); 
      return kopie;
   }
// Instanzmethoden zum Erzeugen eines neuen 
// VektorKopieren-Objektes aus dem aktuellen
   public VektorKopieren neu(int a, int b, int c) {
      this.x = this.x+a; 
      this.y = this.y+b;
      this.z = this.z+c;
      return this;
   }
   public VektorKopieren neu1(int a, int b, int c) 
                              throws CloneNotSupportedException {
// Der Aufruf der clone()-Methode kann hier, ohne das die Klasse 
// diese Methode überschreibt, erfolgen
      VektorKopieren vektor = (VektorKopieren)this.clone();
      vektor.x = this.x+a; 
      vektor.y = this.y+b;
      vektor.z = this.z+c;
      return vektor;
   }
// Instanzmethode zur Anzeige eines VektorKopieren-Objektes
   public void anzeige() {
      System.out.print( "("+ x +","+ y +","+z+") ");
   }
}
