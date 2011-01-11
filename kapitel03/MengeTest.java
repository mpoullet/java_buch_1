public class MengeTest {
   public static void main(String args[]) {
      Menge m1 = new Menge(6);
      for(int i=1; i<7; i++)
         m1.addElem(i);
      System.out.println(m1.toString());
      Menge m2 = new Menge(5);
      for(int i=3; i<8; i++)
         m2.addElem(i);
      System.out.println(m2.toString());
      Menge m3 = m1.vereinigung(m2);
      System.out.println(m3.toString());
      Menge m4 = m1.durchschnitt(m2);
      System.out.println(m4.toString());
   }
}   
