public class PersonTypTest {
   public static void main(String args[]) {
      PersonTyp[] personen = new PersonTyp[]{new TypLehrer(), 
        new TypSchueler()};
      for(int i=0; i<2; i++) {
         switch(personen[i].personTyp) {
            case PersonTyp.LEHRER:
// Eine verkleinernde Konvertierung muss explizit durchgeführt 
// werden
            // personen[i].lehren(); // Fehler
               ((TypLehrer)personen[i]).lehren();
               break;
            case PersonTyp.SCHUELER:
               ((TypSchueler)personen[i]).lernen();
         }
      }
   }
}