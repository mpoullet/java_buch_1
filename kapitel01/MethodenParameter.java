class MethodenParameter {
// Methodendefinitionen
   public static void methode1(int x, int[] y) {
      x = 0;
      y[1] = 0;
   }
   public static void methode2(Punkt x, Punkt[] y) {
      x.setX(0.0);
      x.setY(0.0);
      y[1].setX(0.0);
      y[1].setY(0.0);
   }
   public static void methode3(Punkt x) {
      x = new Punkt(-1.0,-1.0);
   }
   public static void main(String args[]) {
// Lokale primitive und Referenz-Variablen
      int i = 1;
      int[] iarray = {1,2,3};
      Punkt p = new Punkt(4.0, 3.0);
      Punkt[] parray = {new Punkt(1.0, 1.0), new Punkt(2.0,2.0)};
      System.out.println("int-Variable  vor dem Aufruf von " 
        + "methode1(): "+i);
      System.out.print("int-Array vor dem Aufruf von "
        + "methode1(): ");
      for(int j=0; j<iarray.length; j++) {
         System.out.print(iarray[j]+" ");
      }
      System.out.println();
      methode1(i,iarray);
      System.out.println("int-Variable  nach dem Aufruf von "
        + "methode1(): "+i);
      System.out.print("int-Array nach dem Aufruf von "
        + "methode1(): ");
      for(int j=0; j<iarray.length; j++) {
         System.out.print(iarray[j]+" ");
      }
      System.out.println();
      System.out.print("Die Referenzvariable vom Typ Punkt zeigt"
        + " vor dem Aufruf von methode2() auf das Objekt: ");
// Die Methode anzeige() der Klasse Punkt wird aufgerufen
      p.anzeige();
      System.out.println("Punkt-Array vor dem Aufruf von "
        + "methode2(): ");
      for(int j=0; j<parray.length; j++) {
         parray[j].anzeige();
      }
      methode2(p, parray);
      System.out.print("Die Referenzvariable vom Typ Punkt zeigt"
        + " nach dem Aufruf von methode2() auf das gleiche Objekt"
          + " mit abgeaenderten Werten: ");
      p.anzeige();
      System.out.println("Punkt-Array nach dem Aufruf von "
        + "methode2(): ");
      for(int j=0; j<parray.length; j++) {
         parray[j].anzeige();
      }
      System.out.print("Die Referenzvariable vom Typ Punkt zeigt"
        +" vor dem Aufruf von methode3() auf das Objekt: ");
      p.anzeige();
      methode3(p);
      System.out.print("Die Referenzvariable vom Typ Punkt zeigt"
        + " nach dem Aufruf von methode3() auf das gleiche "
          + "Objekt: ");
      p.anzeige();
   }
} 
