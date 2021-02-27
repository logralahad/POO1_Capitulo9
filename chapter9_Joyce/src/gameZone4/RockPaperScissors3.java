/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone4;

import java.util.Scanner;

/**
 *
 * @author logra
 */
public class RockPaperScissors3 {

    private Integer jugador;
    private Integer computadora;
    private Jugada tipo_jugada;
    private Boolean valido;
    private Integer score_jugador;
    private Integer score_pc;
    private Integer empates;
    
    public RockPaperScissors3(){
        this.score_jugador = 0;
        this.score_pc = 0;
        this.empates = 0;
    }

    public void resultado() {
        if (this.jugador == this.computadora) {
            System.out.print("Empate, jueguen otra vez!\n\n");
            this.empates++;
        }
        else if ((this.jugador == 1 && this.computadora == 3) ||(this.jugador == 2 && this.computadora == 1) 
                ||(this.jugador == 3 && this.computadora == 2)  ){
            System.out.print("Gano el jugador!\n\n");
            this.score_jugador++;
        }
        else if ((this.jugador == 1 && this.computadora == 2) || (this.jugador == 2 && this.computadora == 3) 
                || (this.jugador == 3 && this.computadora == 1)){
            System.out.print("Perdio el jugador!\n\n");
            this.score_pc++;
        }

    }

    private void setJugador() {
        if(this.tipo_jugada == Jugada.PIEDRA){
            this.jugador = 1;
        }
        else if(this.tipo_jugada == Jugada.PAPEL){
            this.jugador = 2;
        }
        else if(this.tipo_jugada == Jugada.TIJERAS){
            this.jugador = 3;
        }
        else{
            this.jugador = 0;
        }
        this.setComputadora();
    }

    public Integer getComputadora() {
        return computadora;
    }

    private void setComputadora() {
        this.computadora = (int)(Math.random() * 3 + 1);
    }
    
    public Jugada getTipoJugada(){
        return this.tipo_jugada;
    }
    
    public Boolean getValido(){
        return this.valido;
    }
    
    public Integer getScoreJugador(){
        return this.score_jugador;
    }
    
    public Integer getScorePC(){
        return this.score_pc;
    }
    
    public Integer getEmpates(){
        return this.empates;
    }
    
    public void setTipoJugada(String jugada){
        if(jugada.startsWith("pi") || jugada.startsWith("pI") || jugada.startsWith("Pi") || jugada.startsWith("PI")){
            this.tipo_jugada = Jugada.PIEDRA;
            this.valido = true;
        }
        else if(jugada.startsWith("pa") || jugada.startsWith("pA") || jugada.startsWith("Pa") || jugada.startsWith("PA")){
            this.tipo_jugada = Jugada.PAPEL;
            this.valido = true;
        }
        else if(jugada.startsWith("ti") || jugada.startsWith("tI") || jugada.startsWith("Ti") || jugada.startsWith("TI")){
            this.tipo_jugada = Jugada.TIJERAS;
            this.valido = true;
        }else{
            this.tipo_jugada = Jugada.INVALIDO;
            this.valido = false;
        }
        this.setJugador();
    }
    
    public static Jugada jugada(Integer var){
        switch (var) {
            case 1:
                return Jugada.PIEDRA;
            
            case 2:
                return Jugada.PAPEL;
                
            case 3:
                return Jugada.TIJERAS;
                
            default:
                return Jugada.INVALIDO;
        }
    }
}



