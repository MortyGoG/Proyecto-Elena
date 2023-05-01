package src.control;

import java.io.FileWriter;
import java.io.IOException;
    
public class RegistrarProductos {
    
    public void RegistrarProducto(  String codigo,
                                    String descripcion, 
                                    double precio, 
                                    boolean Promocion,
                                    float precioPromocion,
                                    String fechaInicioPromocion,
                                    String fechaTerminoPromocion, 
                                    String beneficios,
                                    String archivoCSV) throws IOException {
        
        // Crear un objeto FileWriter en modo append para agregar al archivo CSV
        FileWriter csvWriter = new FileWriter(archivoCSV, true);

        // Escribir los valores del nuevo producto en una nueva línea del archivo CSV
        csvWriter.append(codigo);
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
        System.out.println("Inserccion Exitosa");
    }
}