
package timer;

import java.util.logging.Level;
import java.util.logging.Logger;


public class segundos extends Thread{
    
    private volatile boolean running = true;

    public void pauseThread() {
        running = false;
    }
    
    public void resumeThread() {
        running = true;
        synchronized (this) {
            notify();
        }
    }

    public void resetThread() {
        running = false;
        Timer.setsec(0);
    }

        @Override
        public void run(){
            for (int i = 0; i < 60; i++) {    
                
            if (!running) {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(segundos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
                Timer.setsec(i);
                try {
                    segundos.sleep(1000);
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(segundos.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (i==59){
                    
                    i = 0;
                    Minutos.flag = 1;
                }           
            }          
        }    
}
