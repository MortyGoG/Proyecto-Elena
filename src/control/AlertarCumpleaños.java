package src.control;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AlertarCumpleaños {

    public String AlertarCumpleaño() {
        List<String> clientesCumpleanios = new ArrayList<>();

        String line = "";
        String cvsSplitBy = ",";
        String archivoCSV = "src\\data\\cliente.csv";
        // Buscar
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(cvsSplitBy);
                String aux = data[3];
                String[] partes = aux.split("/");
                String fechaDia = partes[0]; // Obtenemos fecha dia
                String fechaMes = partes[1]; // Obtenemos fecha mes

                String nombre = data[0];
                String fechaFinal = fechaDia + "/" + fechaMes;

                if (fechaFinal.equals(FechaActual())) {
                    // Monitoreo
                    System.out.println("Condicional ejecutado");
                    System.out.println(FechaActual());
                    clientesCumpleanios.add(nombre);
                }
            }

            StringBuilder resultado = new StringBuilder("Cumpleaños del Día:\n");
            for (String nombre : clientesCumpleanios) {
                resultado.append(nombre).append("\n");
            }
        return resultado.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Ninguna alerta";
    }

    public String FechaActual() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Definir el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM");

        // Formatear la fecha actual en el formato deseado
        String fechaFormateada = fechaActual.format(formato);

        return fechaFormateada;
    }
}
