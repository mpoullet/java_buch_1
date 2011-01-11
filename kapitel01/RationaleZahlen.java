class RationaleZahlen {
// Globale Referenzen vom Typ der Klasse GanzeZahlen
   private GanzeZahlen x, y;          
// Konstruktordefinition
   public RationaleZahlen(GanzeZahlen zaehler, 
                          GanzeZahlen nenner) {
      this.x = zaehler;
      this.y = nenner;
   }
   public GanzeZahlen getZaehler() {
      return x;
   }
   public GanzeZahlen getNenner() {
      return y;
   }
   public void setZaehler(GanzeZahlen a) { 
      x = a;
   }
   public void setNenner(GanzeZahlen b) { 
      y = b;
   }
   public void anzeige() {
      System.out.println("Rationale Zahl: "+ x.getZahl() + 
        "/" + y.getZahl());
   }
// Da beim Kürzen der Erhalt des ursprünglichen Objektes nicht 
// erforderlich ist, werden die Änderungen im aktuellen Objekt 
// durchgeführt und dieses wird auch zurückgegeben 
   public RationaleZahlen kuerzen() {
// Lokale Referenz vom Typ der Klasse GanzeZahlen
      GanzeZahlen t = GanzeZahlen.ggTeiler(x, y);    
      x = GanzeZahlen.divid(x,t);
      y = GanzeZahlen.divid(y,t);
      return this;  
   }
   public static RationaleZahlen add(RationaleZahlen a, 
                                      RationaleZahlen b) {
      GanzeZahlen gNenner = GanzeZahlen.kgVielfaches(a.y, b.y);
      return  new RationaleZahlen (GanzeZahlen.add(
        GanzeZahlen.divid(gNenner,a.y).multipl(a.x), 
          GanzeZahlen.divid(gNenner,b.y).multipl(b.x)),gNenner);
   }
   public RationaleZahlen subtr(RationaleZahlen a) {
     GanzeZahlen gNenner = GanzeZahlen.kgVielfaches(this.y, a.y);
     return new RationaleZahlen(((GanzeZahlen.divid(
       gNenner,this.y)). multipl(this.x)). subtr((
         GanzeZahlen.divid(gNenner,a.y)).multipl(a.x)), gNenner);
   }
   public static RationaleZahlen divid(RationaleZahlen a, 
                                       RationaleZahlen b) {
      return new RationaleZahlen((a.x).multipl(b.y), 
        (a.y).multipl(b.x));
   }
   public RationaleZahlen multipl(RationaleZahlen a) {
      return new RationaleZahlen(x.multipl(a.x), y.multipl(a.y));
   }
}
