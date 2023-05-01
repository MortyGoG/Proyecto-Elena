package src.data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseDatos extends Exception {
    public String archivoCSV;

    public BaseDatos(String archivoCSV){
        this.archivoCSV = archivoCSV;
    }

    public void CreateBD(){
        try {
            File archivoComprobar = new File(archivoCSV);
            if(archivoComprobar.exists()){
                System.out.println("Archivo CSV existente");
            }else {
                FileWriter archivo = new FileWriter(archivoCSV);
                // PrintWriter escritor = new PrintWriter(archivo);
                // escritor.close();
                System.out.println("Archivo CSV creado correctamente");
            }

        } catch (IOException e) {
            System.out.println("Error al crear el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public String getArchivoCSV() {
        return archivoCSV;
    }

}
