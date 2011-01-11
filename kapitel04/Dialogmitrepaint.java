import java.awt.*;
import javax.swing.*;
public class Dialogmitrepaint {
   public static void main(String[] args) {
      String[] titleStrings = {"Bild (1)", "Bild (2)", "Bild(3)",
        "Bild (4)"};
      String[] iconStrings = {"T1.gif", "T2.gif", "T3.gif", 
        "T4.gif"}; 
      ImageIcon[] icon = new ImageIcon[4];
      Frame f = new Frame();
      DialogmitFrameOwner dialog[] = new DialogmitFrameOwner[4];
      int x = 10;
      int y = 10;
// Objektzustände über Feldwerte der Klasse DialogmitFrameOwner 
// setzen und repaint() aufrufen
      for(int i=0; i<iconStrings.length; i++) {
         dialog[i] = new DialogmitFrameOwner(x, y, f);
         icon[i] = new ImageIcon(iconStrings[i]);
         dialog[i].bild = icon[i].getImage();
         dialog[i].title = titleStrings[i];
         dialog[i].repaint();
         x = x+150;
      }
   }
}
