import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserKomponente extends JLabel {
// Globale Referenzen zur Identifikation der benutzerdefinierten 
// Event-Listener
   private UserEventundListener.ListenerBlau listenerBlau;
   private UserEventundListener.ListenerRot listenerRot;
   private String name;
// Konstruktordefinition 
   public UserKomponente(final String name) {
      super(name);
      this.name = name;
      setBounds(50,50,100,100);
      setBackground(Color.pink);
// Den MouseListener als anonyme Klasse implementieren
      addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
// Den Graphikkontext der aktuellen Instanz ermitteln
            Graphics g = getGraphics();
// Die Koordinaten des Mausklicks lesen
            int x = e.getX();
            int y = e.getY();
// Ist einer der Koordinatenwerte durch 2 teilbar,
            if((x%2==0) || (y%2==0)) {
// ein Ereignis vom Typ EventBlau erzeugen,
               UserEventundListener.EventBlau eBlau = new 
                 UserEventundListener.EventBlau(UserKomponente.
                   this,name); 
// den EventListenerBlau informieren 
               listenerBlau.selectBlau(eBlau);
// und den Text in der Farbe blau und mit der Schrift "Lucida 
// HandWriting" an den Pixel-Koordinaten (x,y) zeichnen 
               g.setColor(Color.blue);
               g.setFont(new Font(
                 "Lucida HandWriting", Font.PLAIN, 16));
               g.drawString("Java 6.0",x,y);
            }
            else {
// ansonsten wird ein Ereignis vom Typ EventRot erzeugt,
               UserEventundListener.EventRot eRot = new 
                 UserEventundListener.EventRot(UserKomponente.
                   this,name); 
// der EventListenerRot informiert
               listenerRot.selectRot(eRot);
// und der Text in der Farbe rot und mit der Schrift "Arial"
// an den Pixel-Koordinaten (x,y) gezeichnet 
               g.setFont(new Font(
                 "Arial", Font.PLAIN, 16));
               g.setColor(Color.red);
               g.drawString("Java 6.0",x,y);
            }
         }
      }); 
   }
// Methoden für das Registrieren der beiden Listener
   public void addListenerBlau(UserEventundListener.
     ListenerBlau l) {
      listenerBlau = l;
   } 
   public void addListenerRot(UserEventundListener.
     ListenerRot l) {
      listenerRot = l;
   } 
} 
