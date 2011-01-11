public abstract class PersonTyp {
   protected final static int LEHRER = 0;
   protected final static int SCHUELER = 1;
   protected int personTyp;
// Konstruktordefinition
   PersonTyp(int typ) {
      personTyp = typ;
   }
}