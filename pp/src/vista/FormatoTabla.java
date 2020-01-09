package vista;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class FormatoTabla extends DefaultTableCellRenderer{    
    Font normal = new Font( "Arial",Font.PLAIN,12 );
    Font negrilla = new Font( "Helvetica",Font.BOLD,18 );
    Font cursiva = new Font( "Times new roman",Font.ITALIC,12 );

    @Override 
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column ) 
    {
        setEnabled(table == null || table.isEnabled()); 
        
        if(row%2==0) {
        	setBackground(Color.decode("#ebebeb"));
        }
        else {
        	setBackground(Color.WHITE);
        }
        
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);         
        return this;
 }
    
 //
 private boolean isNumber(String cadena){
         try {
             Double.parseDouble(cadena.replace(",", ""));
         } catch (NumberFormatException nfe){
             String newCadena = cadena.replace(".", "").replace(',', '.');
             try{
                 Double.parseDouble(newCadena);
             } catch (NumberFormatException nfe2){
                 return false;
             }
        }
         return true;
    }

}