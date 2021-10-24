import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Servidor extends Thread {
    
    private BufferedReader Buffer;
      
    public Servidor(Socket conexao) {
        try {
            this.Buffer = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                String texto = this.Buffer.readLine();
                FactoryComando factory = new FactoryComando();
                factory.criarComando(texto);
            }        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
