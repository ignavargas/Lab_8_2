
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * Created by IgnacioV on 08/11/2017.
 */
public class SharedMemory {


    Random random = new Random();
    private volatile CopyOnWriteArrayList<Integer>sh_mem;
    private volatile boolean flagEscritor;
    private volatile int contadorLectores;
    public SharedMemory(){

        sh_mem = new CopyOnWriteArrayList<Integer>();
        flagEscritor = false;
        contadorLectores = 0;
    }

    public void setFlag(boolean flagEscritor){
        this.flagEscritor = flagEscritor;

    }

    public void setContadorIn(){

        this.contadorLectores++;
    }

    public void setContadorOut(){

        this.contadorLectores--;
    }

    public boolean getFlag(){

        return flagEscritor;
    }

    public int getContador(){

        return contadorLectores;
    }

    public void WriteValue(){

        System.out.println(" ...");
        int n = random.nextInt(101);
        sh_mem.add(n);
    }

    public Integer ReadValue(){

        System.out.println(" ...");
        int i = random.nextInt(2);
        return sh_mem.get(i);
    }
}
