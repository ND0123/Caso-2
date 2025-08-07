/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso.pkg2;

import caso.pkg2.Habitacion;
import javax.swing.JOptionPane;

/**
 *
 * @author Laboratorio
 */

public class HotelReservas {

    private Habitacion[][] hotel;
    private int pisos;
    private int HabitacionesPorPiso;

    public HotelReservas(int pisos, int HabitacionesPorPiso) {
        this.pisos = pisos;
        this.HabitacionesPorPiso = HabitacionesPorPiso;
        hotel = new Habitacion[pisos][HabitacionesPorPiso];
        precargarHabitaciones();

    }
    //La precarga de habitaciones con datos de ejemplo
    private void precargarHabitaciones() {
        int numero = 101;
        
        for (int i = pisos - 1; i >= 0; i--) {
            for (int j = 0; j < HabitacionesPorPiso; j++) {
                String tipo;
                if (j == 0 || j == 2 || j == 4) {
                    tipo = "Simple";

                } else {
                    tipo = "Doble";

                }
                double precio;
                if (tipo.equals("Simple")) {
                    precio = 40;
                } else {
                    precio = 60;

                }
                String estado;
                if (j == HabitacionesPorPiso - 1) {
                    estado = "Sucia";
                }else if (j == 1){
                    estado = "Ocupada";

                }else{
                    estado = "Libre";
                }
                hotel[i][j] = new Habitacion(numero, tipo, precio, estado);
                numero++;
            }
        }
    }
    //ESTE METODO MUESTRA TODAS LAS HABITACIONES DEL HOTEL 
    private void mostrarHabitaciones() {
        String salida = "";
        for (int i = 0; i < pisos; i++) {
            salida += "Piso" + (pisos - i) + "\n";
            for (int j = 0; j < HabitacionesPorPiso; j++) {
                salida += hotel[i][j].toString() + "\n";

            }
        }
        JOptionPane.showMessageDialog(null, salida);
    }
    //COMO EL NOMBRE LO DICE, PERMITE MODIFICAR UNA HABITACION SEGUN SU NUMERO
    private void modificarHabitacion() {
        int numBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de habitacion a modificar (Ejemplo: 101 - 125): "));
        for (int i = 0; i < pisos; i++) {
            for (int j = 0; j < HabitacionesPorPiso; j++) {
                if (hotel[i][j].getNumero() == numBuscar) {
                    String nuevoTipo = JOptionPane.showInputDialog("Nuevo tipo (Simple o Doble): ");
                    double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio: "));
                    String nuevoEstado = JOptionPane.showInputDialog("Nuevo estado (Libre, Ocupado o Sucia): ");
                    hotel[i][j].setTipo(nuevoTipo);
                    hotel[i][j].setPrecio(nuevoPrecio);
                    hotel[i][j].setEstado(nuevoEstado);
                    JOptionPane.showMessageDialog(null, "Habitacion actualizada con exito");
                    return;
                }

            }

        }
        JOptionPane.showMessageDialog(null, "Habitacion no encontrada, intente de nuevo");

    }
    //MUESTRA UN RESUMEN DEL ESTADO DEL HOTEL
    private void mostrarResumen() {
        int libres = 0, ocupadas = 0, sucias = 0;
        double ganancia = 0;
        
                    for (int i = 0; i < pisos; i++) {
                        for (int j = 0; j < HabitacionesPorPiso; j++) {
                            Habitacion h = hotel[i][j];
                            if(h != null){
                             String estado= h.getEstado();
                              if(estado.equalsIgnoreCase("Libre")){
                              libres++;
                        }else if (estado.equalsIgnoreCase("Ocupada")){
                        ocupadas++;
                        ganancia += h.getPrecio();
            
        }else if (estado.equalsIgnoreCase("Sucia")){
            sucias++;
                    }
                }

            }

        }
       
        //MOSTRAR RESUMEN 
        String resumen = "Resumen del hotel: \n" + "Total de habitaciones: " +(pisos * HabitacionesPorPiso) + "\n" + "Habitaciones Libres: " + libres + "\n" + "Habitaciones Ocupadas: " + ocupadas + "\n" + "Habitaciones Sucias: " + sucias + "\n" + "Ganancia total: $" + ganancia;
        JOptionPane.showMessageDialog(null, resumen);

    }
// este es el metodo principal del sistema en donde muestra el menu al usuario
    public void iniciar() {
        int opcion = 0;
        while (opcion != 4) {
            String menu = "Hotel SC-202\n" + "1. Ver todas las habitaciones\n" + "2. Modificar habitacion\n" + "3. Resumen del hotel\n" + "4. Salir del sistema del hotel";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            if (opcion == 1) {
                mostrarHabitaciones();
            } else if (opcion == 2) {
                modificarHabitacion();
            } else if (opcion == 3) {

                mostrarResumen();
            } else if (opcion == 4) {
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
            } else {
                JOptionPane.showMessageDialog(null, "Opcion invalida, intente nuevamente");

            }

        }
    }

    public Habitacion[][] getHotel() {
        return hotel;
    }

    public void setHotel(Habitacion[][] hotel) {
        this.hotel = hotel;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public int getHabitacionesPorPiso() {
        return HabitacionesPorPiso;
    }

    public void setHabitacionesPorPiso(int HabitacionesPorPiso) {
        this.HabitacionesPorPiso = HabitacionesPorPiso;
    }

    @Override
    public String toString() {
        return "HotelReservas{" + "hotel=" + hotel + ", pisos=" + pisos + ", HabitacionesPorPiso=" + HabitacionesPorPiso + '}';
    }

}
