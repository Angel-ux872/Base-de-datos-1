/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package csv;

//Descarga librerias
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


public class CSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //Asigna el archivo a la variable que quieras poner, en mi caso archivo
      String archivo = "codigos_postales_hmo.csv";
      //map asigna a la variable conteo que sea Entero y cadena
        Map<String, Integer> conteo = new TreeMap<>();
      //Activa el archivo y lo lee, si hay una excepcion o falta el archivo, manda error 
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
      //La variable toma el valor que le da el archivo, si es nulo significa que ya no hay datos y termina
            while ((linea = br.readLine()) != null) {
      //agarra los valores y los acomoda como una tabla
                String[] columnas = linea.split(",");
                String codigoPostal = columnas[0].trim();
                conteo.put(codigoPostal, conteo.getOrDefault(codigoPostal, 0) + 1);
            }
       //Mensaje de error
        } catch (IOException e) {
            e.printStackTrace();
        }
       //imprime los codigos postales y cuenta los acentamientos
        for (Map.Entry<String, Integer> entrada : conteo.entrySet()) {
            System.out.println("Codigo postal:"+entrada.getKey() + " - Numero de acentamientos " + entrada.getValue());
        }
    }
    
}
