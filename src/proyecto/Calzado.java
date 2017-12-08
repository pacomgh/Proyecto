
package proyecto;

import java.awt.Color;

public class Calzado {
    
    private String material, color;
    
    
    Calzado(String color, String material){
        this.color=color;
        this.material=material;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }  

}
