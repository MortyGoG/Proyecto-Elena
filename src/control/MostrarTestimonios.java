package src.control;

import java.io.*;

public class MostrarTestimonios {

    public String MostrarTestimonio(String nombre){
        String archivoCSV = "src\\data\\testimonio.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(cvsSplitBy);
                String nombreCliente = data[0]; // asumiendo que el codigo se encuentra en la primera columna

                if (nombreCliente.equals(nombre)) {
                    // coincidencia encontrada mostrar el resto de datos de la misma fila
                    String fecha = data[1];
                    String productoServicio = data[2];
                    String comentario = data[3];
                    return  "Nombre cliente: " + nombreCliente + 
                            "\nFecha: " + fecha + 
                            "\nProducto/Servicio: " + productoServicio + 
                            "\nComentario: " + comentario;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No encontrado";
    }
}
