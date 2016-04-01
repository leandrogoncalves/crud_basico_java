package aula05_ex02;

import br.com.fiap.cilindro.Cilindro;
import br.com.fiap.circulo.Circulo;
import br.com.fiap.forma.Forma;
import br.com.fiap.ponto.Ponto;
import javax.swing.JOptionPane;

/**
 *
 * @author rm75179
 */
public class Aula05_ex02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Forma[] f = new Forma[3];
//        Relacionamento "é um" atraves da herança permite armazenas os objetos da classe filha na classe mãe
        f[0] = new Cilindro(180, 90, 50, 20);
        f[1] = new Circulo(180, 90, 50);
        f[2] = new Ponto(180, 90);
        
        JOptionPane.showMessageDialog(null, imprimir(f));
    }
    
    
    public static String imprimir(Forma[] f) {
        String msg = "";
        for (Forma i : f) {
            if (i instanceof Cilindro) {
                msg += "\nCilindro:\n";
            }else if(i instanceof Circulo){
                msg += "\nCurculo:\n";
            }else if (i instanceof Ponto) {
                msg += "\n\nPonto:\n";
            }
            
            msg += i;
        }
        return msg;
    }
}
