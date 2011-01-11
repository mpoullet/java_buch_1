import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalScrollButton;
import javax.swing.plaf.basic.BasicArrowButton;
public class GenericTypmitSuper <T extends Container> { 
   T komponente;
// Zugriffsmethoden auf die Komponente
   public void setComponent(T komponente) {
      this.komponente = komponente;
   }
   public T getComponent() {
      return this.komponente;
   }
// Static-Member-Klasse
   public static GenericTypmitSuper <? super MetalScrollButton> 
     add(GenericTypmitSuper <? super MetalScrollButton> komp1,
       GenericTypmitSuper <? super MetalScrollButton> komp2) {
      komp1.getComponent().add(komp2.getComponent());
      return komp1;
   }
   public static void main(String[] args) {
// Eine Instanz vom Typ Container der Klasse GenericTypmitSuper 
// erzeugen und deren Instanzfeld über die Zugriffsmethode der 
// Klasse mit einem Container-Objekt initialisieren
   GenericTypmitSuper<Container> c = 
     new GenericTypmitSuper<Container> ();
      c.setComponent(new Container()); 
      c.getComponent().setLayout(new GridLayout(3,1));
// Instanzen vom Typ JButton, MetalScrollButton und 
// BasicArrowButton der Klasse GenericTypmitSuper erzeugen und 
// deren Instanzfeld über die Zugriffsmethode der Klasse 
// mit Objekten vom gleichen Typ initialisieren
      GenericTypmitSuper <? super MetalScrollButton > komp; 
      GenericTypmitSuper<JButton> komp1 = 
        new GenericTypmitSuper<JButton>();
      komp1.setComponent(new JButton()); 
      komp = add(c,komp1);   
      GenericTypmitSuper <MetalScrollButton> komp2 = 
        new GenericTypmitSuper<MetalScrollButton>();
      komp2.setComponent(new MetalScrollButton(
        SwingConstants.EAST,50,true));
      komp = add(c,komp2); 
      GenericTypmitSuper<BasicArrowButton> komp3 = 
        new GenericTypmitSuper<BasicArrowButton>();
      komp3.setComponent(new BasicArrowButton(
        SwingConstants.WEST)); 
      komp = add(c,komp3); 
// Die Komponente komp zu einem Fenster hinzufügen
      JFrame frame = new JFrame();
      frame.setContentPane(komp.getComponent());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(100,100);
      frame.setVisible(true);
   }
}
