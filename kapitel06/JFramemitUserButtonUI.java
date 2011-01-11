import java.awt.*;import javax.swing.*;
public class JFramemitUserButtonUI extends JFrame {
// Konstruktordefinition
   JFramemitUserButtonUI() {
      super("Benutzerdefinierter UI-Delegate");
      JButton b = new JButton("Button1");
      b.setUI(new UserButtonUI());
      JButton btn = new JButton("Button2");
      btn.setUI(new UserButtonUI1());
      JButton bt = new JButton("Button3");
      bt.setPreferredSize(new Dimension(100,50));
      bt.setUI(new UserButtonUI2());
      getContentPane().setLayout(new FlowLayout());
      getContentPane().add(b);
      getContentPane().add(btn);
      getContentPane().add(bt);
   }
// Objekt der Klasse erzeugen und sichtbar machen
   public static void main(String[] args) {
      JFrame frame = new JFramemitUserButtonUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
