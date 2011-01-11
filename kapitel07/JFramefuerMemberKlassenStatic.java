import java.awt.*;
import javax.swing.*;
public class JFramefuerMemberKlassenStatic extends JFrame {
   private JButton fontButton1,fontButton2;
   private JButton colorButton1, colorButton2;
   private Font font = new Font("Andy", Font.BOLD, 14);
   private Color color = Color.green;
// Konstruktordefinition
   public JFramefuerMemberKlassenStatic() {
      super("Static-Member-Klasse");
      setBounds(10,10,200,100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      MemberKlassenStatic mb = new 
        MemberKlassenStatic(font,color);
      Container cPanel = (Container)new JPanel();
// Eine Instanz der Static-Member-Klasse kann ohne eine Instanz 
// der umgebenden Klasse erzeugt werden
      MemberKlassenStatic.FontIconStatic fontIcon = new 
        MemberKlassenStatic.FontIconStatic(font);
      MemberKlassenStatic.ColorIconStatic colorIcon = new 
        MemberKlassenStatic.ColorIconStatic(color);
// Ist eine Instanz der umgebenden Klasse vorhanden, so können 
// auch mit dieser auf verschiedene Arten Instanzen der Static- 
// Member-Klassen erzeugt werden
      colorButton1 = new JButton(mb.ColorIconStatic);
      fontButton1 = new JButton(mb.FontIconStatic);
      fontButton2 = new JButton(fontIcon);
      colorButton2 = new JButton(colorIcon);
// oder
   // colorButton1 = new JButton(mb.new ColorIconStatic(color));
   // fontButton1 = new JButton(mb.new FontIconStatic(font));
// oder
   // MemberKlassenStatic.FontIconStatic mbfi = 
   //   mb.new FontIconStatic(font); 
   // fontButton1 = new JButton(mbfi);
// oder
   // fontButton2 = new JButton(mb.createFontIconStatic());
   // colorButton2 = new JButton(mb.createColorIconStatic());
// Im Konstruktoraufruf darf der Name der umgebenden Klasse nicht
// explizit angegeben werden, aber die Referenz auf das Objekt
// muss wiederum diesen Namen vorangestellt bekommen
   // FontIconStatic mbfi = mb.new MemberKlassenStatic.
   //   FontIconStatic(font); // Fehler
      cPanel.add(fontButton1);
      cPanel.add(colorButton1);
      cPanel.add(colorButton2);
      cPanel.add(fontButton2);
      setContentPane(cPanel);
      setVisible(true);
   }
// Objekt der äußeren Klasse erzeugen
   public static void main(String[] args) {
      JFramefuerMemberKlassenStatic frame = new 
        JFramefuerMemberKlassenStatic();
   }
}
