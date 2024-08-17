/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_carrero_sisiruca_machta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author acarr
 */
public class HashTableEstadoActual {
    private Estado[] array_estado;
    private int size;
    
    public HashTableEstadoActual(){
        this.size = 2000;
        this.array_estado = new Estado[size];
    }

    public Estado[] getArray_reservas() {
        return array_estado;
    }

    public void setArray_reservas(Estado[] array_reservas) {
        this.array_estado = array_reservas;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int hashFunction(Estado cliente){
        String cliente_nom = cliente.getNombre()+cliente.getApellido();
        int index = 0;
        for (int i = 0; i < cliente_nom.length(); i++) {
            int contador = cliente_nom.codePointAt(i);
            index += cliente_nom.codePointAt(i);
            index = index + (contador * i);
        }
        index = index % this.getSize();
        return index;
    }
    
    public int hashFunctionString(String nombre_apellido){
        String cliente_nom = nombre_apellido;
        int index = 0;
        for (int i = 0; i < cliente_nom.length(); i++) {
            int contador = cliente_nom.codePointAt(i);
            index += cliente_nom.codePointAt(i);
            index = index + (contador * i);
        }
        index = index % this.getSize();
        return index;
    }
    
    public int hashFunction2(Estado c){
        int hash = 0;
        int p = 31;
        int m = 1000000009;
        String str = c.getNombre();
        System.out.println(str);
        for (int i = 0; i < str.length() ; i++) {
            hash = (int)((hash + (long)Math.pow(p, i) * str.charAt(i)) % m);
        }
    return hash % getSize();
    }
    public int hashFunction3(Reserva c) {
        String s = c.getNombre();
        int hashValue = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char d = s.charAt(i);
            hashValue = (hashValue * 31 + d) % getSize();
        }
        return hashValue;
    }
    public boolean isInHash(Estado c){
        boolean aux = false;
        for (int i = 0; i < this.getArray_reservas().length; i++) {
            if ( getArray_reservas()[i] != null){
                if ( getArray_reservas()[i].getNombre() == c.getNombre() && getArray_reservas()[i].getApellido() == c.getApellido()){
                    aux = true;
                }
            }
        }
        return aux;
    }
    
    
    public void initHashTableEstado(){
        HashTableEstadoActual aux = new HashTableEstadoActual(); // revisar 
        String line;
        String clientes_txt = "";
        String path = "test\\estado.txt";
        File file = new File(path);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    clientes_txt += line + "\n";
                }
            }
            if (!"".equals(clientes_txt)) {
                String[] clientes_split = clientes_txt.split("\n");
                
                for (int i = 1; i < clientes_split.length; i++) {
                        String[] Cliente = clientes_split[i].split(",");
                        
                        Boolean checkedIn;
                        int num_habitacion = i;
                        if ("".equals(Cliente[0])){
                           checkedIn = false;
                        } else { checkedIn = true; }                
                        
                        String primer_nombre = Cliente[1];
                        String apellido = Cliente[2];
                        String email = Cliente[3];
                        String genero = Cliente[4];
                        String celular = Cliente[5];
                        String[] llegada_aux = Cliente[6].split("/");
                        int[] llegada = new int[]{Integer.parseInt(llegada_aux[0]),Integer.parseInt(llegada_aux[1]),Integer.parseInt(llegada_aux[2])};
         
                        Estado nuevo_cliente = new Estado(num_habitacion, primer_nombre, apellido, email, genero, celular, llegada, checkedIn);
                        int index1 = hashFunction(nuevo_cliente);
                       // nuevo_cliente.print();
    
                      
                        insertEstado(nuevo_cliente, index1);
                        
                }
               
            }
            br.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar base de Datos");
        }
    }
        
    public void insertCliente(Estado c, int index){
        if (!isInHash(c)) {
            while ( getArray_reservas()[index] != null) {
                index++;
            }
           // JOptionPane.showMessageDialog(null, "La clave del cliente reservado es " + c.getNombre()+" "+c.getApellido()+ " es: " + index);
            getArray_reservas()[index] = c;
        } else{
            JOptionPane.showMessageDialog(null, "¡ERROR!\nEl documento ya está registrado");
        }
    }
    
    public void insertEstado(Estado cliente, int index) {
        if (this.array_estado[index] == null) {
            this.array_estado[index] = cliente;
        } else {
            Estado pointer = array_estado[index];
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(cliente);
        }
    }
    
    public Estado getEstado(String nombre, String apellido) {
        int index = hashFunctionString(nombre+apellido);
        Estado pointer = array_estado[index];
        while (pointer != null) {
            if (pointer.getNombre().equals(nombre) && pointer.getApellido().equals(apellido)) {
                return pointer;
            }
            pointer = pointer.getNext();
        }
        return null;
    }
     
}
