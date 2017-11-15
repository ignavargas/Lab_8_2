/**
 * Created by IgnacioV on 13/11/2017.
 */
import java.util.concurrent.Semaphore;
import java.lang.Runnable;

public class Barrier implements Runnable{

    Semaphore counter;
    Semaphore barrier;
    private volatile int hijos;
    private volatile int count;

    public Barrier(int numhijos){

        hijos = numhijos;
        count = 0;
        counter = new Semaphore(1,true);
        barrier = new Semaphore(0, true);
    }

    public void run(){

        try {
            counter.acquire();
        }catch (InterruptedException IE){
            System.out.println("ERORRO in conter acquire-1");
        }

        count++;
        System.out.println("El hilo entrante es numero: " + count);
        if(count == hijos){
            barrier.release();
        }

        counter.release();

        try {
            System.out.println("Estoy atrapado");
            barrier.acquire();
        }catch (InterruptedException IE){
            System.out.println("ERROR barrier acquire-1");
        }

        barrier.release();
        System.out.println("soy libre!!!");
    }
}
