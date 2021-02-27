/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone3;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author logra
 */
public class FullDeck2 {
    
    private ArrayList<Card2> mazo;
    private Integer tam;
    private Integer score_jugador;
    private Integer score_pc;
    private Integer empates;

    public FullDeck2() {
        this.mazo = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            Card2 card = new Card2();
            card.setSuit();
            card.setValor();
            this.mazo.add(card);
        }
        this.tam = 52;
        this.score_jugador = 0;
        this.score_pc = 0;
        this.empates = 0;
    }
    
    public Integer getTam(){
        return this.tam;
    }
    
    public void imprimirMazo(){
        for (int i = 0; i < 52; i++) {
            Card2 copia = this.mazo.get(i);
            System.out.print("Carta " + (i + 1) + ": ");
            copia.showCard();
            this.mazo.set(i, copia);
        }
    }
    
    public Card2 pickRandomCart(){
        Random rd = new Random();
        int index = rd.nextInt(this.mazo.size());
        Card2 temp = this.mazo.get(index);
        this.mazo.remove(index);
        this.tam = this.mazo.size();
        return temp;
    }
    
    public static boolean changeCard(Card2 a, Card2 b){
        if(a.getSuit() == b.getSuit()){
            b.setSuit();
            return true;
        }
        else{
            return false;
        }
    }
    
    public void winWar(Card2 a, Card2 b){
        if(a.getValor() > b.getValor() && changeCard(a, b) == false){
            System.out.println("\nJugador gano!\n");
            this.score_jugador++;
        }
        else if(a.getValor() < b.getValor() && changeCard(a, b) == false){
            System.out.println("\nComputadora gano!\n");
            this.score_pc++;
        }
        else{
            changeCard(a, b);
            System.out.println("\nEmpate!\n");
            this.empates++;
        }
    }
    
    public String resultados(){
        return String.format("\nJugador gano: %d\nPC gano: %d\nEmpates: %d", 
                this.score_jugador, this.score_pc, this.empates);
    }
    
}
