package src.control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import src.entity.Cliente;

public class RegistrarClientes {

    public void RegistrarCliente(String nombreCliente,
            String email,
            String telefono,
            String fechaNacimiento,
            String productoComprado) throws IOException {
        String line = "";
        String cvsSplitBy = ",";
        String archivoCSV = "src\\data\\cliente.csv";

        Cliente instanciaCliente = new Cliente("src\\data\\cliente.csv");
        instanciaCliente.ValidarCliente();

        // Buscar nombreCliente repetido
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(cvsSplitBy);
                String codigo = data[0]; // asumiendo que email se encuentra en la segunda columna
                String codigo2 = data[1]; // asumiendo que el telefono esté en la tercera columna
                String codigo3 = data[2]; // asumiendo que fechaNacimiento se encuentre en la tercera columna

                if (codigo3.equals(fechaNacimiento) || codigo2.equals(telefono) || codigo.equals(email)) {
                    // coincidencia encontrada mostrar el resto de datos de la misma fila
                    JOptionPane.showMessageDialog(null, "Cliente ya existente");
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
        csvWriter.append(email);
        csvWriter.append(",");
        csvWriter.append(telefono);
        csvWriter.append(",");
        csvWriter.append(fechaNacimiento);
        csvWriter.append(",");
        csvWriter.append(productoComprado);
        csvWriter.append("\n");

        // Cerrar el objeto FileWriter
        csvWriter.close();
        // Monitoreo Terminal
        System.out.println("Inserccion Exitosa");
        JOptionPane.showMessageDialog(null, "Registro Exitoso");
    }
}