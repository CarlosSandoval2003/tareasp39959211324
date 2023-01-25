/*1
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import javax.swing.JOptionPane;

/**
 *
 * @author daguilae
 */
public class OperacionesBasicas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        float opc=0,dato1=0,dato2=0,result=0, i = 0;
        
        while (i<1)
        {
        opc=Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opcion: " + "1.-Sumar    2.-Restar   3.-Multiplicar  4.-Dividir"));

        if(opc>0&&opc<5){
            dato1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese primer numero: "));
            dato2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese segundo numero numero: "));
        if(opc!=0){
            if(opc==1)
                result=dato1+dato2;
            if(opc==2)
                result=dato1-dato2;
            if(opc==3)
                result=dato1*dato2;
            if(opc==4)
                result=dato1/dato2;
        } 
        JOptionPane.showMessageDialog(null, "el resultado es: "+result);
        }
          opc=Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opcion: " + "1.-Realizar otra operación    2.-Salir" ));
            if (opc==1){
                i = 0;
            } else {
                i = 2;
            }  
                 
    }
    JOptionPane.showMessageDialog(null,"Adios");   
    }
}
