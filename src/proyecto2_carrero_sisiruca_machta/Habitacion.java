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
public class Habitacion {
    private int num;
    private String tipo;
    private int piso;
    private Estado cliente_actual;
    private Historico historial;
    
    
    public Habitacion(int num, String tipo, int piso){
        this.num = num;
        this.tipo = tipo;
        this.piso = piso;
        this.cliente_actual = null;
        this.historial = null;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Estado getCliente_actual() {
        return cliente_actual;
    }

    public void setCliente_actual(Estado cliente_actual) {
        this.cliente_actual = cliente_actual;
    }

    public Historico getHistorial() {
        return historial;
    }

    public void setHistorial(Historico historial) {
        this.historial = historial;
    }
    
    
    
}
