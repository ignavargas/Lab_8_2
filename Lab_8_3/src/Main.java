public class Main {

    public static void main(String[] args) {

        Barrier barrera = new Barrier(5);
        Thread t1 = new Thread(barrera);
        Thread t2 = new Thread(barrera);
        Thread t3 = new Thread(barrera);
        Thread t4 = new Thread(barrera);
        Thread t5 = new Thread(barrera);


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
