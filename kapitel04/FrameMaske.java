import java.awt.*;
public class FrameMaske extends Frame {
// Globale Referenz vom Typ des Interface LayoutManager
   private static LayoutManager layout; 
// Konstruktordefinition
   public FrameMaske(String title) {
      super(title);
      setBounds(10,50,200,100);
   }
   public static void main(String[] args) {
// Lokale Referenz vom Typ der Klasse GrundMaskefuerAWT
      GrundMaskefuerAWT maske;
// Ein im Programmaufruf angegebenes Argument definiert den Namen
// des Layout-Managers als String
      FrameMaske frame = new FrameMaske(args[0]);
      if(args[0].equals("FlowLayout")) {
         layout = new FlowLayout();
      }
      else if(args[0].equals("GridLayout")) {
         layout = new GridLayout(2,3);
      }
      else if(args[0].equals("BorderLayout")) {
         layout = new BorderLayout();
      }
      maske = new GrundMaskefuerAWT (frame,layout);
      maske.anzeige();
   }
}
