/**
 * Created by IgnacioV on 08/11/2017.
 */
public class Main {

    public static void main(String [ ] args){

        SharedMemory memory = new SharedMemory();

        Thread t1 = new Thread(new ThreadRunner(0, memory));
        Thread t2 = new Thread(new ThreadRunner(1, memory));
        Thread t3 = new Thread(new ThreadRunner(0, memory));
        Thread t4 = new Thread(new ThreadRunner(1, memory));
        Thread t5 = new Thread(new ThreadRunner(1, memory));

        Thread t6 = new Thread(new ThreadRunner(0, memory));
        Thread t7 = new Thread(new ThreadRunner(0, memory));
        Thread t8 = new Thread(new ThreadRunner(0, memory));
        Thread t9 = new Thread(new ThreadRunner(1, memory));
        Thread t10 = new Thread(new ThreadRunner(1, memory));

        Thread t11 = new Thread(new ThreadRunner(1, memory));
        Thread t12 = new Thread(new ThreadRunner(1, memory));
        Thread t13 = new Thread(new ThreadRunner(0, memory));
        Thread t14 = new Thread(new ThreadRunner(1, memory));
        Thread t15 = new Thread(new ThreadRunner(1, memory));


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();


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

        try{
            t6.join();
        }catch(InterruptedException IE){
            System.out.println("ERROR IN WRITERS");
            IE.getMessage();
        }

        try{
            t7.join();
        }catch (InterruptedException IE){

            IE.getMessage();
        }

        try{
            t8.join();
        }catch(InterruptedException IE){
            System.out.println("ERROR IN WRITERS");
            IE.getMessage();
        }

        try{
            t9.join();
        }catch (InterruptedException IE){

            IE.getMessage();
        }

        try{
            t10.join();
        }catch (InterruptedException IE){

            IE.getMessage();
        }

        try{
            t11.join();
        }catch(InterruptedException IE){
            System.out.println("ERROR IN WRITERS");
            IE.getMessage();
        }

        try{
            t12.join();
        }catch (InterruptedException IE){

            IE.getMessage();
        }

        try{
            t13.join();
        }catch(InterruptedException IE){
            System.out.println("ERROR IN WRITERS");
            IE.getMessage();
        }

        try{
            t14.join();
        }catch (InterruptedException IE){

            IE.getMessage();
        }

        try{
            t15.join();
        }catch (InterruptedException IE){

            IE.getMessage();
        }


    }
}
