import java.awt.*;
import javax.swing.*;
public class JFramefuerMemberKlassen extends JFrame {
   private JButton fontButton1, fontButton2;
   private JButton colorButton1, colorButton2;
   private Font font = new Font("Andy", Font.BOLD, 14);
   private Color color = Color.green;
// Konstruktordefinition
   public JFramefuerMemberKlassen() {
      super("Member-Klassen");
      setBounds(10,10,300,100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Instanz der umgebenden Klasse
      MemberKlassen mb = new MemberKlassen(font,color);
      Container cPanel = getContentPane();
      cPanel.setLayout(new FlowLayout());
// Eine Instanz der Member-Klasse kann nicht ohne eine Instanz 
// der umgebenden Klasse erzeugt werden
   // MemberKlassen.FontIcon fontIcon = new 
   //   MemberKlassen.FontIcon(font); // Fehler
   // MemberKlassen.ColorIcon colorIcon = new 
   //   MemberKlassen.ColorIcon(color); // Fehler
// Ist eine Instanz der umgebenden Klasse vorhanden, so können 
// mit dieser auf verschiedene Arten Instanzen der Member-Klassen
// kreiert werden
      colorButton1 = new JButton(mb.colorIcon);
      fontButton1 = new JButton(mb.fontIcon);
// oder
   // colorButton1 = new JButton(mb.new ColorIcon(color)); 
   // fontButton1 = new JButton(mb.new FontIcon(font)); 
// oder über den Methodenaufruf
      fontButton2 = new JButton(mb.createFontIcon());
      colorButton2 = new JButton(mb.createColorIcon());
// Im Konstruktoraufruf darf der Name der umgebenden Klasse 
// nicht explizit angegeben werden
   // FontIcon mbfi = mb.new MemberKlassen.FontIcon(font);
// Die Referenz auf das erzeugte Objekt muss wiederum diesen 
// Namen vorangestellt bekommen
   // MemberKlassen.FontIcon mbfi = mb.new FontIcon(font); 
// Damit kann ein JButton-Objekt erzeugt werden
   // fontButton1 = new JButton(mbfi);
// Die Buttons zum Panel hinzufügen
      cPanel.add(fontButton1);
      cPanel.add(fontButton2);
      cPanel.add(colorButton1);
      cPanel.add(colorButton2);
      setVisible(true);
   } 
// Objekt der äußeren Klasse erzeugen
   public static void main(String[] args) {
      JFramefuerMemberKlassen frame = new 
        JFramefuerMemberKlassen();
   }
}
