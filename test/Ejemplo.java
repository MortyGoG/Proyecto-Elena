package test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


    public class Ejemplo {
        public static void main(String[] args){
            String archivoCSV = "datos.csv";
            try {
                FileWriter archivo = new FileWriter(archivoCSV);
                PrintWriter escritor = new PrintWriter(archivo);
    
                // Escribe las cabeceras de las columnas
                escritor.println("Nombre, Apellido, Edad");
    
                // Escribe algunos datos
                escritor.println("Juan, Perez, 25");
                escritor.println("Ana, Martinez, 30");
                escritor.println("Pedro, Garcia, 40");
    
                // Cierra el archivo
                escritor.close();
    
                System.out.println("Archivo CSV creado correctamente");
    
            } catch (IOException e) {
                System.out.println("Error al crear el archivo CSV: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

