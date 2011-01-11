public class MengenDuplizierenTest {
   public static void main(String args[]) 
                           throws CloneNotSupportedException {
// Erzeugen und Kopieren von Objekten der Klasse 
// MengenDuplizieren 
      MengenDuplizieren m1 = new MengenDuplizieren(9);
      System.out.println(m1.toString());
      MengenDuplizieren m2 = new MengenDuplizieren(m1);
      System.out.println(m2.toString());
      MengenDuplizieren m3 = (MengenDuplizieren)m1.clone();
      System.out.println(m3.toString());
   }
}   
