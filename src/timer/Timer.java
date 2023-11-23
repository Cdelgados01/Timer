package timer;

public class Timer {
    static reloj _reloj = new reloj();
    static segundos hiloSegundos;
    static Minutos hiloMinutos;
    static Horas hiloHoras;

    public static void main(String[] args) {
        _reloj.setVisible(true);

        hiloSegundos = new segundos();
        hiloMinutos = new Minutos(0);
        hiloHoras = new Horas(0);

        hiloSegundos.start();
        hiloMinutos.start();
        hiloHoras.start();
    }

    public static void setsec(int _num) {
        _reloj.setSec(_num);
    }

    public static void setmin(int _min) {
        _reloj.setMin(_min);
    }

    public static void setHours(int _hours) {
        _reloj.setHour(_hours);
    }
    
    public static void pauseTimer() {
        hiloSegundos.pauseThread();
    }    
    
    public static void resumeTimer() {
        hiloSegundos.resumeThread();
    }

    public static void resetTimer() {
        hiloSegundos.resetThread();
        hiloMinutos.resetThread();
        hiloHoras.resetThread();
        
    }
    
    
}
