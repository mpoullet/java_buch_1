class GlobaleReferenzen {
// Globale primitive und Referenz-Variablen
   private static int i = 1;
   private int[] iarray = {1,2,3};
   private Punkt p = new Punkt(4.0, 3.0);
   private static Punkt[] parray = {
     new Punkt(1.0, 1.0), new Punkt(2.0,2.0)};
// Methodendefinitionen
   public void methode1() {
      i = 0;
      iarray[1] = 0;
   }
// Das Objekt, auf welches die Referenz zeigt, wird abgeändert
   public void methode2() {
      p.setX(0.0);
      p.setY(0.0);
      parray[1].setX(0.0);
      parray[1].setY(0.0);
   }
// Die Referenz wird abgeändert
   public void methode3() {
      p = new Punkt(-1.0,-1.0);
   }
   public static void main(String args[]) {
// Objekt der Klasse erzeugen
      GlobaleReferenzen instanz = new GlobaleReferenzen();
      System.out.println("int-Variable vor dem Aufruf von "
        + "methode1(): "+i);
      System.out.print("int-Array vor dem Aufruf von "
        + "methode1(): ");
      for(int j=0; j<instanz.iarray.length; j++) {
         System.out.print(instanz.iarray[j]+" ");
      }
      System.out.println();
      instanz.methode1();
      System.out.println("int-Variable nach dem Aufruf von "
        + "methode1(): "+i);
      System.out.print("int-Array nach dem Aufruf von "
        + "methode1(): ");
      for(int j=0; j<instanz.iarray.length; j++) {
         System.out.print(instanz.iarray[j]+" ");
      }
      System.out.println();
      System.out.print("Die Referenzvariable vom Typ Punkt zeigt"
        + " vor dem Aufruf von methode2() auf das Objekt: ");
// Die Methode anzeige() der Klasse Punkt wird aufgerufen
      instanz.p.anzeige();
      System.out.println("Punkt-Array vor dem Aufruf von "
        + "methode2(): ");
      for(int j=0; j<parray.length; j++) {
         parray[j].anzeige();
      }
      instanz.methode2();
      System.out.print("Die Referenzvariable vom Typ Punkt zeigt"
        +" nach dem Aufruf von methode2() auf das gleiche Objekt"
          + " mit abgeaenderten Werten: ");
      instanz.p.anzeige();
      System.out.println("Punkt-Array nach dem Aufruf von "
        + "methode2(): ");
      for(int j=0; j<parray.length; j++) {
         parray[j].anzeige();
      }
      System.out.print("Die Referenzvariable vom Typ Punkt zeigt"
        + " vor dem Aufruf von methode3() auf das Objekt: ");
      instanz.p.anzeige();
      instanz.methode3();
      System.out.print("Die Referenzvariable vom Typ Punkt zeigt"
        + " nach dem Aufruf von methode3() auf ein neues "
          + "Objekt: ");
      instanz.p.anzeige();
   }
} 
