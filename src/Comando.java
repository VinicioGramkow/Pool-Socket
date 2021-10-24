
import java.util.ArrayList;

public abstract class Comando {

    protected String comando;
    protected static ArrayList<MinhaThread> threads = new ArrayList();

    public Comando(String comando) {
        this.comando = comando;
        this.init();
    }

    protected abstract boolean valida();
    
    protected abstract void init();
    
}
