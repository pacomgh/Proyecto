package proyecto;

import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Paco Guzmán
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    
    String [] opciones = {"Ingresar nuevo producto",
            "Ingresar nuevo registro de prod. existente",
            "Consultar"};   
    DataBaseStorage dbs;
    
    public String menuAccion(){               
        return (String)JOptionPane.showInputDialog(null,//contenedor del panel
                "Elija",//opciones de compra
                "Accion",//titulo panel
                -1,//opcion icono
                null,//new ImageIcon("src/images/shrek-wallpaper.jpg"),//imagen
                opciones,//opciones del menu
                opciones[0]);//opcion mas recomendable;        
    }
    
    public DataBaseStorage elegirAccion() throws SQLException{ 
        dbs = new DataBaseStorage();
        switch(menuAccion()){
            case "Ingresar nuevo producto":  
                String producto = JOptionPane.showInputDialog
                            ("Escribe el nombre del nuevo producto");                
                dbs.crearTabla(producto);
                break;
            case "Ingresar nuevo registro de prod. existente":
                dbs=new DataBaseStorage();
                String tipoProd = JOptionPane.showInputDialog
                            ("Ingresa el nombre del producto existente");
                String marca = JOptionPane.showInputDialog
                            ("Ingresa la marca");
                String modelo = JOptionPane.showInputDialog
                            ("Ingresa el modelo");
                String material = JOptionPane.showInputDialog
                            ("Ingresa el material del que esta hecho");
                String color = JOptionPane.showInputDialog
                            ("Ingresa el color del producto");
                int precio = Integer.parseInt(JOptionPane.showInputDialog
                            ("Ingresa el precio")); 
                dbs.insertar(marca, modelo, material, color, precio, tipoProd);            
                break;
            case "Consultar":
                String tabla = JOptionPane.showInputDialog
                            ("Ingresa el nombre del producto existente a "
                                    + "consultar");
                dbs.consultar(tabla);
                break;      
        }       
        return dbs;
    }
    
    public static void main(String[] args) {
        
        Proyecto e = new Proyecto();
        try{
        e.elegirAccion();
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        
    }
    
}
