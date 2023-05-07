package src.control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
    
public class RegistrarProductos {
    
    public void RegistrarProducto(  String codigoOriginal,
                                    String descripcion, 
                                    double precio, 
                                    boolean Promocion,
                                    float precioPromocion,
                                    String fechaInicioPromocion,
                                    String fechaTerminoPromocion, 
                                    String beneficios,
                                    String archivoCSV) throws IOException {

        String line = "";
        String cvsSplitBy = ",";
        
        //Buscar codigo repetido
            try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

                while ((line = br.readLine()) != null) {
    
                    String[] data = line.split(cvsSplitBy);
                    String codigo = data[0]; // asumiendo que el codigo se encuentra en la primera columna
    
                    if (codigo.equals(codigoOriginal)) {
                        // coincidencia encontrada mostrar el resto de datos de la misma fila
                        JOptionPane.showMessageDialog(null, "Codigo ya existente");
                        return;
                    }
                }
    
            } catch (IOException e) {
                e.printStackTrace();
            }

        // Crear un objeto FileWriter en modo append para agregar al archivo CSV
        FileWriter csvWriter = new FileWriter(archivoCSV, true);

        // Escribir los valores del nuevo producto en una nueva línea del archivo CSV
        csvWriter.append(codigoOriginal);
        csvWriter.append(",");
        csvWriter.append(descripcion);
        csvWriter.append(",");
        csvWriter.append(Double.toString(precio));
        csvWriter.append(",");
        csvWriter.append(Boolean.toString(Promocion));
        csvWriter.append(",");
        csvWriter.append(Double.toString(precioPromocion));
        csvWriter.append(",");
        csvWriter.append(fechaInicioPromocion);
        csvWriter.append(",");
        csvWriter.append(fechaTerminoPromocion);
        csvWriter.append(",");
        csvWriter.append(beneficios);        
        csvWriter.append("\n");

        // Cerrar el objeto FileWriter
        csvWriter.close();
        //Monitoreo Terminal
        System.out.println("Inserccion Exitosa");
        JOptionPane.showMessageDialog(null, "Registro Exitoso");
    }
}