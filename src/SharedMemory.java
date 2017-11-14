
import java.util.*;
/**
 * Created by IgnacioV on 08/11/2017.
 */
public class SharedMemory {


    //variables globales
    Random random = new Random();
    private volatile List<Integer> sh_mem;//Buffer o lista que será compartida por todos los Threads
    private volatile boolean flagEscritor;//Flag para indicar que un escritor es usando la lista
    private volatile int contadorLectores;//contador para que el escritor sepa si la lista esta desocupada

    /*
    * Controlador de la clase Shared Memory
    * Se instancian la mayoria de variables globales
    * Se inicializa la lista, el flag y el contador
    * */
    public SharedMemory(){

        sh_mem = Collections.synchronizedList(new ArrayList());
        flagEscritor = false;
        contadorLectores = 0;
    }

    /*
    * Metodo setContador:
    * Se utilza para acceder y aumentar a la variable contadorLectores
    * */
    public void setContadorIn(){

        this.contadorLectores++;
    }

    /*
    * Metodo setContador:
    * Se utilza para acceder y disminuir a la variable contadorLectores
    * */
    public void setContadorOut(){

        this.contadorLectores--;
    }

    /*
    * Metodo getContador:
    * Se utilza para acceder al valor de la variable contadorLectores
    * returna un valor entero con la cantidad de Threads
    * "leyendo" la lista.
    * */
    public int getContador(){

        return contadorLectores;

    }

    /*
    * Metodo llamado por hilos de tipo Escritor.
    * "Escribe" un numero entero aleatorio al final de la lista
    * */
    public void WriteValue(){

        System.out.println(" ...");
        int n = random.nextInt(101);//genera un numero aleatorio entre 0 y 100
        sh_mem.add(n); //lo agrega a la lista
        System.out.println("el numero escrito es: ");
        System.out.println(n);
    }

    /*
    * Metodo llamado por hilos de tipo Lector.
    * "Lee" un numero aleatorio de la lista
    * */
    public Integer ReadValue(){

        System.out.println(" ...");
        int i = random.nextInt(sh_mem.size());// genera un numero aleatorio entre 0 y el total de elementos en la lista
        return sh_mem.get(i);//extrae el valor por medio del indice
    }
}
