
public class FactoryComando implements IFactoryComando {

    @Override
    public Comando criarComando(String comando) {
        Comando cmd = null;

        switch (comando.split(" ")[0]) {
            case "new"    -> cmd = new ComandoNew(comando);
            case "sleep"  -> cmd = new ComandoSleep(comando);
            case "wait"   -> cmd = new ComandoWait(comando);
            case "notify" -> cmd = new ComandoNotify(comando);
        }

        return cmd;
    }

}
