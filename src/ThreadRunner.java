/**
 * Created by IgnacioV on 09/11/2017.
 */
import java.lang.Runnable;
import java.util.concurrent.*;

public class ThreadRunner implements Runnable{

    Semaphore sw = new Semaphore(1, true);//semaforo de escritores(writer)
    Semaphore sr = new Semaphore(1, true);//semaforo de lectores(reader)

    //variables globales
    SharedMemory sh; // una instancia de objeto SharedMemory sin definir
    int type;

    /*
    * Constructor de la Clase Thread Runner
    * inicializa la lista con el paramatro sh, correspondinete a un objeto
    * Shared Mmemory dado por el caller y recibe un tipo para diferenciar entre
    * Escritor o Lector, su tipo se identifica por 0 y 1 respectivamente
    * */
    public ThreadRunner(int type_value, SharedMemory sh){

        this.sh = sh;
        this.type = type_value;
    }

    /*
    * Metodo Run de Runnable,
    * este contiene el codigo correspondiente a ejecutar por los Threads
    * */
    public void run(){

        if(type == 0) {// Tipo Escritor (Writer)

            System.out.println("---Thread from Writers---");
            try {
                sw.acquire(); //se le pide al semaforo de escritores que otorgue la llave
            } catch (InterruptedException IE) {
                IE.getCause();
                System.exit(1);
            }

            while(sh.getContador() > 0);//si se entregó la llave a un escritor, se revisa si la lista esta desocupada
                                        //y espera hasta que esta lo esté.
            sh.setFlag(true);// una vez estando la lista desocupada se activa el flag de escritura
            System.out.println("Se esta escribiendo...");
            sh.WriteValue();//se escribe en la Lista
            System.out.println("Se termino de escribir!");
            sh.setFlag(false);// se apaga el flag de escritura

            sw.release();//se devuelve la llave y termina
        }else{
            if (type == 1){//Tipo Lector (Reader)
                System.out.println("---Thread from Readers---");
                int x = 0;// se usa para imprimir el numero leido unicamente

                while(sh.getFlag());//Se revisa si se está escribiendo en la lista
                try {
                    sr.acquire();//se pide la llava
                }catch(InterruptedException IE){
                    IE.getCause();
                    System.exit(1);
                }
                sh.setContadorIn();// se Aumenta el contador de Lectores en la lista
               System.out.println("Se esta leyendo...");
                x = sh.ReadValue(); // se lee la Lista
                System.out.print("\nel numero es: ");
                System.out.print(x);
                System.out.println("\nSe termino de leer!");

                sh.setContadorOut();

                sr.release();//se devuelve la llav ey termina

            }else {

                System.out.println("ERROR UNKNOWN...");
                System.exit(2);
            }
        }
    }

}
