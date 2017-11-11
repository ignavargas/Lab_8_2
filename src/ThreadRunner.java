/**
 * Created by IgnacioV on 09/11/2017.
 */
import java.lang.Runnable;
import java.util.concurrent.*;

public class ThreadRunner implements Runnable{

    Semaphore sw = new Semaphore(1, true);
    Semaphore sr = new Semaphore(1, true);

    SharedMemory sh = new SharedMemory();
    int type;

    public ThreadRunner(int type_value){

        this.type = type_value;
    }

    public void run(){

        if(type == 0) {

            System.out.println("Thread from Writers");
            try {
                sw.acquire();
            } catch (InterruptedException IE) {
                IE.getCause();
                System.exit(1);
            }

            while(sh.getContador() > 0);
            sh.setFlag(true);
            System.out.println("Se esta escribiendo...");
            sh.WriteValue();
            System.out.println("Se termino de escribir!");
            sh.setFlag(false);

            sw.release();
        }else{
            if (type == 1){
                System.out.println("Thread from Readers");
                int x = 0;
                try {
                    sr.acquire();
                }catch(InterruptedException IE){
                    IE.getCause();
                    System.exit(1);
                }

                while(sh.getFlag());
                sh.setContadorIn();
                System.out.println("Se esta leyendo...");
                x = sh.ReadValue();
                System.out.print("\nel numero es: ");
                System.out.print(x);
                System.out.println("Se termino de leer!");
                sh.setContadorOut();
                sr.release();
            }else {

                System.out.println("ERROR UNKNOWN...");
                System.exit(2);
            }
        }
    }

}
