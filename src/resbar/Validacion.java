/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resbar;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author cesar
 */
public class Validacion {
    
    public JTextField e;
    
    public boolean ValidarNulos (String cadena){
        String cadena1= cadena;
        
            if(cadena1.equals("") || cadena1.equals(null)){
            //JOptionPane.showMessageDialog(null, "esta nulo");
                 return true;
            }
            else{
                return false;
            }
    }
    
   public  void soloDecimal(final JTextField a){
       a.addKeyListener(new KeyAdapter(){
           public void keyTyped(KeyEvent evt){
               
               int k= (int) evt.getKeyChar();
               
               if(k>=46 && k<=57){
                   if(k==46){
                       String dato= a.getText();
                       int tama= dato.length();
                       for (int i = 0; i <= tama; i++) {
                           if(dato.contains(".")){
                               evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                           }
                           
                       }
                   }
                   
                   if(k==47){
                           evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                       }    
                   
                       
                   }
                   
                   else{
                       evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                       evt.consume();
                   }
               
               
           }
       });
   }
   
   public  void sololetras(JTextField a){
       a.addKeyListener(new KeyAdapter(){
           public void keyTyped(KeyEvent e){
               char c= e.getKeyChar();
               if(Character.isDigit(c)){
                   e.consume();
               }
           }
                      
           });
   }
   
    public  void soloNumeros(JTextField a){
       a.addKeyListener(new KeyAdapter(){
           public void keyTyped(KeyEvent e){
               char c= e.getKeyChar();
               if(Character.isDigit(c)){
                   e.consume();
               }
           }
                      
           });
   }
    
}
