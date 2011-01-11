import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class JFramemitVektorenMalen extends JFrame 
                                    implements ActionListener {   
   private JButton [] bRechne = new JButton[2];
   private char sOperation [] = {'+','*'};
   private String [] sTrenner = {"(",",",",", ")"};
   private JButton bLoeschen, bAchsen;
   private JTextField [] v1 = new JTextField[3];
   private JTextField [] v2 = new JTextField[3];
   private JTextField [] v3 = new JTextField[3];
   private JTextField [] v4 = new JTextField[3];
   private JTextField [] v5 = new JTextField[3];
   private JTextField skalar = new JTextField(3);
   private Color hintergrund = Color.blue; 
   private Color vordergrund = Color.yellow; 
   private Canvas malflaeche = new Canvas(); 
   private JPanel p1,p2,p3,p1Norden,p1Sueden,p1Center,p2Norden, 
     p2Sueden,p2Center,p3Norden,p3Sueden,p3Center,cPanel;
   private JLabel[] l = new JLabel[4];
   private int hoeheC;
   private int breiteC;
// Konstruktordefinition
   public JFramemitVektorenMalen() {
      super("Darstellung von Vektoren");
      setBounds(20,20,600,500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      cPanel = (JPanel)getContentPane(); 
// Höhe und Breite des Canvas im Verhälnis zur Größe des 
// Fensters bestimmen
      hoeheC = getSize().height/2;
      breiteC = getSize().width/2;   
      malflaeche.setSize(breiteC, hoeheC);
// Fensterlayout definieren und die Komponenten zum Fenster 
// hinzufügen
      cPanel.setLayout(new BorderLayout());
      p1 = new JPanel();
      p2 = new JPanel();
      p3 = new JPanel();
      p1Norden = new JPanel();
      p1Sueden = new JPanel();
      p1Center = new JPanel();
      p2Norden = new JPanel();
      p2Center = new JPanel();
      p2Sueden = new JPanel();
      p3Norden = new JPanel();
      p3Center = new JPanel();
      p3Sueden = new JPanel();
      p1Norden.add(new JLabel("Operationen mit Vektoren"));
      p1Center.add(new JLabel("Komponenten zweier Vektoren "
        + "eingeben: "));
      for(int i=0; i<3; i++) {
         l[i]= new JLabel(sTrenner[i]);
         p1Center.add(l[i]);
         v1[i] = new JTextField(3);
// Alle Textfelder werden ohne Hintergrund und umgeben von einem 
// leeren Rand dargestellt 
         v1[i].setOpaque(false);
         v1[i].setBorder(new EmptyBorder(2,2,2,2));
         p1Center.add(v1[i]);
      }
      p1Center.add(l[3] = new JLabel(sTrenner[3]));
      for(int i=0; i<3; i++) {
         l[i]= new JLabel(sTrenner[i]);
         p1Center.add(l[i]);
         v2[i] = new JTextField(3);
         v2[i].setOpaque(false);
         v2[i].setBorder(new EmptyBorder(2,2,2,2));
         p1Center.add(v2[i]);
      }
      p1Center.add(l[3] = new JLabel(sTrenner[3]));
      p1Sueden.add(new JLabel("Eine Zahl für das r-Produkt mit "
        + "einem Vektor eingeben: "));
      skalar.setOpaque(false);
      skalar.setBorder(new EmptyBorder(2,2,2,2));
      p1Sueden.add(skalar);
      malflaeche.setBackground(hintergrund);
      malflaeche.setForeground(vordergrund);
      malflaeche.setSize(breiteC, hoeheC);
      p2Center.add(malflaeche); 
      p3Norden.add(new JLabel("Die Summe der Vektoren ist:")); 
      for(int i=0; i<3; i++) {
         l[i]= new JLabel(sTrenner[i]);
         p3Norden.add(l[i]);
         v3[i] = new JTextField(3);
         v3[i].setOpaque(false);
         v3[i].setBorder(new EmptyBorder(2,2,2,2));
         p3Norden.add(v3[i]);
      }
      p3Norden.add(l[3] = new JLabel(sTrenner[3]));
      p2Sueden.add(new JLabel("Das r-fache der Vektoren ist:")); 
      for(int i=0; i<3; i++) {
         l[i]= new JLabel(sTrenner[i]);
         p2Sueden.add(l[i]);
         v4[i] = new JTextField(3);
         v4[i].setOpaque(false);
         v4[i].setBorder(new EmptyBorder(2,2,2,2));
         p2Sueden.add(v4[i]);
      }
      p2Sueden.add(l[3] = new JLabel(sTrenner[3]));
      for(int i=0; i<3; i++) {
         l[i]= new JLabel(sTrenner[i]);
         p2Sueden.add(l[i]);
         v5[i] = new JTextField(3);
         v5[i].setOpaque(false);
         v5[i].setBorder(new EmptyBorder(2,2,2,2));
         p2Sueden.add(v5[i]);
      }
      p2Sueden.add(l[3] = new JLabel(sTrenner[3]));
      p2Norden.add(new JLabel("Eine Operation auswählen: "));
      for(int i=0; i<2; i++) {
         p2Norden.add(bRechne[i] = new JButton(
           String.valueOf(sOperation[i])));
         bRechne[i].addActionListener(this);
      }
      bLoeschen = new JButton("Loeschen");
      bLoeschen.addActionListener(this);
      bAchsen = new JButton("Koordinatenachsen zeichnen");
      bAchsen.addActionListener(this);
      p3Sueden.add(bLoeschen);
      p3Sueden.add(bAchsen);
      p1.setLayout(new BorderLayout());
      p1.add("North", p1Norden);
      p1.add("Center", p1Center);
      p1.add("South", p1Sueden);
      p2.setLayout(new BorderLayout());
      p2.add("North", p2Norden);
      p2.add("Center", p2Center);
      p2.add("South", p2Sueden);
      p3.setLayout(new BorderLayout());
      p3.add("North", p3Norden);
      p3.add("South", p3Sueden);
      cPanel.add("North", p1);
      cPanel.add("South",p3);   
      cPanel.add("Center",p2);
      setVisible(true);
   }
// Instanzmethode zum Zeichenen der Koordinatenachsen
   public void maleKoordinatenAchsen(int i) {
      VektorenMalen V = new VektorenMalen(0,0,0);
      VektorenMalen nV = new VektorenMalen(0,0,0);
      switch(i){
         case 0:
            nV.setVektor(10,0,0);
            break;
         case 1:
            nV.setVektor(0,-10,0);
            break;
         case 2:
            nV.setVektor(0,0,10);
            break;
         }
      VektorenMalen.malenVektor(0,0,V,nV,malflaeche,true, hoeheC,
        breiteC);
   }
// Implementierung der Methode des ActionListener-Interfaces
   public void actionPerformed(ActionEvent ae) {
// Welcher Button wurde gedrueckt??
      String sBefehl = ae.getActionCommand(); 
      VektorenMalen V = new VektorenMalen(0,0,0);
      VektorenMalen nV = new VektorenMalen(0,0,0);
      for(int i=0; i<2; i++) {
         if(sBefehl.equals(String.valueOf(sOperation[i]))) {
// Lokale Variablen zum Speichern der Werte von Vektorkomponenten 
            String []sv1 = new String[3];
            double []dv1 = new double[3];
            String []sv2 = new String[3];
            double []dv2 = new double[3];
            double []dv3 = new double[3];
            double []dv4 = new double[3];
            double []dv5 = new double[3];
// Die String-Werte von Vektorkomponenten einlesen und in 
// double-Werte umsetzen
            for(int j=0; j<3; j++) {
               sv1[j] = v1[j].getText().trim();
               dv1[j] = Double.parseDouble(sv1[j]);
            }
            for(int j=0; j<3; j++) {
               sv2[j] = v2[j].getText().trim();
               dv2[j] = Double.parseDouble(sv2[j]);
            }
// Instanzen vom Typ VektorenMalen erzeugen und mit den 
// eingelesenen Werten die Komponenten der Vektoren V und nV, 
// die für das Zeichnen auf die Canvas genutzt werden, 
// initialisieren
            VektorenMalen V1 = new VektorenMalen(dv1[0], dv1[1],
              dv1[2]);
            VektorenMalen V2 = new VektorenMalen(dv2[0], dv2[1], 
              dv2[2]);
// Den ersten Vektor vom Ursprung aus malen und seine 
// End-Koordinaten bestimmen
            nV.setVektor(nV.getX()+V1.getX(),nV.getY()+V1.getY(),
              nV.getZ()+V1.getZ());
            VektorenMalen.malenVektor(0,0,V,nV,malflaeche,false, 
              hoeheC, breiteC); 
// Der Anfangspunkt des zweiten Vektors stimmt mit dem 
// Endpunkt des ersten überein 
            V.setVektor(nV.getX(),nV.getY(),nV.getZ());
            nV.setVektor(nV.getX()+V2.getX(),nV.getY()+V2.getY(),
             nV.getZ()+V2.getZ());
            VektorenMalen.malenVektor(0,0,V,nV,malflaeche,false, 
              hoeheC, breiteC);
// Den lokalen Referenzen vom Typ der Klasse VektorenMalen
// werden die Referenzen der Instanzen, welche als Summe und 
// r-Produkt von Vektoren erzeugt wurden, zugewiesen.
            VektorenMalen V3, V4, V5; 
// Operationen durchführen
            switch(sOperation[i]) {
               case '+':
// Vektoren addieren und die Werte der Komponenten des Summen-
// Vektors im entsprechenden Textfeld am Bildschirm anzeigen
                  V3 = V1.addVektor(V2);
                  dv3[0] = V3.getX();
                  dv3[1] = V3.getY();
                  dv3[2] = V3.getZ();
                  v3[0].setText(Double.toString(dv3[0]));
                  v3[1].setText(Double.toString(dv3[1]));
                  v3[2].setText(Double.toString(dv3[2]));
// Die Komponenten der Vektoren V und nV für das Zeichnen des 
// Summen Vektors auf den Canvas initialisieren
                  V.setVektor(0,0,0);
                  nV.setVektor(0,0,0);
                  nV.setVektor(nV.getX()+V3.getX(),nV.getY()+
                    V3.getY(),nV.getZ()+V3.getZ());
                  VektorenMalen.malenVektor(0,0,V,nV,malflaeche,
                    false,hoeheC, breiteC);
                  break;
               case '*':
// Das r-Produkt für beide Vektoren ermitteln und die 
// Komponentenwerte der Vektoren in den entsprechenden 
// Textfeldern am Bildschirm anzeigen
                  String sskalar = skalar.getText().trim();
                  double dskalar = Double.parseDouble(sskalar);
                  V4 = V1.multiplVektor(dskalar);
                  V5 = V2.multiplVektor(dskalar);
                  dv4[0] = V4.getX();
                  dv4[1] = V4.getY();
                  dv4[2] = V4.getZ();
                  v4[0].setText(Double.toString(dv4[0]));
                  v4[1].setText(Double.toString(dv4[1]));
                  v4[2].setText(Double.toString(dv4[2]));
                  dv5[0] = V5.getX();
                  dv5[1] = V5.getY();
                  dv5[2] = V5.getZ();
                  v5[0].setText(Double.toString(dv5[0]));
                  v5[1].setText(Double.toString(dv5[1]));
                  v5[2].setText(Double.toString(dv5[2]));
// Die Komponenten der Vektoren V und nV für das Zeichnen der 
// Vektoren auf den Canvas initialisieren
                  V.setVektor(0,0,0);
                  nV.setVektor(0,0,0);
                  nV.setVektor(nV.getX()+V4.getX(),nV.getY()+
                    V4.getY(),nV.getZ()+V4.getZ());
                  VektorenMalen.malenVektor(0,0,V,nV,malflaeche,
                    false, hoeheC, breiteC);
                  V.setVektor(0,0,0);
                  nV.setVektor(0,0,0);
                  nV.setVektor(nV.getX()+V5.getX(),nV.getY()+
                    V5.getY(),nV.getZ()+V5.getZ());
                  VektorenMalen.malenVektor(0,0,V,nV,malflaeche,
                    false,hoeheC, breiteC);
                  break;
               default:System.out.println("Kein Ergebnis");
            } 
         }
// Koordinatenachsen zeichnen
         else if(sBefehl.equals("Koordinatenachsen zeichnen")) {
            for(int j=0; j<3; j++)
               maleKoordinatenAchsen(j);
         }
// Inhalte aller Textfelder löschen
         else if(sBefehl.equals("Loeschen")) {
            for (int j=0; j<3; j++){
               v1[j].setText("");
               v2[j].setText("");
               v3[j].setText("");
               v4[j].setText("");
               v5[j].setText("");
            }
            skalar.setText("");
// Löschen der Malfläche durch Übermalen mit der Hintergrundfarbe
            Graphics g = malflaeche.getGraphics(); 
            g.setColor(hintergrund);
            g.fillRect(0, 0, malflaeche.getSize().width, 
              malflaeche.getSize().height);
// Freigabe der vom Graphics-Objekt g belegten Ressourcen
            g.dispose();
         } 
      } 
   } 
// Objekt der Klasse erzeugen
   public static void main(String[] args) {
      JFramemitVektorenMalen frame = 
        new JFramemitVektorenMalen();   
   }
}
