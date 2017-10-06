package monitores;

/**
 *
 * @author Bron
 */
public class Gestion {

    /**
     * Esta clase es la que gestiona los botones de reanudar y parar.
     */
    public Gestion() {
    }
    public boolean pausar;

    public synchronized void reanudar() {
        /*
         * Si pulsamos el botón reanudar pondremos pausar a falso y el programa
         * continuará, notificamos a todos los hilos esperando que ya pueden
         * seguir trabajando.
         */

        pausar = false;
        notifyAll();
    }

    public synchronized void detener() {

        /**
         * Si pulsamos el botón detener, pondremos pausar a true y los hilos
         * harán wait.
         */
        
        pausar = true;
    }

    public synchronized void parar() {

        /*
         * Analizamos la condicion de pausar. Si es true hacemos un wait y
         * esperamos, si es false no hacemos nada ni ponemos ningún mensaje.
         */

        if (pausar) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("" + e);
            }
        }
    }
}
