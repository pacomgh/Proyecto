
package proyecto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Storage {
    
    public void crearTabla(String producto) throws SQLException;    
    //public void crear(String t);
    public void insertar(String marca, String modelo, String material, 
            String color, float precio, String tipo, String nombre) throws SQLException;
    public void consultar(String t) throws SQLException;
    //public void modificar();
    public ArrayList<String> descargar(String s);
    
    
}
