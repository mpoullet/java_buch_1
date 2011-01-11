class QuadratDefinitionTest {
   public static void main(String args[]) {
      System.out.println("Instanz der Klasse erzeugen");
      QuadratDefinition quadrat = new QuadratDefinition(4);
      System.out.println("Aufruf der Instanzmethode");
      int finst = quadrat.flaeche();
      System.out.println("Flaeche: "+finst);
      System.out.println("Aufruf der Klassenmethode");
      int fkls2 = QuadratDefinition.flaeche(quadrat);
      System.out.println("Flaeche: "+fkls2);
   }
}
