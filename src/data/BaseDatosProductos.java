package src.data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BaseDatosProductos extends Exception {
    public String archivoCSV;

    public BaseDatosProductos(String archivoCSV){
        this.archivoCSV = archivoCSV;
    }

    public void CreateBD(){
        FileWriter archivo = null;
        try {
            File archivoComprobar = new File(archivoCSV);
            if(archivoComprobar.exists()){
                System.out.println("Archivo CSV existente");
            }else {
                archivo = new FileWriter(archivoCSV);
                // PrintWriter escritor = new PrintWriter(archivo);
                // escritor.close();
                System.out.println("Archivo CSV creado correctamente");
            }

        } catch (IOException e) {
            System.out.println("Error al crear el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }   finally {
            if (archivo != null) {
                try {
                    archivo.close();
                } catch (IOException e) {
                    // manejar excepciones...
                }
            }
        }
    }
    public String getArchivoCSV() {
        return archivoCSV;
    }

}
