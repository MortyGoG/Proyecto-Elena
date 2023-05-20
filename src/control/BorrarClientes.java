package src.control;

import java.io.*;
import javax.swing.JOptionPane;

import src.entity.Cliente;

public class BorrarClientes {
    
    public void BorrarCliente(String nombreCliente){

        String archivoCSV = "src\\data\\cliente.csv";
        String line = "";
        String cvsSplitBy = ",";
        boolean bandera = false;
        Cliente instanciaCliente = new Cliente("src\\data\\cliente.csv");
        instanciaCliente.ValidarCliente();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(cvsSplitBy);
                String nombre = data[0]; // asumiendo que el nombre se encuentra en la primera columna

                if (nombre.equalsIgnoreCase(nombreCliente)) {
                    //Encontramos el nombre
                    bandera = true;
                    continue;
                }
            }
            if(bandera == false){
                JOptionPane.showMessageDialog(null, "Cliente inexistente");
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
                String nombre = data[0]; // asumiendo que el nombre se encuentra en la primera columna
                
                if (nombre.equals(nombreCliente)) {
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
            JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}