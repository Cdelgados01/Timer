
package timer;

/**
 *
 * @author cdelg
 */

public class Horas extends Thread {
    
    private volatile boolean running = true;

    public void resetThread() {
        Timer.setHours(0);
    }

    static int flag;

    public Horas(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int hours = 0;      
        while (true){                
            System.out.println("Cambio efectuado " + flag);            
            if (flag == 1){                 
                hours += 1;
                Timer.setHours(hours);
                flag = 0;
            }
            // Retraso para evitar un ciclo constante
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }           
    }
}