package ch14.sec06.exam02;

public class WorkObject {
    public synchronized void methodA() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        notify();
        try {
            wait();
        } catch (InterruptedException e) {}
    }

    public synchronized void methodB() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        notify();
        try {
            wait();
        } catch (InterruptedException e) {}
    }
}
