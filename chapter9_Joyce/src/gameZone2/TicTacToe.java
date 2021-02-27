/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone2;

import java.util.Random;
import javax.swing.*;
// Pagina 530 del pdf
// Java Swing Pagina 122 del pdf
/**
 *
 * @author logra
 */
public class TicTacToe {
    
    private Character computadora;
    private Character jugador;
    private Tablero tablero;
    private Integer turnos;

    public TicTacToe() {
        this.tablero = new Tablero();
        this.computadora = 'O';
        this.jugador = 'X';
        this.turnos = 0;
    }
    
    public void tirarJugador(){
        Integer posicion = 0;
        do {
            String resp = JOptionPane.showInputDialog(null, "Elija la posicion donde quieres jugar\n" + 
                    this.tablero.showTablero(), "Input", JOptionPane.INFORMATION_MESSAGE);
            posicion = Integer.parseInt(resp);
        } while (!this.tablero.isVisitado(posicion));
        
        this.tablero.setMovimiento(jugador, posicion);
        this.turnos++;
    }
    
    public void tirarPc(){
        Random rd = new Random();
        Integer posicion = 0;
        do {
            posicion = rd.nextInt(9) + 1;
        } while (!this.tablero.isVisitado(posicion));
        
        this.tablero.setMovimiento(computadora, posicion);
        this.turnos++;
        this.showAfterPc();
    }
    
    public void showAfterJugador(){
        JOptionPane.showMessageDialog(null, "Tu movimiento se realizo" + "\nahora la computadora jugara"
                + "\n" + this.tablero.showTablero());
    }
    
    public void showAfterPc(){
        JOptionPane.showMessageDialog(null, "La computadora ya hizo su movimiento" + "\n" + this.tablero.showTablero());
    }
    
    public void mensajeInicial(){
        JOptionPane.showMessageDialog(null, "Bienvenido a TicTacToe" + "\nTu tendras la ficha X "
                + "y la computadora tendra la ficha O.");
    }
    
    public Boolean checarTablero(Integer res){
        if(res == 3){
            return true;
        }else{
            return false;
        }
    }
    
    public void resultado(){
        Integer opc = this.getTableroStatus();
        switch (opc) {
            case 1:
                JOptionPane.showMessageDialog(null, "Ganaste!" + "\n" + this.tablero.showTablero());
                break;
                
            case 2:
                JOptionPane.showMessageDialog(null, "Gano la computadora, suerte para la proxima!" + 
                        "\n" + this.tablero.showTablero());
                break;
                
            case 3:
                JOptionPane.showMessageDialog(null, "Empate! Booo" + "\n" + this.tablero.showTablero());
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Empate! Booo" + "\n" + this.tablero.showTablero());
        }
    }
    
    public Integer getTurnos(){
        return this.turnos;
    }
    
    public Integer getTableroStatus(){
        return this.tablero.isWon();
    }
}
