import java.awt.*;
public class AWTContainer extends Container { 
   private Color[] color;
// Konstruktordefinition
   public AWTContainer(Color[] color) {
      setBounds(0,0,250,250);
// Das null-Layout ist das Standard-Layout für die Container-
// Klasse
   // setLayout(null); 
      this.color = color;
   }
   public void paint(Graphics g) { 
      int laenge = 5;
      for(int y=0; y+laenge<=getSize().height; y+=laenge) {
         for(int x=0; x+laenge<=getSize().width; x+=laenge) {
            g.setColor(color[x % color.length]);
            g.fillRect(x, y, laenge, laenge);
         }
// Die Reihenfolge der Farben wechseln
         Color[] c = new Color[color.length];
         for(int i=0; i<color.length; i++)
            c[i] = color[color.length-(1+i)];
         color = c; 
      }
// Die Methode der Oberklasse muss nur, wenn die AWTPaintKreis- 
// Klasse von Component abgeleitet wird, aufgerufen werden  
      super.paint(g); 
   }  
}
