import javax.swing.text.*;
public class GrossBuchstaben extends PlainDocument {
// Die Methode insertString() überschreiben
   public void insertString(int offs, String str, AttributeSet a)
                                   throws BadLocationException {
      if(str == null)
         return;
      super.insertString(offs, new String(str.toUpperCase()), a); 
   }
}
