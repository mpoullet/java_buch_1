public class MyException1 extends Exception {
// Konstruktordefinitionen
   public MyException1() {
      super();
   }
   public MyException1(String message) {
      super(message);
   }
   public MyException1(String message, Throwable cause) {
      super(message,cause);
   }
}
