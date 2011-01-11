public class MyException extends Exception {
   private String meldungsNr;
// Konstruktordefinitionen
   public MyException() {
      super();
   }
   public MyException(String message) {
      super(message);
   }
   public MyException(String message, String meldungsNr) {
      super(message);
      this.meldungsNr = meldungsNr;
   }
// Zugriffsmethode
   public String getMeldungsNr() {
      return meldungsNr;
   }
}
