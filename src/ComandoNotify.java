
public class ComandoNotify extends Comando {

    public ComandoNotify(String comando) {
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
                    synchronized (thread) {
                        if (thread.isAlive()) {
                            thread.setWait(false);
                            thread.notify();
                        }
                    }
                }
            }
        } else {
            System.out.println("Comando errado");
        }
    }

}
