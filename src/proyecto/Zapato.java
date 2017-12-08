
package proyecto;

import java.awt.Color;

public class Zapato extends Calzado {
    private String modelo, marca;
        
    public Zapato(String c, String m, String marca, String modelo){
    super(c,m);
    this.marca=marca;
    this.modelo=modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }
    
    
}
