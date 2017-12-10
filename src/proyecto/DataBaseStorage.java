
package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseStorage implements Storage {
    //en caso de que no conectea esta wea hacer la tabla normal desde services
    String driver = "org.apache.derby.jdbc.ClientDriver";
    //String urlDb = "jdbc:derby:src/DB/", tipo;
    String urlDb = "jdbc:derby://localhost:1527/calzado", tipo;
    Connection c;
    Statement st;
    ResultSet rs;
    ResultSetMetaData rsmd;    
    
    @Override
    public void crearTabla(String producto) throws SQLException{    
        
        try{
            Class.forName(driver);
            c = DriverManager.getConnection(urlDb);
            st = c.createStatement();
            //este podria ser un metodo crear tabla
            //c.createStatement();
            String creaTabla =
                "CREATE TABLE "+producto+" ( " +
                //"Id INTEGER NOT NULL, " +
                "Marca VARCHAR(20) NOT NULL, " +
                "Modelo VARCHAR(20 )NOT NULL, " +
                "Material VARCHAR(20 )NOT NULL," +
                "Color VARCHAR(20 )NOT NULL," +
                "Precio INTEGER NOT NULL" +
                ")";
            st.execute(creaTabla);
            c.close();
            
            System.out.println("La tabla "+producto+" ha sido creada");            
        }catch(SQLException ex){
            System.out.println("Error al crear la tabla "+producto+" "+ex.getMessage());
        }
        catch(java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }   
    }
    
    /*
    @Override
    public void crear(String nombre){        
        //revisar como hacer que el tipo 
        //this.tipo=tipo;
        try{
            Class.forName(driver);
            c = DriverManager.getConnection(urlDb+nombre+";create=true;");
            
            c.close();
            //
            System.out.println("La base de datos de "+nombre+" ha sido creada");            
        }catch(SQLException ex){
            System.out.println("Error al crear la base de datos"+ex.getMessage());
        }
        catch(java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }        
    } */   
    
    @Override
    //considerar cambiar el id a int
    public void insertar(String marca, String modelo, String material, 
                            String color, float precio, String tipo,
                            String nombre) throws SQLException{
        
        c = DriverManager.getConnection(urlDb);
        st = c.createStatement();
        //rs = st.executeQuery("SELECT * FROM "+tipo);
        //rsmd = rs.getMetaData();
        //int cantRegistros=rsmd.getColumnCount()/6;
        //ver como obtener la cantidad maxima de registros y asignarlos al id para que sea el nuevo ultimo registro
        //conecta a la vase de datos
        //c = DriverManager.getConnection(urlDb+nombre);
        //establecer la conexion y preguntar a cual tabla quiere hacer registro
        /*System.out.println("columnas");
        int cantRegistros=0, cant=0;
        
        if (rsmd.getColumnCount()!=0) {
            System.out.println(rsmd.getColumnCount());
            int columnas = rsmd.getColumnCount();
            //id = columnas;  

            for (int i = 1; i <= columnas; i++) {
                System.out.format("%10s", rsmd.getColumnName(i) + " || ");
                cant++;
            }           
            cantRegistros=cant/columnas;
            System.out.println("reistros"+cantRegistros);
        }        */        
        try{
            Class.forName(driver);
            //c = DriverManager.getConnection(urlDb);
            //agregar un ciclo con centinela para ingreso de datos
            //rs = st.executeQuery("SELECT * FROM "+tipo);
            st.execute("INSERT INTO "+tipo+" VALUES('"/*+(cantRegistros)+","*/+marca+"','"
                            +modelo+"', '"+material+"', '"+color+"', "+precio+")");
            //rs = st.executeQuery("SELECT * FROM APP."+tipo);
            //fuera del ciclo
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }  
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
       
    }
    
    @Override
    public void consultar(String tipo) throws SQLException{
        
        c = DriverManager.getConnection(urlDb);  
        st = c.createStatement();
        rs = st.executeQuery("select * from "+tipo);
        rsmd = rs.getMetaData();
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
            Class.forName(driver);
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
