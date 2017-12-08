package Pruebas;

import proyecto.Sandalia;
import proyecto.Zapato;
import proyecto.Tenis;


public class PruebaCalzado {

    
    public static void main(String[] args) {
        //Color c, String m, String marca, String modelo
       
       Sandalia s = new Sandalia("azul","sintetico","Andrea","#123Crocx");
       
        System.out.println("color:"+s.getColor()+"\n"
                +"material: "+s.getMaterial()+"\n"
                +"marca: "+s.getMarca()+"\n"
                +"modelo: "+s.getModelo()+"\n");
        
        Zapato z = new Zapato("azul","sintetico","Andrea","#mocasin");
       
        System.out.println("color:"+z.getColor()+"\n"
                +"material: "+z.getMaterial()+"\n"
                +"marca: "+z.getMarca()+"\n"
                +"modelo: "+z.getModelo()+"\n");
        
        Tenis t = new Tenis("morado","piel","niky","#corredor");
       
        System.out.println("color:"+t.getColor()+"\n"
                +"material: "+t.getMaterial()+"\n"
                +"marca: "+t.getMarca()+"\n"
                +"modelo: "+t.getModelo());
    }
    
}
