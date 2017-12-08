
package proyecto;

import java.awt.Color;

public class Tenis extends Calzado {
    
    private String modelo, marca;
        
    public Tenis(String c, String m, String marca, String modelo){
    super(c,m);
    this.modelo=modelo;
    this.marca=marca;
    }   

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }
}
