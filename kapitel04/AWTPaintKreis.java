import java.awt.*;
public class AWTPaintKreis extends Component { // Label {
// Konstruktordefinition
   public AWTPaintKreis(int x, int y, int d1, int d2, Color c) {
      setBounds(x,y,d1,d2);
      setForeground(c);
      setBackground(Color.lightGray);
   }
// Einen Kreis in der über die foreground-Eigenschaft
// gesetzten Farbe malen
   public void paint(Graphics g) {
      g.fillOval(0, 0, getSize().width-1, getSize().height-1);
   }
}
