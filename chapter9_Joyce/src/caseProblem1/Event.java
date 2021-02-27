/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caseProblem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author logra
 */
public class Event{
    
    public final static int ALTO_PRECIO = 35;
    public final static int BAJO_PRECIO = 32;
    public final static int TIPO_EVENTO = 50;
    public final static String[] MODOS = {"boda", "bautizo", "cumpleanios", "empresarial", "otro"};
    
    private String evento;
    private Integer num_inv;
    private Integer costo;
    private Integer costo_por_persona;
    private Boolean tam_evento;
    private String telefono;
    private Integer modo_evento;
    
    public Event(){
        this("A000", 0, "0000000000", 4);
    }

    public Event(String evento, Integer num_inv, String telefono, Integer modo_evento) {
        setEvento(evento);
        this.num_inv = num_inv;
        setTam_evento();
        this.costo_por_persona = this.costo / this.num_inv;
        setTelefono(telefono);
        setModoEvento(modo_evento);
    }

    private void setTam_evento() {
        if(num_inv >= TIPO_EVENTO){
            this.costo = num_inv * BAJO_PRECIO;
            this.tam_evento = true;
        }else{
            this.costo = num_inv * ALTO_PRECIO;
            this.tam_evento = false;
        }
    }
    
    public void setEvento(String evento) {
        if(this.isDigits(evento.substring(1))){
            if((evento.charAt(0) >= 'A' && evento.charAt(0) <= 'Z')){
                this.evento = evento;
            }else if((evento.charAt(0) >= 'a' && evento.charAt(0) <= 'z')){
                this.evento = evento.substring(0,1).toUpperCase() + evento.substring(1);
            }
        }
        else{
            this.evento = "A000";
        }
    }

    public void setNum_inv(Integer num_inv) {
        this.num_inv = num_inv;
        setTam_evento();
    }
    
    public void setTelefono(String telefono){
        if(telefono.length() != 10){
            this.telefono = "0000000000";
        }
        else{
            for (int i = 0; i < telefono.length(); i++) {
                if(telefono.charAt(i) < '0' && telefono.charAt(i) > '9'){
                    telefono = telefono.replace(telefono.charAt(i), '\0');
                }
            }
            this.telefono = telefono;
        }
    }
    
    public void setModoEvento(Integer modo_evento){
        if(modo_evento > (MODOS.length - 1)){
            this.modo_evento = MODOS.length - 1;
        }else{
            this.modo_evento = modo_evento;
        }
    }
    
    public Boolean getTam_evento() {
        return tam_evento;
    }

    public String getEvento() {
        return evento;
    }

    public Integer getNum_inv() {
        return num_inv;
    }

    public Integer getCosto() {
        return costo;
    }

    public Integer getCosto_por_persona() {
        return costo / num_inv;
    }
    
    public String getTelefono(){
        String tel = String.format("(%s) %s-%s", this.telefono.substring(0, 3), 
                this.telefono.substring(3, 6), this.telefono.substring(6));
        return tel;
    }
    
    public Integer getModoEvento(){
        return this.modo_evento;
    }
    
    public String getTipoEvento(){
        return MODOS[this.modo_evento];
    }
    
    public Boolean isLargeEvent(){
        return tam_evento;
    }
    
    private Boolean isDigits(String digits){
        if(digits.length() < 3) return false;
        else if(digits.charAt(0) >= '0' && digits.charAt(0) <= '9'){
            if (digits.charAt(1) >= '0' && digits.charAt(1) <= '9') {
                if(digits.charAt(2) >= '0' && digits.charAt(2) <= '9'){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void CarlysMotto(){
        System.out.println("\n*************************");
        System.out.println("*   Carly’s makes the   *");
        System.out.println("*    food that makes    *");
        System.out.println("*      it a party!      *");
        System.out.print("*************************\n");
    }
    
    public String eCosto(){
        String s1 = String.format("Evento: %s\nNum. de invitados: %d\nPrecio por invitado: $%d\nTelefono: %s\n", 
                this.evento, this.num_inv, this.costo_por_persona, this.getTelefono());
        String s2 = String.format("Evento grande: %b\nCosto total: $%d\nModo de evento: %s", 
                isLargeEvent(), this.costo, this.getTipoEvento());
        
        return String.format("\n%s%s", s1, s2);
    }

    public static Comparator<Event> EventNameComparator 
            = new Comparator<Event>() {

        public int compare(Event e1, Event e2) {
          String evento1 = e1.getEvento();
          String evento2 = e2.getEvento();
          return evento1.compareTo(evento2);

        }
    };
    
    public static Comparator<Event> EventGuestsComparator 
            = new Comparator<Event>() {

        public int compare(Event e1, Event e2) {
          Integer evento1 = e1.getNum_inv();
          Integer evento2 = e2.getNum_inv();
          return evento1 - evento2;

        }
    };
    
    public static Comparator<Event> EventTypeComparator 
            = new Comparator<Event>() {

        public int compare(Event e1, Event e2) {
          String evento1 = e1.getTipoEvento();
          String evento2 = e2.getTipoEvento();
          return evento1.compareTo(evento2);

        }
    };
    
    public static void ordenar(ArrayList<Event> eve){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nModos de ordenamiento: [0]Por nombre de evento  "
                + "\n[1]Por numero de invitados  [2]Por tipo de evento: ");
        int opc = sc.nextInt();
        switch (opc) {
            case 0:
                Collections.sort(eve, Event.EventNameComparator);
                break;
                
            case 1:
                Collections.sort(eve, Event.EventGuestsComparator);
                break;
                
            case 2:
                Collections.sort(eve, Event.EventTypeComparator);
                break;
                
            default:
                Collections.sort(eve, Event.EventGuestsComparator);
        }
    }
}
