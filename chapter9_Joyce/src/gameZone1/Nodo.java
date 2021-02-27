/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone1;

/**
 *
 * @author logra
 */
public class Nodo{
    private String pregunta;
    private Nodo der;
    private Nodo izq;

    public Nodo(String pregunta) {
        this.pregunta = pregunta;
        this.der = null;
        this.izq = null;
    }
    
    

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
   
   
}
