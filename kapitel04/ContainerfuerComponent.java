import java.awt.*;
public class ContainerfuerComponent extends Container {
// Konstruktordefinition   
   public ContainerfuerComponent() {
// Das Default-Container-Layout von null, auf BorderLayout oder 
// FlowLayout ab�ndern
   // setLayout(new BorderLayout());
      setLayout(new FlowLayout());
   }
   public void paint(Graphics g) {
// Dynamisch ermittelte Gr��enwerte f�r die Komponente
      Dimension size = getSize();
      int d = Math.min(size.width, size.height);
// �bereinanderliegende Rechtecke zeichnen
      int x = 0;
      int y = 0;
      int i = 0;
      while(x<size.width && y<size.height) {
         g.setColor(i%2==0 ? Color.white : Color.black);
         g.fillRect(x, y, size.width-(2*x), size.height-(2*y));
         x+=2;
         y+=2; 
         i++;
      }
// F�r leichtgewichtige Kindkomponenten
      super.paint(g); 
   }
}
