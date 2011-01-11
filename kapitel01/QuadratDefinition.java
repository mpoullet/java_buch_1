class QuadratDefinition  {
   int a;  
// Konstruktordefinition 
   QuadratDefinition(int x) {
      a = x;
   }
// Instanzmethode zum Berechnen des Flächeninhaltes 
   public int flaeche() {
      int f = a*a;
      return f;
   }
// Gleichnamige Klassenmethode zum Berechnen des Flächeninhaltes
   public static int flaeche(QuadratDefinition q) {
      int f = q.a*q.a;
      return f;
   }
}
