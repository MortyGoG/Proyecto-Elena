package src.control;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ModificarClientes {
    
    public void ModificarCliente(   String nombreBuscado,
                                    String nombreCliente, 
                                    String email, 
                                    String telefono, 
                                    String fechaNacimiento,
                                    String productoComprado) throws IOException {
        
        String archivoCSV = "src\\data\\cliente.csv";
        String line = "";
        String cvsSplitBy = ",";
        
        //Buscar codigo repetido
        if(!nombreBuscado.equals(nombreCliente)){
            try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

                while ((line = br.readLine()) != null) {
    
                    String[] data = line.split(cvsSplitBy);
                    String codigo = data[0]; // asumiendo que el codigo se encuentra en la primera columna
    
                    if (codigo.equals(nombreBuscado)) {
                        // coincidencia encontrada mostrar el resto de datos de la misma fila
                        JOptionPane.showMessageDialog(null, "Codigo ya existente");
                        return;
                    }
                }
    
            } catch (IOException e) {
                e.printStackTrace();
            }
    
        }
        
        //Borrado de Linea
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivoCSV));
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCSV + ".tmp")); //Archivo temporal
            line = "";
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String codigo = data[0]; // asumiendo que el código se encuentra en la primera columna
                
                if (codigo.equals(nombreCliente)) {
                    // Saltar la línea que se va a reemplazar
                    continue;
                }
                bw.write(line); //Copiar la linea de .csv a .tmp
                bw.newLine(); //Nueva Linea
            }
            //Cerrar todo
            br.close();
            bw.close();

            // Eliminar el archivo original
            if (!new File(archivoCSV).delete()) {
                System.out.println("No se pudo eliminar el archivo original.");
                return;
            }

            // Renombrar el archivo temporal al nombre del archivo original
            if (!new File(archivoCSV + ".tmp").renameTo(new File(archivoCSV))) {
                System.out.println("No se pudo renombrar el archivo temporal.");
            }

            System.out.println("Línea eliminada exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Ahora Agregamos la modificacion
        // Crear un objeto FileWriter en modo append para agregar al archivo CSV
        FileWriter csvWriter = new FileWriter(archivoCSV, true);

        // Escribir los valores del nuevo producto en una nueva línea del archivo CSV
        csvWriter.append(nombreBuscado);
        csvWriter.append(",");
        csvWriter.append(email);
        csvWriter.append(",");
        csvWriter.append(telefono);
        csvWriter.append(",");
        csvWriter.append(fechaNacimiento);
        csvWriter.append(",");
        csvWriter.append(productoComprado);

        // Cerrar el objeto FileWriter
        csvWriter.close();
        //Monitoreo Terminal
        System.out.println("Inserccion Exitosa");
        JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
    }
}
