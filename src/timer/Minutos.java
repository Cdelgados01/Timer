
package timer;

public class Minutos extends Thread {
    
    private volatile boolean running = true;

    public void resetThread() {
        Timer.setmin(0);
    }
    
    static int flag;

    public Minutos(int flag) {
        this.flag = flag;          
    }

    @Override
    public void run() {
        int min = 0;
        while (true) {                
            System.out.println("Cambio efectuado " + flag);            
            if (flag == 1) {                 
                min++;
                Timer.setmin(min);
                System.out.println("Incremento min....");
                flag = 0;

                if (min >= 59) {
                    min = 0; 
                    Horas.flag = 1; 
                }
            }                  
        }           
    }
}
