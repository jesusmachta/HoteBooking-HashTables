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
public class ListaHabitacion {
    private Habitacion headpiso1;
    private Habitacion headpiso2;
    private Habitacion headpiso3;
    private Habitacion headpiso4;
    private Habitacion headpiso5;
    private Habitacion headpiso6;
    private Habitacion headpiso7;
    private Habitacion headpiso8;
    private Habitacion headpiso9;
    private Habitacion headpiso10;
    private int num_habitaciones;
    
    public ListaHabitacion(){
        this.headpiso1 = null;
        this.headpiso2 = null;
        this.headpiso3 = null;
        this.headpiso4 = null;
        this.headpiso5 = null;
        this.headpiso6 = null;
        this.headpiso7 = null;
        this.headpiso8 = null;
        this.headpiso9 = null;
        this.headpiso10 = null;
        this.num_habitaciones = 0;
    }
    
    public void initlistaHabitaciones(){
        String line;
        String habitaciones_txt = "";
        String path = "test\\habitaciones.txt";
        File file = new File(path);
   
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    habitaciones_txt += line + "\n";
                }
            }
            if (!"".equals(habitaciones_txt)) {
                String[] habitaciones_split = habitaciones_txt.split("\n");

                for (int i = 1; i < habitaciones_split.length; i++) {
                        String[] habitacion = habitaciones_split[i].split(",");
                        
                        int num = Integer.parseInt(habitacion[0]);
                        String tipo_habitacion = habitacion[1];
                        String piso = habitacion[2];
                        
                       // Habitacion nueva_habitacion = new Habitacion(num, tipo_habi);
                        
                        String email = habitacion[3];
                        String genero = habitacion[4];
                        String tipo_hab = habitacion[5];
                        String celular = habitacion[6];
                        String[] llegada_aux = habitacion[7].split("/");
                        int[] llegada = new int[]{Integer.parseInt(llegada_aux[0]),Integer.parseInt(llegada_aux[1]),Integer.parseInt(llegada_aux[2])};
                        String[] salida_aux = habitacion[8].split("/");
                        int[] salida = new int[]{Integer.parseInt(salida_aux[0]),Integer.parseInt(salida_aux[1]),Integer.parseInt(salida_aux[2])};
         
                    //    Reserva nuevo_cliente = new Reserva(cedula, primer_nombre, apellido, email, genero, tipo_hab, celular, llegada, salida);
                       
                      //  nuevo_cliente.printCliente();
                     //   agregar(nuevo_cliente);

                }               
            }
            br.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar base de Datos");
        }
    }
}
