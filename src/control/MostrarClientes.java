package src.control;

import java.io.*;

public class MostrarClientes {

    public String MostrarCliente(String nombre){
        String archivoCSV = "src\\data\\cliente.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(cvsSplitBy);
                String nombreCliente = data[0]; // asumiendo que el codigo se encuentra en la primera columna

                if (nombreCliente.equals(nombre)) {
                    // coincidencia encontrada mostrar el resto de datos de la misma fila
                    String email = data[1];
                    String telefono = data[2];
                    String fechaNacimiento = data[3];
                    String productoComprado = data[4];
                    return  "Nombre cliente: " + nombreCliente + 
                            "\nEmail: " + email + 
                            "\nTelefono: " + telefono + 
                            "\nFecha de nacimiento: " + fechaNacimiento +
                            "\nProducto comprado: " + productoComprado;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No encontrado";
    }
}
