/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caseProblem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author logra
 */
public class EventDemo {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Event> eventos = new ArrayList<>();
        int inv, modo;
        
        for (int i = 0; i < 8; i++) {
            System.out.print("Nombre del evento " + (i + 1) + ": ");
            String name = sc.nextLine();

            do {
                System.out.print("Numero de invitados [5-100]: ");
                inv = sc.nextInt();
                
            } while (inv < 5 || inv > 100);
            sc.nextLine();
            
            System.out.print("Telefono: ");
            String tel = sc.nextLine();
            
            System.out.print("Modo de evento: [0]boda [1]bautizo"
                    + " [2]cumpleanios [3]empresarial [4]otro: ");
            modo = sc.nextInt();
            sc.nextLine();
            System.out.println("");

            eventos.add(new Event(name, inv, tel, modo));
        }
        
        Event.ordenar(eventos);
        
        for (Event s : eventos) {
            System.out.println(s.eCosto());
            Event.CarlysMotto();
        }
        
    }
    
}
