
package proyecto;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Storage {
    
    public void crearTabla(String t, String nombre) throws SQLException;    
    public void crear(String t);
    public void insertar(int id, String marca, String modelo, String material, 
            Color color, float precio, String tipo, String nombre) throws SQLException;
    public void consultar(String n, String t) throws SQLException;
    //public void modificar();
    public ArrayList<String> descargar(String s);
    
    
}
