package br.com.fiap.circulo;

import br.com.fiap.calculo.Area;
import br.com.fiap.forma.Forma;

/**
 *
 * @author rm75179
 */
public class Circulo extends Forma implements Area{
    private final double raio;

    public Circulo(int x, int y, double raio) {
        super(x, y);
        this.raio = raio;
    }
    
    public String toString() {
        return super.toString()+"\n Raio = " + raio;
    }
    
    public double calculaArea(){
        return 0.0;
    }

    @Override
    public double calcularArea() {
       return Math.PI*raio*raio;
    }
}
