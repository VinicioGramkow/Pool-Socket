
public class ComandoWait extends Comando {

    public ComandoWait(String comando) {
        super(comando);
    }

    @Override
    public boolean valida() {
        String[] array = this.comando.split(" ");

        if (array.length == 2) {
            return true;
        }
        return false;
    }

    @Override
    protected void init() {
        if (this.valida()) {
            for (MinhaThread thread : this.threads) {
                if (this.comando.split(" ")[1].equals(thread.getName())) {
                    if (thread.isAlive()) {
                        thread.setWait(true);
                    }
                }
            }
        } else {
            System.out.println("Comando errado");
        }
    }
}
