class KongruenteDreieckeTest {
   public static void main(String args[]) {
      KongruenteDreiecke d1 = new KongruenteDreiecke(4,4,4);
      d1 = d1.sss(); 
      System.out.println("w*w*w = "+ d1.getX()+"*"+d1.getY()+
        "*"+d1.getZ());
      KongruenteDreiecke d2 = new KongruenteDreiecke(4,60,4);
      d2 = d2.sws();
      System.out.println("w*s*w = "+ d2.getX()+"*"+d2.getY()+
        "*"+d2.getZ());
      KongruenteDreiecke d3 = new KongruenteDreiecke(60,4,60);
      d3 = d3.wsw();
      System.out.println("s*w*s = "+ d3.getX()+"*"+d3.getY()+
        "*"+d3.getZ());
      KongruenteDreiecke d4 = new KongruenteDreiecke(4,4,60);
      d4 = d4.ssw();
      System.out.println("w*w*s = "+ d4.getX()+"*"+d4.getY()+
        "*"+d4.getZ());
   }
}