/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone1;

import java.util.Scanner;

/**
 *
 * @author logra
 */
public class Arbol{
    
    private Nodo raiz;

    public Arbol() {
        this.raiz = new Nodo("Tiene piernas?");
        this.raiz.setIzq(new Nodo("Es un perro?"));
    }
    
    public void conversar(){
        Scanner sc = new Scanner(System.in);
        Nodo aux = this.raiz;
        Nodo ant = aux;
        String respuesta = "";
        
        while(aux != null){
            System.out.println(aux.getPregunta());
            System.out.print("Responde solo si o no: ");
            respuesta = sc.nextLine();
            
            ant = aux;
            if(respuesta.equals("si")){
                aux = aux.getIzq();
            }else{
                aux = aux.getDer();
            }
        }
        
        if(respuesta.equals("si")){
            System.out.print("Yay! Gane. Quieres jugar de nuevo? ");
            if(sc.nextLine().equals("si")){
                this.conversar();
            }
        }
        else{
            System.out.print("Me rindo. Que animal es? ");
            String animal = sc.nextLine();
            
            
            if(ant != raiz){
                System.out.print("Escribe una pregunta que sea si para " + getAnimal(ant.getPregunta()) 
                    + " y no para " + animal + ": ");
                Nodo nuevo = new Nodo(sc.nextLine());
                
                String temp = ant.getPregunta();
                ant.setPregunta(nuevo.getPregunta());
                nuevo.setPregunta(temp);
                ant.setIzq(nuevo);
            }
            else{
                Nodo nuevo = new Nodo("Es un " + animal + "?");
                this.raiz.setDer(nuevo);
            }
            
            System.out.print("Quieres jugar de nuevo? ");
            if(sc.nextLine().equals("si")){
                this.conversar();
            }
        }
    }
    
    private String getAnimal(String pregunta){
        String[] partes = pregunta.split(" ");
        String animal = partes[partes.length - 1];
        return animal.substring(0, animal.length() - 1);
    }
    
}
