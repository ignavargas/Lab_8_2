/**
 * Created by IgnacioV on 08/11/2017.
 */
public class Main {

    public static void main(String [ ] args){


        Thread t1 = new Thread(new ThreadRunner(0));
        Thread t2 = new Thread(new ThreadRunner(1));
        Thread t3 = new Thread(new ThreadRunner(0));
        Thread t4 = new Thread(new ThreadRunner(1));
        Thread t5 = new Thread(new ThreadRunner(1));


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


        try{
        t1.join();
        }catch(InterruptedException IE){
            System.out.println("ERROR IN WRITERS");
            IE.getMessage();
        }

        try{
        t2.join();
        }catch (InterruptedException IE){

            IE.getMessage();
        }

        try{
            t3.join();
        }catch(InterruptedException IE){
            System.out.println("ERROR IN WRITERS");
            IE.getMessage();
        }

        try{
            t4.join();
        }catch (InterruptedException IE){

            IE.getMessage();
        }

        try{
            t5.join();
        }catch (InterruptedException IE){

            IE.getMessage();
        }


    }
}
