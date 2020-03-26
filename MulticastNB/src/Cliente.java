
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sweet
 */
public class Cliente {
    
    public static void main(String[] args) {
        Inicio i = new Inicio();
        boolean f = true;
        Interfaz in = new Interfaz();
        String text="";
        i.setVisible(true);
        do{
            
            try {
            if(i.getValue()==true){ 
                text=i.getText();
                System.err.println("Texto: " + text);
            }
            Thread.sleep(2000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }while(f);
    }
    
}
