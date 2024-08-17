/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2_carrero_sisiruca_machta;

/**
 *
 * @author sisir
 */
public class NodoTree {
    private Historic cliente;
    private NodoTree izquierdo;
    private NodoTree derecho;
    private int altura;
  

    public NodoTree(Historic cliente) {
        this.cliente = cliente;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 1;
      
    }
    
    
    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    

    public Historic getCliente() {
        return cliente;
    }

    public void setCliente(Historic cliente) {
        this.cliente = cliente;
    }

    public NodoTree getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoTree izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoTree getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoTree derecho) {
        this.derecho = derecho;
    }
    
    
    
    
}