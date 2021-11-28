package servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private final int PUERTO = 4321; //no va a cambiar
    private ServerSocket serverSocket;
    private Socket socket;
    
    //Definimos el constructor
    public Servidor() throws IOException {
        serverSocket = new ServerSocket(PUERTO); //Definimos la conexi�n
        socket = new Socket(); //Iniciamos el cliente
    }
    
    //Funci�n para iniciar la conexi�n
    public void iniciarServer() throws IOException {
        
    	//Vamos a aceptar los datos que llegar�n del cliente
    	while (true) {
            System.out.println("Esperando la conexion del cliente");
            socket = serverSocket.accept(); //guardamos la petici�n que llegue al servidor en socket
            // El servidor se queda a la espera de recibir peticiones
            
            //Al recibir la petici�n, iniciamos la conexi�n
            DataOutputStream mensajeCliente = new DataOutputStream(socket.getOutputStream());
            //Enviamos mensaje al cliente
            mensajeCliente.writeUTF("Petici�n recibida");
            
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
          
            String mensajeDeCliente;
            try {
                while (!(mensajeDeCliente = entrada.readUTF()).isEmpty()) 
                	//Mostramos el mensaje por pantalla
                	System.out.println(mensajeDeCliente);
            }catch (EOFException ex){
                System.out.println("Fin de la comunicaci�n");
            }
            System.out.println("Fin de la conexi�n");
            socket.close();
        }
    }

    public void finalizarServer() throws IOException {
        serverSocket.close();
    }

}
