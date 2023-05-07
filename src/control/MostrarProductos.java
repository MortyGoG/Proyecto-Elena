package src.control;

import java.io.*;

public class MostrarProductos {

    public String MostrarProducto(String codigoBuscado){
        String archivoCSV = "src\\data\\producto.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(cvsSplitBy);
                String codigo = data[0]; // asumiendo que el codigo se encuentra en la primera columna

                if (codigo.equals(codigoBuscado)) {
                    // coincidencia encontrada mostrar el resto de datos de la misma fila
                    String descripcion = data[1];
                    String precio = data[2];
                    String promocion = data[3];
                    String precioPromocion = data[4];
                    String fechaInicioPromocion = data[5];
                    String fechaTerminoPromocion = data[6];
                    String beneficios = data[7];
                    return  "Codigo: " + codigo + 
                            "\nDescripcion: " + descripcion + 
                            "\nPrecio: " + precio + 
                            "\nPromocion: " + promocion +
                            "\nPrecio Promocion: " + precioPromocion +
                            "\nFecha Inicio Promocion: " + fechaInicioPromocion +
                            "\nFecha Termino Promocion: " + fechaTerminoPromocion +
                            "\nBeneficios: " + beneficios;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No encontrado";
    }
}
