/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone2;

/**
 *
 * @author logra
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TicTacToe2 tablero1 = new TicTacToe2();
        
        tablero1.mensajeInicial();
        
        while (tablero1.getTurnos() < 10) {
            
            tablero1.tirarJugador();
            tablero1.showAfterJugador();
            if(!tablero1.checarTablero(tablero1.getTableroStatus())) break;
            
            tablero1.tirarPc();
            if(!tablero1.checarTablero(tablero1.getTableroStatus())) break;
        }
        
        tablero1.resultado();
        
    }
    
}
