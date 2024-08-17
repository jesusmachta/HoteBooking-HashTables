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
public class Estado {
    private int num_habitacion;
    private String nombre;
    private String apellido;
    private String email;
    private String gender;
    private String celular;
    private int[] llegada;
    private Boolean checkedIn;
    private Boolean checkedOut;
    private Estado next;
    
    public Estado(int num_habitacion ,String nombre, String apellido, String email, String gender, String celular, int[] llegada, Boolean checkedIn){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.gender = gender;
        this.celular = celular;
        this.llegada = llegada;
        this.num_habitacion = num_habitacion;
        this.checkedIn = checkedIn;
        this.checkedOut = false;
    }

    public int getNum_habitacion() {
        return num_habitacion;
    }

    public void setNum_habitacion(int num_habitacion) {
        this.num_habitacion = num_habitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int[] getLlegada() {
        return llegada;
    }

    public void setLlegada(int[] llegada) {
        this.llegada = llegada;
    }
    
    public void checkIn(){
       this.checkedIn = true;
    }
    
    public void checkOut(){
       this.checkedOut = true;
    }
    
    public Boolean getCheckedIn(){
        return checkedIn;
    }
    
    public Boolean getCheckedOut(){
        return checkedOut;
    }

    public Estado getNext() {
        return next;
    }

    public void setNext(Estado next) {
        this.next = next;
    }
    
    public void print(){
        Object str = getNum_habitacion();
        if (getNum_habitacion() == -1){
            str = "No se ha asignado avitacion";
        }
        System.out.println("Habitacion: "+str+ ", Nombre: "+getNombre()+", Apellido: "+getApellido()+", Email: "+ getEmail() + ", Genero: "+getGender()+", Celular: "+getCelular()+", Llegada: "+llegada[0]+"/"+llegada[1]+"/"+llegada[2]);
    }
    
}
