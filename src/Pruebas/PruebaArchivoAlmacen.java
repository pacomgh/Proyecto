
package Pruebas;

import proyecto.ArchivoAlmacen;
import java.util.Scanner;

public class PruebaArchivoAlmacen {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArchivoAlmacen a = new ArchivoAlmacen();
        
        System.out.println("Ingresa el nombre del archivo a escribir");
        String nArchivo = leer.nextLine();
        //a.crear(nArchivo);
        
        a.registrar(nArchivo);
    }
    
}
