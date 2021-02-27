/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caseProblem2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author logra
 */
public class RentalDemo {

    /**
     * @param args the command line arguments
     */   
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Rental> eventos = new ArrayList<>();
        int inv, equipo;
        
        for (int i = 0; i < 8; i++) {
            System.out.print("Nombre de contrato #" + (i + 1) + ": ");
            String name = sc.nextLine();
            
            do {
                System.out.print("Numero de minutos [60-7200]: ");
                inv = sc.nextInt();
            } while (inv < 60 || inv > 7200);
            
            
            sc.nextLine();
            
            System.out.print("Telefono: ");
            String tel = sc.nextLine();
            
            
            System.out.print("Equipo disponible: [0]jet ski [1]barco ponton [2]bote de remo "
                    + "\n[3]canoa [4]kayak [5]silla de playa [6]sombrilla [7]otro: ");
            equipo = sc.nextInt();
            sc.nextLine();
            System.out.println("");
            
            eventos.add(new Rental(name, inv, tel, equipo));
        }
        
        Rental.ordenar(eventos);
        System.out.print("\n");
        
        for (Rental r : eventos) {
            System.out.println(r.aPagar());
            Rental.SammysMotto();
        }

    }
    
}
