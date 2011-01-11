public class WochenTageTest {
   private WochenTage wt;
   private static WochenTageTest woche; 
// Konstruktordefinition
   WochenTageTest(WochenTage wtage) {
      wt = wtage;
      System.out.println(wt.tag);
   }
   public static void main(String args[]) {
      woche = new WochenTageTest(WochenTage.MONTAG);
      woche = new WochenTageTest(WochenTage.DIENSTAG);
      woche = new WochenTageTest(WochenTage.MITWOCH);
      woche = new WochenTageTest(WochenTage.DONNERSTAG);
      woche = new WochenTageTest(WochenTage.FREITAG);
      woche = new WochenTageTest(WochenTage.SAMSTAG);
      woche = new WochenTageTest(WochenTage.SONNTAG);
   }
}
