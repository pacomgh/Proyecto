
package proyecto;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseStorage implements Storage {
    
    String urlDb = "jdbc:derby://localhost:1527/", tipo;
    Connection c;
    Statement st;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    @Override
    public void crearTabla(String tipo, String nombre) throws SQLException{ 
        st = c.createStatement();
        try{
            c = DriverManager.getConnection(urlDb+nombre);
            //este podria ser un metodo crear tabla
            c.createStatement();
            String creaTabla =
                "CREATE TABLE "+tipo+" ( " +
                "Id INTEGER NOT NULL, " +
                "Marca VARCHAR(20) NOT NULL, " +
                "Modelo VARCHAR(20 )NOT NULL, " +
                "Material VARCHAR(20 )NOT NULL," +
                "Color VARCHAR(20 )NOT NULL," +
                "Precio INTEGER NOT NULL" +
                ")";
            st.execute(creaTabla);
            c.close();
            //
            System.out.println("La tabla "+tipo+" ha sido creada");            
        }catch(SQLException ex){
            System.out.println("Error al crear la tabla "+tipo+" "+ex.getMessage());
        }
    
    }
    
    @Override
    public void crear(String nombre){
        //revisar como hacer que el tipo 
        //this.tipo=tipo;
        try{
            c = DriverManager.getConnection(urlDb+nombre+";create=true;");
            //este podria ser un metodo crear tabla
            /*c.createStatement();
            String creaTabla =
                "CREATE TABLE "+tipo+" ( " +
                "Id"+tipo+"INTEGER(20) NOT NULL, " +
                "Marca VARCHAR(20) NOT NULL, " +
                "Modelo VARCHAR(20 )NOT NULL" +
                "Material VARCHAR(20 )NOT NULL" +
                "Color VARCHAR(20 )NOT NULL" +
                "Precio INTEGER NOT NULL" +
                ")";
            st.execute(creaTabla);*/
            //c.close();
            //
            System.out.println("La base de datos de "+nombre+" ha sido creada");            
        }catch(SQLException ex){
            System.out.println("Error al crear la base de datos"+ex.getMessage());
        }        
    }    
    
    @Override
    //considerar cambiar el id a int
    public void insertar(int id, String marca, String modelo, String material, 
                            Color color, float precio, String tipo,
                            String nombre) throws SQLException{
        //ver como obtener la cantidad maxima de registros y asignarlos al id para que sea el nuevo ultimo registro
        //conecta a la vase de datos
        //c = DriverManager.getConnection(urlDb+nombre);
        //establecer la conexion y preguntar a cual tabla quiere hacer registro
        int columnas = rsmd.getColumnCount();
        //id = columnas;
        int cantRegistros=1;
        
        for (int i = 1; i <= columnas; i++) {
            System.out.format("%15s", rsmd.getColumnName(i) + " || ");
            cantRegistros++;
        }
        id=cantRegistros;
        
        try{
            c = DriverManager.getConnection(urlDb+nombre);
            //agregar un ciclo con centinela para ingreso de datos
            st.executeQuery("INSERT INTO "+tipo+"VALUES("+(id+1)+","+marca+","
                            +modelo+","+material+","+color+","+precio+")");
            //fuera del ciclo
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }             
    }
    
    @Override
    public void consultar(String nombre, String tipo) throws SQLException{

        c = DriverManager.getConnection(urlDb+nombre);       
        
        int columnas = rsmd.getColumnCount();
        //mandar estos datos a un panel
        for (int i = 1; i <= columnas; i++) {
            System.out.format("%15s", rsmd.getColumnName(i) + " || ");
        }
        
        while (rs.next()) {
            //Imprimimos cada una de las filas de la tabla
            System.out.println("");
            for (int j = 1; j <= columnas; j++) {
                 System.out.format("%15s", rs.getString(j) + " || ");
            }
        }
 
        if (st != null)  
            st.close();
        if (c != null)  
            c.close();    
    }
    
    @Override
    public ArrayList<String> descargar(String s){
        ArrayList al = new ArrayList();        
        //Connection        
        try{
            c=DriverManager.getConnection("jdbc:derby:"+s);
            System.out.println("Casi listo");
            /*ResultSet */rs = c.createStatement().executeQuery("Select * from "+tipo);
            while(rs.next()){
                al.add(rs.getString("nombre"));
            }
        }catch(Exception w){
            System.out.println("Ha ocurrido un error "+w.getMessage());
        
        }
        return al;        
    }    
}
