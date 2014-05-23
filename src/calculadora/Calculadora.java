/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author maychell
 */
public class Calculadora {

    private float n1;
    private float n2;
    private char operacao;
    private float resultado;
    public Calculadora(DataInputStream in) throws IOException {
        n1 = in.readFloat();
        n2 = in.readFloat();
        operacao = in.readChar();
    }
    public float executar() {
        float resultado = 0;
        if(operacao == '+') {
            resultado = n1+n2;
        }
        if(operacao == '-') {
            resultado = n1-n2;
        }
        if(operacao == '/') {
            resultado = n1/n2;
        }
        if(operacao == 'x') {
            resultado = n1*n2;
        }
        return resultado;
    }
    public void enviar(DataOutputStream out) throws IOException {
        out.writeFloat(resultado);
    }
}
