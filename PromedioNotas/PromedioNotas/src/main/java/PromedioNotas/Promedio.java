/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PromedioNotas;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante
 */
public class Promedio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado= new Scanner(System.in);

        int [] prome;
        prome= new int[20];

        int i,opc;
        int x = 0;
        float total=0;
        while (x < 1){
        for(i=0;i<20;++i)
        {
            //System.out.print("ingrese calificacion del alumno "+i+": ");
            prome[i]=Integer.parseInt(JOptionPane.showInputDialog("Ingrese calificacion del alumno " + (i+1) + ": "));
           total=total+prome[i];
        }
        total= total/20;
        JOptionPane.showMessageDialog(null, "El promedio general es: "+ total);
            opc=Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción: 1.-Calcular otro promedio    2.-Salir "));
            if (opc==1){
                x = 0;
            } else {
                x = 2;
            }
    }        
      JOptionPane.showMessageDialog(null,"Adios");    
}
}
