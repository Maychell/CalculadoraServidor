/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author maychell
 */
public class CalculadoraSocket {
    private static final int porta = 777;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("Socket aberto na porta 777");
        while (true) {            
            System.out.println("Esperando resposta...");
            Socket socket = serverSocket.accept();
            System.out.println("Conectado");
            new CalculadoraSocketThread(socket).start();
        }
    }
}
