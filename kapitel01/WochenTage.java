public class WochenTage {
// Selbstreferenzierende Klassenfelder können in ihrer 
// Deklaration initialisiert werden 
   public final static WochenTage MONTAG = new WochenTage(1); 
   public final static WochenTage DIENSTAG = new WochenTage(2); 
   public final static WochenTage MITWOCH = new WochenTage(3); 
   public final static WochenTage DONNERSTAG = new WochenTage(4); 
   public final static WochenTage FREITAG = new WochenTage(5); 
   public final static WochenTage SAMSTAG = new WochenTage(6); 
   public final static WochenTage SONNTAG = new WochenTage(7); 
   public String tag;
// Privater Konstruktor der Klasse
   private WochenTage(int i) {
      if(i == 1)
         tag = "Der 1.Wochentag ist der Montag";
      else if(i == 2)
         tag = "Der 2.Wochentag ist der Dienstag";
      else if(i == 3)
         tag = "Der 3.Wochentag ist der Mitwoch";
      else if(i == 4)
         tag = "Der 4.Wochentag ist der Donnerstag";
      else if(i == 5)
         tag = "Der 5.Wochentag ist der Freitag";
      else if(i == 6)
         tag = "Der 6.Wochentag ist der Samstag";
      else if(i == 7)
         tag = "Der 7.Wochentag ist der Sonntag"; 
   }   
} 
