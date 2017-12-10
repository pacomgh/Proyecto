package proyecto;

import java.io.BufferedOutputStream;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoAlmacen implements Almacen {
    
    Scanner leer;
    ArrayList<String> contenedor;
    FileInputStream fis;
    FileOutputStream fos;
    DataInputStream dis;
    DataOutputStream dos;
    File arch;
    String url="../Proyecto/src/Archivos/";
    
    @Override
    public void crear(String nombre){
        arch = new File(url+nombre+".dat");
        //crear un archivo para cada tipo de calzado
        if(arch.exists())
            System.out.println("El archivo ya existe");
        else{
            try(DataOutputStream dos=new DataOutputStream(new FileOutputStream
            (url+nombre+".dat"));){
                //dos = new DataOutputStream(new FileInputStream("../Proyecto/tenis.dat"));           
                System.out.println("Exito al crear archivo");

            }catch(IOException e){
                System.out.println("Error E/S");
            }
        }
    }
    
    @Override
    public void consultar(){}
    
    @Override
    public void registrar(String nombre){
        leer = new Scanner(System.in);
        String registro="", contenido;
        contenedor = new ArrayList();
        arch = new File(url+nombre+".dat");
        //crear un archivo para cada tipo de calzado
        if(arch.exists()){            
            try(DataOutputStream pluma=new DataOutputStream(new FileOutputStream
            (url+nombre+".dat"));){
                dis=new DataInputStream(new FileInputStream(url+nombre+".dat"));
                fos = new FileOutputStream(url+nombre+".dat");
                BufferedOutputStream bo = new BufferedOutputStream(fos);
                
                System.out.println("da la marca");
                registro+=leer.nextLine()+" || ";
                System.out.println("modelo");
                registro+=leer.nextLine()+" || ";
                //bo.
                
                /*while ((contenido=dis.readLine())!=null){
                    contenido=dis.readLine();
                    contenedor.add(contenido);
                    //System.out.println("contiene"+contenedor.get(0));
                }
                if(contenido==null){
                    if(contenedor.size()>0)
                        for(int i=0; i<=contenedor.size();i++)
                            pluma.writeUTF(contenedor.get(i));
                    System.out.println("da la marca");
                    registro+=leer.nextLine()+" || ";
                    System.out.println("modelo");
                    registro+=leer.nextLine()+" || ";
                    pluma.writeUTF(registro);                
                }       */
            pluma.close();               
            }catch(IOException e){
                System.out.println("Error E/S");
            }
            
        }
        else{
            System.out.println("El archivo no existe");
            
        }
    }
    
}
