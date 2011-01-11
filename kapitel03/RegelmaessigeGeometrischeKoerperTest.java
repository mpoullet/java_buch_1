public class RegelmaessigeGeometrischeKoerperTest {
   public static void main(String args[]) {
      String[] name = {"Tetraeder: ", "Wuerfel: ", "Ikosaeder: ",
        "Oktaeder: ", "Dodekaeder: "};   
// Zuweisen von Objektreferenzen der konkreten Klassen an eine 
// Referenzvariable vom Typ der abstrakten Klasse 
      RegelmaessigeGeometrischeKoerper[] rgk = 
        new RegelmaessigeGeometrischeKoerper[]{new Tetraeder(4), 
          new Wuerfel(4), new Ikosaeder(4), new Oktaeder(4),
          new Dodekaeder(4)};
      for(int i=0; i<5; i++) {
         System.out.println(name[i]+ "Oberflaeche = "+rgk[i].
           oberflaeche()+" * Volumen = "+rgk[i].volumen());
// Die Methoden der Schnittstellen können auch an 
// RegelmaessigeGeometrischeKoerper-Instanzen aufgerufen werden
         System.out.println("Umkugelradius = "+rgk[i].umkugel()+ 
            " * Inkugelradius = "+rgk[i].inkugel());
      }
// Zuweisen von Objektreferenzen der konkreten Klassen an eine 
// Referenz vom Typ des Interface UmKugelRadius
      UmKugelRadius[] ukr = new UmKugelRadius[] {
        new Tetraeder(4), new Wuerfel(4), new Ikosaeder(4), 
        new Oktaeder(4), new Dodekaeder(4)};
// Die Methoden der anderen Schnittstelle und der abstrakten 
// Klasse können nicht an UmKugelRadius-Objekten aufgerufen 
// werden    
      for(int i=0; i<5; i++)
         System.out.println(name[i]+"Umkugelradius = " 
           + ukr[i].umkugel());
// Zuweisen von Objektreferenzen der konkreten Klassen an eine 
// Referenz vom Typ des Interface InKugelRadius
      InKugelRadius[] ikr = new InKugelRadius[] {
        new Tetraeder(4), new Wuerfel(4), new Ikosaeder(4), 
        new Oktaeder(4), new Dodekaeder(4)};
// Die Methoden der anderen Schnittstellen und der abstrakten 
// Klasse können nicht an InKugelRadius-Objekten aufgerufen 
// werden
      for(int i=0; i<5; i++)
         System.out.println(name[i]+"Inkugelradius = "
           + ikr[i].inkugel());
   }
}
