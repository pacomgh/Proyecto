
package Pruebas;

import java.awt.Color;
import java.sql.SQLException;
import proyecto.DataBaseStorage;
import java.util.Scanner;

public class PruebaDataBase {

    public static void main(String[] args) throws SQLException {
        Scanner leer = new Scanner(System.in);
        DataBaseStorage db = new DataBaseStorage();
        
        String nombreDB, nombre="", producto="", tipoCalzado="", marca="", 
                modelo="", material="", color="";
        int precio;
        
        System.out.println("Que deseas hacer? \n"
                //+ "1)Crear base de datos\n"
                + "1)Ingresar nuevo producto\n"
                + "2)Ingresar un registro\n"
                + "3)consultar");
        int opc = leer.nextInt();        
        
        switch(opc){
            /*
            case 1:
                leer.nextLine();
                System.out.println("Ingresa el nombre para la base de datos");
                nombreDB = leer.nextLine();
                db.crear(nombreDB);                
                break;*/
            case 1:
                leer.nextLine();
                //System.out.println("Ingresa el nombre de la base de datos para registrar producto");
                //nombre = leer.nextLine();
                System.out.println("Ingresa el nombre del producto de calzado a registrar");
                producto=leer.nextLine();

                db.crearTabla(producto);
                break;
            case 2:
                leer.nextLine();
                //System.out.println("Ingresa el nombre para la base de datos");
                //nombreDB = leer.nextLine();
                
                System.out.println("crear registro");
        
                System.out.println("ingresa el nombre del producto");
                tipoCalzado = leer.nextLine();
                System.out.println("ingresa marca");
                marca = leer.nextLine();
                System.out.println("ingresa modelo");
                modelo = leer.nextLine();
                System.out.println("ingresa material");
                material = leer.nextLine();
                System.out.println("ingresa color");
                color = leer.nextLine();
                System.out.println("ingresa precio");
                precio = leer.nextInt();

                db.insertar(marca, modelo, material, color, precio, tipoCalzado, nombre);
                break;
            case 3:
                leer.nextLine();
                //System.out.println("Ingresa el nombre para la base de datos");
                //nombreDB = leer.nextLine();
                System.out.println("ingresa la tabla");
                tipoCalzado = leer.nextLine();
                
                db.consultar(tipoCalzado);
                break;
                               
        
        }
        
        
        
        
        
        
        
        
        
        //tring marca, String modelo, String material, 
          //                  Color color, float precio, String tipo,
            //                String nombre
        
        //db.consultar();
    }
    
}
