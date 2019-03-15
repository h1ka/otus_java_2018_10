package ru.otus.SequenceOfNumbers;

public class Sequence {
    private int last = 0;
    private  void action(int beginValue, int endValue){
        int i = beginValue;
        while (true){
        synchronized (this){
            while (i<endValue){
            if (last == i) {
                wait(this);
                last++;
            } else {
                System.out.println(Thread.currentThread().getName() + " " + i++);
                last = i;
                sleep(1_000);
                notifyAll();
            }
        }
            while (i>beginValue){
                if (last == i) {
                    wait(this);
                    last--;
                } else {
                    System.out.println(Thread.currentThread().getName() + " " + i--);
                    last = i;
                    sleep(1_000);
                    notifyAll();
                }
            }
        }
        }
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        new Thread(() -> sequence.action(1,10)).start();
        new Thread(() -> sequence.action(1,10)).start();
    }
    private static void wait(Object object){
        try {
            object.wait();
        } catch (InterruptedException exp){
            exp.printStackTrace();
        }
    }
    private static void sleep(long millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException exp){
            exp.printStackTrace();
        }
    }

}