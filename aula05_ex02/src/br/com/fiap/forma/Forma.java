package br.com.fiap.forma;

/**
 *
 * @author rm75179
 */
public abstract class Forma {
    private int x, y;

    public Forma(int coordenadaX, int coordenadaY) {
        this.x = coordenadaX;
        this.y = coordenadaY;
    }
    
    public String toString() {
        return "\nCoordenadas ->\n x="+x+"\n y="+y+"";
    }
}
