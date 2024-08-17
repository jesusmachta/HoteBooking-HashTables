/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2_carrero_sisiruca_machta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author sisir
 */
public class BinarySearchTree {
    private NodoTree raiz;

    public BinarySearchTree() {
        this.raiz = null;
    }

    public NodoTree getRaiz() {
        return raiz;
    }

    public void insertar(Historic dato) {
        NodoTree nuevoNodo = new NodoTree(dato);

        if (raiz == null) {
            raiz = nuevoNodo;
        } else {
            NodoTree nodoActual = raiz;
            NodoTree padre;

            while (true) {
                padre = nodoActual;

                if (dato.getRoomNumber() < nodoActual.getCliente().getRoomNumber()) {
                    nodoActual = nodoActual.getIzquierdo();

                    if (nodoActual == null) {
                        padre.setIzquierdo(nuevoNodo);
                        return;
                    }
                } else {
                    nodoActual = nodoActual.getDerecho();

                    if (nodoActual == null) {
                        padre.setDerecho(nuevoNodo);
                        return;
                    }
                }
            }
        }
    }

    public String printHistoryRoom(int numHabitacion) {
        String str = "";
        NodoTree nodoClient = raiz;
        int count = 0;

        while (nodoClient != null) {
            if (nodoClient.getCliente().getRoomNumber() == numHabitacion) {
                Historic pointer = nodoClient.getCliente();
                while (pointer != null){
                count ++;
                str += "\nCliente n."+count+"\n";
                str += "Nombre: "+pointer.getFirstName()+" "+ pointer.getLastName()+"\n";
                str += "Cedula: "+pointer.getDni()+"\n";
                str += "Email: " + pointer.getEmail() +"\n";
                str += "Genero: " + pointer.getGender()+"\n";
                str += "Fecha de llegada: "+ pointer.getCheckIn()+"\n";
                pointer = (Historic) pointer.getNext();
                }
            }

            if (numHabitacion < nodoClient.getCliente().getRoomNumber()) {
                nodoClient = nodoClient.getIzquierdo();
            } else {
                nodoClient = nodoClient.getDerecho();
            }
        }
        return str;
    }
    
    public Historic buscar(int num_hab) {
        NodoTree nodoActual = raiz;
        
        while (nodoActual != null) {
            if (num_hab < nodoActual.getCliente().getRoomNumber()) {
                nodoActual = nodoActual.getIzquierdo();
            } else if (num_hab > nodoActual.getCliente().getRoomNumber()) {
                nodoActual = nodoActual.getDerecho();
            } else {
                return nodoActual.getCliente();
            }
        }
        return null;
    }
    
    public void initABB_Historial(){
        ABB_Reserva Reservas = new ABB_Reserva();
        String line;
        String historico_txt = "";
        String path = "test\\historial.txt";
        File file = new File(path);
   
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    historico_txt += line + "\n";
                }
            }
            if (!"".equals(historico_txt)) {
                String[] historico_split = historico_txt.split("\n");

                for (int i = 0; i < historico_split.length; i++) {
                    String[] Cliente = historico_split[i].split(",");
                        
                    String dni = Cliente[0].replace(".", "");
                    String firstName = Cliente[1];
                    String lastName = Cliente[2];
                    String email = Cliente[3];
                    String gender = Cliente[4];
                    String checkIn = Cliente[5];
                    int roomNumber = Integer.parseInt(Cliente[6].trim());
                    
                    Historic cliente = new Historic(dni, firstName, lastName, email, gender, checkIn, roomNumber);
                    if (buscar(roomNumber) != null){
                        Historic C_anterior = buscar(roomNumber);
                        while (C_anterior.getNext() != null){
                            C_anterior = (Historic) C_anterior.getNext();
                        }
                        C_anterior.setNext(cliente);
                    } else {
                        agregar(cliente);}
                    
         
                   

                }               
            }
            br.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar base de Datos");
        }
    }
    
    public void agregar(Historic historico){
        this.raiz = agregarRec(raiz, historico);
    }
    
    private NodoTree agregarRec(NodoTree nodo, Historic cliente_historico) {
        if (nodo == null) {
            return new NodoTree(cliente_historico);
        } else if (cliente_historico.getRoomNumber() < nodo.getCliente().getRoomNumber()) {
            nodo.setIzquierdo(agregarRec(nodo.getIzquierdo(), cliente_historico));
        } else {
            nodo.setDerecho(agregarRec(nodo.getDerecho(), cliente_historico));
        }
        
        int alturaIzquierdo = (nodo.getIzquierdo() != null) ? nodo.getIzquierdo().getAltura() : 0;
        int alturaDerecho = (nodo.getDerecho() != null) ? nodo.getDerecho().getAltura() : 0;
        
        int factorBalance = alturaIzquierdo - alturaDerecho;
        
        if (factorBalance > 1) {
            if (cliente_historico.getRoomNumber() < nodo.getIzquierdo().getCliente().getRoomNumber()) {
                nodo = rotacionDerecha(nodo);
            } else {
                nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
                nodo = rotacionDerecha(nodo);
            }
        } else if (factorBalance < -1) {
            if (cliente_historico.getRoomNumber() > nodo.getDerecho().getCliente().getRoomNumber()) {
                nodo = rotacionIzquierda(nodo);
            } else {
                nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
                nodo = rotacionIzquierda(nodo);
            }
        }
        
        nodo.setAltura(Math.max(alturaIzquierdo, alturaDerecho) + 1);
       
        return nodo;
    }
    
    private NodoTree rotacionIzquierda(NodoTree nodo) {
        NodoTree nuevoNodo = nodo.getDerecho();
        nodo.setDerecho(nuevoNodo.getIzquierdo());
        nuevoNodo.setIzquierdo(nodo);
        
        nodo.setAltura(Math.max((nodo.getIzquierdo() != null) ? nodo.getIzquierdo().getAltura() : 0,
                                (nodo.getDerecho() != null) ? nodo.getDerecho().getAltura() : 0) + 1);
        nuevoNodo.setAltura(Math.max(nodo.getAltura(),
                                     (nuevoNodo.getDerecho() != null) ? nuevoNodo.getDerecho().getAltura() : 0) + 1);
        
        return nuevoNodo;
    }
    
    private NodoTree rotacionDerecha(NodoTree nodo) {
        NodoTree nuevoNodo = nodo.getIzquierdo();
        nodo.setIzquierdo(nuevoNodo.getDerecho());
        nuevoNodo.setDerecho(nodo);
        
        nodo.setAltura(Math.max((nodo.getIzquierdo() != null) ? nodo.getIzquierdo().getAltura() : 0,
                                (nodo.getDerecho() != null) ? nodo.getDerecho().getAltura() : 0) + 1);
        nuevoNodo.setAltura(Math.max(nodo.getAltura(),
                                     (nuevoNodo.getIzquierdo() != null) ? nuevoNodo.getIzquierdo().getAltura() : 0) + 1);
        
        return nuevoNodo;
    }
}
