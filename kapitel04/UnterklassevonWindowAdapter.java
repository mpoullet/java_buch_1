import java.awt.event.*;
public class UnterklassevonWindowAdapter extends WindowAdapter {
   public void windowClosing(WindowEvent e){
      System.exit(0);
   }
}   
