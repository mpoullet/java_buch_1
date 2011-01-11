public class FarbenAuswahl implements Farben {
   private static final String[] farbe = new String[7];
   static {
      farbe[Farben.BLAU] = "blau";
      farbe[ROT] = "rot";
      farbe[Farben.WEISS] = "weiss";
      farbe[FarbenHell.ROSA] = "rosa";
      farbe[FarbenDunkel.SCHWARZ] = "schwarz";
      farbe[BRAUN] = "braun";
   }
   public void defFarbe(int i) {
      System.out.println("Die ausgewaehlte Farbe ist: "
        + farbe[i]);
   }
}


