
package Pruebas;

import java.awt.Color;
import java.sql.SQLException;
import proyecto.DataBaseStorage;
import java.util.Scanner;

public class PruebaDataBase {

    public static void main(String[] args) throws SQLException {
        Scanner leer = new Scanner(System.in);
        DataBaseStorage db = new DataBaseStorage();
        System.out.println("Ingresa el nombre para la base de datos");
        String nombreDB = leer.nextLine();
        db.crear(nombreDB);
        
        System.out.println("Ingresa el nombre de la base de datos a consultar");
        String nombre = leer.nextLine();
        System.out.println("Ingresa el nombre del tipo de calzado a registrar");
        String tipo=leer.nextLine();
        
        db.crearTabla(tipo, nombre);
        
        System.out.println("crear registro");
        
        
        
        //int id, String marca, String modelo, String material, 
          //                  Color color, float precio, String tipo,
            //                String nombre
        
        //db.consultar();
    }
    
}
