/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_carrero_sisiruca_machta;

/**
 *
 * @author acarr
 */
public class Nodo {
    private Reserva reservacion;
    private Nodo izquierdo;
    private Nodo derecho;
    private int altura;
    
    public Nodo(Reserva reservacion) {
        this.reservacion = reservacion;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 1;
    }
    
    public Reserva getReserva() {
        return reservacion;
    }
    
    public Nodo getIzquierdo() {
        return izquierdo;
    }
    
    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }
    
    public Nodo getDerecho() {
        return derecho;
    }
    
    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
    
    public int getAltura() {
        return altura;
    }
    
    public void setAltura(int altura) {
        this.altura = altura;
    }
}
