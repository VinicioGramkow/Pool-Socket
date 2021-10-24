
public class MinhaThread extends Thread {
    
    private boolean sleep;
    private boolean wait;
    private long    time;
    private int     fibonacci;
    private int     vezes;

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }

    public void setTime(long time) {
        this.time = time;
    }    
    
    public MinhaThread(String name, int fibonacci, int vezes) {
        this.setName(name);
        this.fibonacci = fibonacci;
        this.vezes     = vezes;
    }
    
    @Override
    public synchronized void run() {
        Fibonacci fib = new Fibonacci();
        for (int i = 0; i < vezes; i++) {
            if (this.sleep) {
                try {
                    Thread.currentThread().getName();
                    Thread.sleep(this.time);
                } catch (InterruptedException ex) { }
            }
            if (this.wait) {
                try {     
                    this.wait();
                } catch (InterruptedException ex) { }
            }
            System.out.println("Fibonacci de " + this.fibonacci + " = " + fib.fibonacci(this.fibonacci));
        }
    }    
    
}
