package src.control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class RegistrarTestimonios {

    public void RegistrarTestimonio(String nombreCliente,
                                    String fecha,
                                    String productoServicio,
                                    String comentario) throws IOException {

        String line = "";
        String cvsSplitBy = ",";
        String archivoCSV = "src\\data\\testimonio.csv";
        String clienteCSV = "src\\data\\cliente.csv";

        // Buscar nombreCliente repetido
        try (BufferedReader br = new BufferedReader(new FileReader(clienteCSV))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(cvsSplitBy);
                String nombre = data[0]; // asumiendo que el nombreCliente se encuentra en la primera columna

                if (nombre.equals(nombreCliente)) {
                    // coincidencia encontrada mostrar el resto de datos de la misma fila
                    continue;
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente inexistente");
                    return;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear un objeto FileWriter en modo append para agregar al archivo CSV
        FileWriter csvWriter = new FileWriter(archivoCSV, true);

        // Escribir los datos del nuevo cliente en una nueva línea del archivo CSV
        csvWriter.append(nombreCliente);
        csvWriter.append(",");
        csvWriter.append(fecha);
        csvWriter.append(",");
        csvWriter.append(productoServicio);
        csvWriter.append(",");
        csvWriter.append(comentario);
        csvWriter.append("\n");

        // Cerrar el objeto FileWriter
        csvWriter.close();
        // Monitoreo Terminal
        System.out.println("Inserccion Exitosa");
        JOptionPane.showMessageDialog(null, "Registro Exitoso");
    }
}