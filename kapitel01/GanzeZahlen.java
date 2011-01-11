class GanzeZahlen {
   private int z;
// Konstruktordefinition
   public GanzeZahlen(int z) {
      this.z = z;
   }
   public int getZahl() {
      return this.z;
   }
   public void setZahl(int a) { 
      this.z = a;
   }
   public GanzeZahlen negativ() {
      this.z = -this.z;
      return this;
   }
   public boolean gleich(GanzeZahlen a) {
      if(this.z == a.z)
         return true;
      return false;
   }
   public boolean kleiner(GanzeZahlen a) {
      if(this.z < a.z)
         return true;
      return false;
   }
   public static GanzeZahlen ggTeiler(GanzeZahlen a, 
                                      GanzeZahlen b) {
// Mit den nachfolgenen Zuweisungen würde das Vorzeichen der 
// Objekte, deren Referenz beim Methodenaufruf übergeben wird, 
// abgeändert 
    //   GanzeZahlen r = a;  
    //   GanzeZahlen s = b; 
// Um die ursprünglichen Objekte nicht zu verändern, werden 
// Kopien von diesen erzeugt
      GanzeZahlen r = new GanzeZahlen(a.z);
      GanzeZahlen s = new GanzeZahlen(b.z);
      if(r.getZahl()<0)
         r.negativ();
      if(s.getZahl()<0)
         s.negativ();
      if(r.gleich(new GanzeZahlen(0)))
         return s;
      else if(s.gleich(new GanzeZahlen(0)))
         return r;
      else {
         while(!r.gleich(s)) {
            if(r.kleiner(s))
               s = s.subtr(r);
            else
               r = r.subtr(s);
         }
      }
      return r;
   }
   public static GanzeZahlen kgVielfaches(GanzeZahlen a, 
                                          GanzeZahlen b) {
      GanzeZahlen r = new GanzeZahlen(a.z);
      GanzeZahlen s = new GanzeZahlen(b.z);
      if(r.getZahl() < 0)
         r.negativ();
      if(s.getZahl() < 0)
         s.negativ();
      GanzeZahlen t = ggTeiler(r,s);
      GanzeZahlen v = r.multipl(s);
      GanzeZahlen u = divid(v,t);
      return u;
   }
   public void anzeige() {
      System.out.println("Ganze Zahl: "+this.z); 
   }
   public static GanzeZahlen add(GanzeZahlen a, GanzeZahlen b) {
      return new GanzeZahlen(a.z+b.z);
   }
   public GanzeZahlen subtr(GanzeZahlen a) {
      return new GanzeZahlen(this.z - a.z);
   }
   public static GanzeZahlen divid(GanzeZahlen a, GanzeZahlen b){
      return new GanzeZahlen(a.z/b.z);
   }
   public GanzeZahlen multipl(GanzeZahlen a) {
      return new GanzeZahlen(z*a.z);
   }
}
