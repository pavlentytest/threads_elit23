public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 1 поток - [+]
        // 2 поток - [-]
        MyThread thread1 = new MyThread("+");
        thread1.start();
        MyThread thread2 = new MyThread("-");
        thread2.start();
        Thread.sleep(3000);
        thread1.flag = false;
        thread1.join(); // присоед и ждет завершения потока
        printMessage("1 thread stopped!");
    }

    public static final Object KEY = new Object();
    public static void printMessage(String message) {
        synchronized(KEY) {
            try {
                System.out.print("[");
                Thread.sleep(500);
                System.out.print(message);
                Thread.sleep(500);
                System.out.print("]");
               // KEY.notify();
               // KEY.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class MyThread extends Thread {
    private String message;
    public boolean flag = true;
    MyThread(String m) {
        message = m;
    }
    @Override
    public void run() {
        while(flag) {
            Main.printMessage(message);
        }
    }
}







class Test extends Thread {
    @Override
    public void run() {
        // логика
    }
}
class Test2 implements Runnable {

    @Override
    public void run() {

    }
}