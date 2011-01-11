import java.awt.*;
import javax.swing.*;
public class MemberKlassen {
   private Font f = new Font("Times Roman",Font.BOLD,14);
   private Color c = Color.pink;
// Alle nachfolgenden Objektinstantiierungen von Member-Klassen 
// sind korrekt
   // MemberKlassen.FontIcon fontIcon = new 
   //    MemberKlassen.FontIcon(f);
   // MemberKlassen.ColorIcon colorIcon = new 
   //    MemberKlassen.ColorIcon(c);
// oder
   // FontIcon fontIcon = this.new FontIcon(f);
   // ColorIcon colorIcon = this.new ColorIcon(c);
// oder
   public FontIcon fontIcon = new FontIcon(f);
   public ColorIcon colorIcon = new ColorIcon(c);
// Konstruktor der umgebenden Klasse
   public MemberKlassen(Font f, Color c) {
      this.f = f;
      this.c = c;
   }
// Instanzmethoden, die Objekte vom Typ der Member-Klassen 
// erzeugen und zurückgeben
   public FontIcon createFontIcon(){
      return new FontIcon(f);
   }
   public ColorIcon createColorIcon() {
      return new ColorIcon(c);
   }
// Innere Klasse (Member-Klasse) 
   public class FontIcon implements Icon {
      Font font;
// Konstruktor der inneren Klasse
      public FontIcon(Font font) {
         this.font = font; 
      }
// Die Größe des Icon definieren
      public int getIconHeight() {
         return 16;
      }
      public int getIconWidth() {
         return 96;
      }
// Das Icon malen
      public void paintIcon(Component c, Graphics g, int x, 
                            int y) {
         g.setFont(font);
         g.setColor(Color.red);
// (x,y) ist der Eckpunkt der Komponente, auf welche das Icon 
// gemalt werden soll
         g.drawString(font.getName(), x, y+10);
      }
  }   
// Eine weitere Member-Klasse 
   public class ColorIcon implements Icon {
      Color color;
// Konstruktor der Member-Klasse
      public ColorIcon(Color color) { 
         this.color = color;
      }
// Die Grösse des Icon definieren
      public int getIconHeight() {
         return 16;
      }
      public int getIconWidth() {
         return 16; 
      }
// Das Icon malen
      public void paintIcon(Component c, Graphics g, int x, 
                            int y) {
// c steht für die Komponente, auf welche das Icon gemalt wird
         g.setColor(color);
         g.fillRect(x, y, 16, 16);
      }
   }
}
