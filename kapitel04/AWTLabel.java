import java.awt.*;
public class AWTLabel extends Label {
// Konstruktordefinition
   public AWTLabel(String text, Color farbe) {
      super(text);
// Den Text innerhalb des Labels zentrieren
      setAlignment(Label.CENTER);
// Die Hintergrundfarbe festlegen
      setBackground(farbe);
// Die Schriftfarbe festlegen
      setForeground(Color.black);
   }
} 
