
public class ComandoSleep extends Comando {

    public ComandoSleep(String comando) {
        super(comando);
    }

    @Override
    public boolean valida() {
        String[] array = this.comando.split(" ");

        if (array.length == 3) {
            try {
                Integer.parseInt(array[1]);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    @Override
    protected void init() {
        if (this.valida()) {
            for (MinhaThread thread : this.threads) {
                if (this.comando.split(" ")[2].equals(thread.getName())) {
                    if (thread.isAlive()) {
                        thread.setSleep(true);
                        thread.setTime(Long.parseLong(this.comando.split(" ")[1]));
                    }
                }
            }
        } else {
            System.out.println("Comando errado");
        }
    }

}
