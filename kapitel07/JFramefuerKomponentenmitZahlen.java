import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JFramefuerKomponentenmitZahlen extends JFrame {
// Konstante Optionen für die Beschriftung von Komponenten
   private final static String[][] zahlen = 
     {{"1","2","3"},{"4","5","6"},{"7","8","9"}}; 
// Die Statusvariable als final deklarieren, weil sie innerhalb 
// einer anonymen Klasse genutzt wird
   private final JLabel status = new JLabel(" "); 
// Globale Referenzen vom Typ der Klasse KomponentenmitZahlen
   private KomponentenmitZahlen kml1, kml2;
// Ein Panel zur Aufnahme der Komponenten erzeugen 
   private JPanel cPanel = new JPanel();
// Konstruktordefinition
   public JFramefuerKomponentenmitZahlen () {
      super("Event-Objekte und Event-Listener");
      setBounds(25,20,250,150);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      cPanel.setLayout(new BorderLayout()); 
// Zwei KomponentenmitZahlen-Objekte erzeugen
      kml1 = new KomponentenmitZahlen(KomponentenmitZahlen.
        JBUTTON, zahlen);
      kml2 = new KomponentenmitZahlen(KomponentenmitZahlen.
        JTEXTFIELD, zahlen);   
// Zur Definition der anonymen Klasse und anschließendem Erzeugen
// einer Instanz dieser Klasse wird das Schlüsselwort new benutzt
// Diese Klasse implementiert das Interface KomponentenListener 
// und wird von der Klasse Object abgeleitet
      KomponentenmitZahlen.KomponentenListener l = 
        new KomponentenmitZahlen.KomponentenListener() {
      public void komponentenAuswahl(KomponentenmitZahlen.
        KomponentenEvent e) {
          status.setText("Gewählte Zahl: "+e.
            getKomponentenmitZahlen().getkomponentenName()+ 
              " aus der " +e.getKomponentenmitZahlen().
                getkomponentenTyp()+" - Tabelle");
         }   
      };
      kml1.addKomponentenListener(l);
      kml2.addKomponentenListener(l); 
// Die KomponentenmitZahlen-Objekte zum Panel hinzufügen
      cPanel.add("Center",kml2);
      cPanel.add("West",kml1);   
// Das Panel und die Statuszeile im Fenster anzeigen
      Container contentPane = getContentPane();
      contentPane.add(new Label("Auswahl einer Zahl"),
        BorderLayout.NORTH);      
      contentPane.add(cPanel, BorderLayout.CENTER);
      contentPane.add(status, BorderLayout.SOUTH);
      setVisible(true);
   } 
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramefuerKomponentenmitZahlen frame = 
        new JFramefuerKomponentenmitZahlen();
   }
}
