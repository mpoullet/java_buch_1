import java.awt.*;
import javax.swing.*;
public class KomponentenUeberlappen extends JViewport {
   private ImageIcon icon = new ImageIcon("Vron.JPG");
   private Image bild = icon.getImage();
   protected void paintChildren(Graphics g) {
// Die Oberklasse soll als erstes ihre Kind-Komponenten 
// zeichnen; dann wird das von dieser Klasse gezeichnete Icon 
// über alle hinzugefügten Kind-Komponenten gesetzt
      super.paintChildren(g);
      g.drawImage(bild, 40, 60, this);
   }
   public static void main(String[] args) {
// Neue Fensterleiste setzen
      JFrame.setDefaultLookAndFeelDecorated(true);
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
// Benutzerdefinierte Komponente vom Typ der Klasse CustomArea 
// erzeugen und für diese einen Text setzen
      CustomArea textArea = new CustomArea();
      textArea.setText("ViewPort und ScrollPane\neeeeeeee\nddddd"
        +"ddddddd\nssssssss\naaaaaaaaa\ngggggggg\nwwwwwwww\nmmmm"
          +"m\ngggggggg\nzzzzzzzzz\nhhhhhh\nwwwwwwwwwwwww\nmmmmm"
            +"mmmmm\ngggggggggggggggg\nzzzzzzzzzzz\nhhhhhh");
// Der JTextArea-Komponente einen benutzerdefinierten UI-Delegate
// zuordnen; für die JButton-Komponente wird in den Standard- 
// UI-Delegate der Klasse ButtonUI verzweigt
      textArea.setUI(new CustomAreaUI());
// Eine JViewport-Komponente vom Typ der Klasse erzeugen und 
// zu einer ScrollPane hinzugefügen
      KomponentenUeberlappen vp = new KomponentenUeberlappen();
// Benutzerdefinierte Komponente vom Typ der Klasse 
// JButtonmitIcon erzeugen
      JButtonmitIcon myButton = new JButtonmitIcon("Vroni");
// Die TextArea zum Button hinzufügen und diesen als "View" 
// (LW-Kind-Komponente) im Viewport setzen
      myButton.add(textArea);
      myButton.setSize(350,350);
      vp.setView(myButton);
// JScrollPane-Komponente erzeugen und festlegen, dass ihre 
// Scrollbalken immer gesetzt werden sollen 
      JScrollPane sp = new JScrollPane();
      sp.setBounds(10,10,200,200);
      sp.setVerticalScrollBarPolicy(
      ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      sp.setHorizontalScrollBarPolicy(
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);  
      sp.setViewport(vp);
// Die JScrollPane zu einem Fenster hinzufügen und sichtbar 
// machen
      frame.getContentPane().setBackground(Color.lightGray);
      frame.getContentPane().setLayout(null);
      frame.getContentPane().add(sp);
      frame.setSize(250,250);
      frame.setVisible(true);
   }
}
