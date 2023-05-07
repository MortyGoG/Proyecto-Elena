package src.control;

import java.io.*;
import javax.swing.JOptionPane;

public class BorrarProductos {
    
    public void BorrarProducto(String codigoOriginal){

        String archivoCSV = "src\\data\\producto.csv";
        String line = "";
        String cvsSplitBy = ",";
        boolean bandera = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(cvsSplitBy);
                String codigo = data[0]; // asumiendo que el codigo se encuentra en la primera columna

                if (codigo.equals(codigoOriginal)) {
                    //Encontramos el codigo
                    bandera = true;
                    continue;
                }
            }
            if(bandera == false){
                JOptionPane.showMessageDialog(null, "Producto inexistente");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        

         //Borrado de Linea
         try {
            BufferedReader br = new BufferedReader(new FileReader(archivoCSV));
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCSV + ".tmp")); //Archivo temporal
            line = "";
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String codigo = data[0]; // asumiendo que el código se encuentra en la primera columna
                
                if (codigo.equals(codigoOriginal)) {
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
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}