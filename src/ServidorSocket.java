import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {

    public static void main(String[] args) throws IOException {
        
        try (ServerSocket servidor = new ServerSocket(7000)) {
            while (true) {
                Socket conexao          = servidor.accept();
                Servidor ThreadServidor = new Servidor(conexao);
                ThreadServidor.start();
            }
        } catch (IOException ex) {
            System.out.println("Algo errado aconteceu");
        }
    }

}
