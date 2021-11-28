package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    private final String HOST = "localhost";
    private final int PUERTO = 4321;
    private Socket socket;

    public Cliente() throws IOException {
        socket = new Socket(HOST, PUERTO);
    }

    public void iniciarCliente() throws IOException {
    	
    	//Iniciamos la entrada de datos
        DataInputStream entradaServidor = new DataInputStream(socket.getInputStream());
        System.out.println(entradaServidor.readUTF()); //Mostramos el mensaje por pantalla
        
        //Enviar 3 mensajes
        DataOutputStream salidaServidor = new DataOutputStream(socket.getOutputStream());
        for(int i =0;i<3;i++){
        
            salidaServidor.writeUTF("Este es el mensaje num: "+i);
           
        }
        salidaServidor.close();
        entradaServidor.close();
        socket.close();
    }
}
