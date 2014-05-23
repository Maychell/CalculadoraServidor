/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author maychell
 */
public class CalculadoraSocketThread extends Thread {
    private final Socket socket;
    public CalculadoraSocketThread(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Calculadora calc = new Calculadora(in);
            calc.executar();
            calc.enviar(out);
            out.close();
            in.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
