import java.awt.*;
import javax.swing.*;
public class MemberKlassenStatic {
   private Font f = new Font("Times Roman",Font.BOLD,14);
   private Color c = Color.pink;
// Die nachfolgenden 4 Objektinstantiierungen von Member-Klassen 
// sind korrekt
   public MemberKlassenStatic.FontIconStatic FontIconStatic = 
      new MemberKlassenStatic.FontIconStatic(f);
   public MemberKlassenStatic.ColorIconStatic ColorIconStatic = 
      new MemberKlassenStatic.ColorIconStatic(c);
// oder
   // FontIconStatic FontIconStatic = new FontIconStatic(f);
   // ColorIconStatic ColorIconStatic = new ColorIconStatic(c);
// Die nachfolgenden 4 wären Fehler
   // FontIconStatic FontIconStatic = this.new FontIconStatic(f);
   // ColorIconStatic ColorIconStatic = 
   //   this.new ColorIconStatic(c);
   // MemberKlassenStatic.FontIconStatic FontIconStatic = 
   //   this.new MemberKlassenStatic.FontIconStatic(f);
   // MemberKlassenStatic.ColorIconStatic ColorIconStatic = 
   //   this.new MemberKlassenStatic.ColorIconStatic(c);
// Konstruktor der umgebenden Klasse
   public MemberKlassenStatic(Font f, Color c) {
      this.f = f;
      this.c = c;
   }
// Instanzmethoden, die Objekte vom Typ der Member-Klassen 
// erzeugen und zurückgeben
   public FontIconStatic createFontIconStatic() {
      return new FontIconStatic(f);
   }
   public ColorIconStatic createColorIconStatic() {
      return new ColorIconStatic(c);
   }
// Static-Member-Klasse 
   public static class FontIconStatic implements Icon {
      Font font;
// Konstruktor der inneren Klasse
      public FontIconStatic(Font font) { 
         this.font = font;
      }
// Größe des Icons
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
         g.drawString(font.getName(), x, y+10);
      }
   }
// Eine weitere Static-Member-Klasse 
   public static class ColorIconStatic implements Icon {
      Color color;
// Konstruktor der inneren Klasse
      public ColorIconStatic(Color color) {
         this.color = color; 
      }
// Größe des Icons
      public int getIconHeight() {
         return 16;
      }
      public int getIconWidth() {
         return 16;
      }
// Das Icon malen
      public void paintIcon(Component c, Graphics g, int x, 
                            int y) {
         g.setColor(color);
         g.fillRect(x, y, 16, 16);
      }
   }
}
