package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maychell
 */
public class CalculadoraSocketTest extends TestCase {
    private static final String IP = "localhost";
    private static final int PORTA = 777;
    private Socket socket;
    private OutputStream out;
    private InputStream in;
    
    @Override
    protected void setUp() throws Exception {
        socket = new Socket(IP, PORTA);
        out = socket.getOutputStream();
        in = socket.getInputStream();
    }
    
    public void testSoma() throws IOException {
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        out.writeFloat(4);
        out.writeFloat(5);
        out.flush();
        float soma = in.readFloat();
        System.out.println("Soma: " + soma);
        assertEquals(9, soma);
    }
    
    public void testSubtracao() throws IOException {
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        out.writeFloat(9);
        out.writeFloat(5);
        out.flush();
        float subtracao = in.readFloat();
        System.out.println("Subtração: " + subtracao);
        assertEquals(4, subtracao);
    }
    
    public void testMultiplicacao() throws IOException {
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        out.writeFloat(4);
        out.writeFloat(5);
        out.flush();
        float multiplicacao = in.readFloat();
        System.out.println("Multiplicação: " + multiplicacao);
        assertEquals(20, soma);
    }
    
    public void testDivisao() throws IOException {
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        out.writeFloat(4);
        out.writeFloat(2);
        out.flush();
        float divisao = in.readFloat();
        System.out.println("Divisão: " + divisao);
        assertEquals(2, divisao);
    }
    
    @Override
    protected void tearDown() throws Exception {
        out.close();
        in.close();
        socket.close();
    }
}
