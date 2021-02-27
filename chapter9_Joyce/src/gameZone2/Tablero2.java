/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone2;

import java.util.Random;

/**
 *
 * @author logra
 */
public class Tablero2 {
    
    private Character[][] tablero;

    public Tablero2() {
        Character[][] tab = {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
        this.tablero = tab;
    }
    
    public void setMovimiento(Character ficha, Integer posicion){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(this.tablero[i][j] == Integer.toString(posicion).charAt(0)){
                    this.tablero[i][j] = ficha;
                }
            }
        }
    }
    
    public Boolean isVisitado(Integer posicion){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(this.tablero[i][j] == Integer.toString(posicion).charAt(0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public String showTablero(){
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tab.append(tablero[i][j] + " ");
            }
            tab.append("\n");
        }
        return tab.toString();
    }
    
    public Integer isWon(){
        Integer winner = 0;
        
        if(this.tablero[0][0] == 'X' && this.tablero[0][0] == this.tablero[0][1] && this.tablero[0][0] == this.tablero[0][2]//condiciones de gane horizontales
        || this.tablero[1][0] == 'X' && this.tablero[1][0] == this.tablero[1][1] && this.tablero[1][0] == this.tablero[1][2]//condiciones de gane horizontales
            || this.tablero[2][0] == 'X' && this.tablero[2][0] == this.tablero[2][1] && this.tablero[2][0] == this.tablero[2][2]//condiciones de gane horizontales

            || this.tablero[0][0] == 'X' && this.tablero[0][0] == this.tablero[1][0] && this.tablero[0][0] == this.tablero[2][0]//condiciones de gane verticales
            || this.tablero[0][1] == 'X' && this.tablero[0][1] == this.tablero[1][1] && this.tablero[0][1] == this.tablero[2][1]//condiciones de gane verticales
            || this.tablero[0][2] == 'X' && this.tablero[0][2] == this.tablero[1][2] && this.tablero[0][2] == this.tablero[2][2]//condiciones de gane verticales

            || this.tablero[0][0] == 'X' && this.tablero[0][0] == this.tablero[1][1] && this.tablero[0][0] == this.tablero[2][2]//condiciones de gane diagonales
            || this.tablero[0][2] == 'X' && this.tablero[0][2] == this.tablero[1][1] && this.tablero[0][2] == this.tablero[2][0])//condiciones de gane diagonales

        {
            winner = 1;
            return winner;
        }

        else if(this.tablero[0][0] == 'O' && this.tablero[0][0] == this.tablero[0][1] && this.tablero[0][0] == this.tablero[0][2]//condiciones de gane horizontales
        || this.tablero[1][0] == 'O' && this.tablero[1][0] == this.tablero[1][1] && this.tablero[1][0] == this.tablero[1][2]//condiciones de gane horizontales
        || this.tablero[2][0] == 'O' && this.tablero[2][0] == this.tablero[2][1] && this.tablero[2][0] == this.tablero[2][2]//condiciones de gane horizontales

        || this.tablero[0][0] == 'O' && this.tablero[0][0] == this.tablero[1][0] && this.tablero[0][0] == this.tablero[2][0]//condiciones de gane verticales
        || this.tablero[0][1] == 'O' && this.tablero[0][1] == this.tablero[1][1] && this.tablero[0][1] == this.tablero[2][1]//condiciones de gane verticales
        || this.tablero[0][2] == 'O' && this.tablero[0][2] == this.tablero[1][2] && this.tablero[0][2] == this.tablero[2][2]//condiciones de gane verticales

        || this.tablero[0][0] == 'O' && this.tablero[0][0] == this.tablero[1][1] && this.tablero[0][0] == this.tablero[2][2]//condiciones de gane diagonales
        || this.tablero[0][2] == 'O' && this.tablero[0][2] == this.tablero[1][1] && this.tablero[0][2] == this.tablero[2][0])//condiciones de gane diagonales

        {
            winner = 2;
            return winner;
        }
        else{
            winner = 3;
            return winner;
        }
    }
    
    public void tirarPro(Character ficha){
        
        if(this.tablero[0][0] == 'O' && this.tablero[0][0] == this.tablero[0][1]){
            this.tablero[0][2] = ficha;//condiciones de gane horizontales
        }
        
        else if(this.tablero[1][0] == 'O' && this.tablero[1][0] == this.tablero[1][1]){
            this.tablero[1][2] = ficha;//condiciones de gane horizontales
        }
        
        else if(this.tablero[2][0] == 'O' && this.tablero[2][0] == this.tablero[2][1]){
            this.tablero[2][2] = ficha;//condiciones de gane horizontales
        }
        
        else if(this.tablero[0][0] == 'O' && this.tablero[0][0] == this.tablero[1][0]){
            this.tablero[2][0] = ficha;//condiciones de gane verticales
        }
        
        else if(this.tablero[0][1] == 'O' && this.tablero[0][1] == this.tablero[1][1]){
            this.tablero[2][1] = ficha;//condiciones de gane verticales
        }
        
        else if(this.tablero[0][2] == 'O' && this.tablero[0][2] == this.tablero[1][2]){
            this.tablero[2][2] = ficha;//condiciones de gane verticales
        }           

        else if(this.tablero[0][0] == 'O' && this.tablero[0][0] == this.tablero[1][1]){
            this.tablero[2][2] = ficha;//condiciones de gane diagonales
        }
                    
        else if(this.tablero[0][2] == 'O' && this.tablero[0][2] == this.tablero[1][1]){
            this.tablero[2][0] = ficha;
        }
        else{
            Random rd = new Random();
            Integer posicion = 0;
            do {
                posicion = rd.nextInt(9) + 1;
            } while (!this.isVisitado(posicion));

            this.setMovimiento('O', posicion);
        }

    }
    
}
