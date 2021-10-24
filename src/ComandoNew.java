
public class ComandoNew extends Comando {

    public ComandoNew(String comando) {
        super(comando);
    }

    @Override
    protected boolean valida() {
        String[] array = this.comando.split(" ");

        if (array.length == 4) {
            try {
                Integer.parseInt(array[2]);
                Integer.parseInt(array[3]);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
    
    public void init() {    
        if (this.valida()) {
            String[] parametros = this.comando.split(" ");
            MinhaThread thread = new MinhaThread(parametros[1], Integer.parseInt(parametros[2]), Integer.parseInt(parametros[3]));
            this.threads.add(thread);
            thread.start();
        } else {
            System.out.println("Comando errado");
        }
    }

}
