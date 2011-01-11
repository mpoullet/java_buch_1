public class BlumenTest {
   public static void main(String args[]) {
// Die vergr�ssernde Konvertierung wird implizit durchgef�hrt
      Blumen[] blumen = new Blumen[]{new Rose(), new Tulpe(), 
        new Nelke()};
      for(int i = 0; i<3; i++) {
// Die Methode der Unterklasse wird aufgerufen 
         (blumen[i]).identifizieren();
// Die Methode der Oberklasse wird aufgerufen
         (blumen[i]).farbe();
// Eine verkleinernde Konvertierung muss explizit durchgef�hrt
// werden
         switch (blumen[i].blume) {
            case Blumen.ROSE:
               ((Rose)blumen[i]).wurzeln();
               break;
            case Blumen.TULPE:
               ((Tulpe)blumen[i]).zwiebeln();
                break;
            case Blumen.NELKE:
               ((Nelke)blumen[i]).stauden();
         }
      }
   }
}    
