package br.com.fiap.cilindro;

import br.com.fiap.calculo.Volume;
import br.com.fiap.forma.Forma;

/**
 *
 * @author rm75179
 */
public class Cilindro extends Forma implements Volume{
    private double raio, altura;

    public Cilindro(int x, int y, double raio, double altura) {
        super(x, y);
        this.raio = raio;
        this.altura = altura;
    }
    
    @Override
    public String toString() {
        return super.toString()+"\n raio = "+raio+"\n altura = "+altura+"\n" ;
    }
    
    public double calcularArea() {
        return 0.0;
    }
    
    public double calculaVolume() {
        return 0.0;
    }

    @Override
    public double calcularVolume() {
       return 2+Math.PI*raio*altura+2*Math.PI*raio*altura; 
    }
    
    
}
