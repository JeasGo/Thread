package com.jeas.demo;

public class EndTread {
    public static class UserThread extends  Thread{
        public UserThread(String name){
            super(name);
        }

        @Override
        public void run() {
            while (!isInterrupted()){
                System.out.println(Thread.currentThread().getName()+"  am extends Thread");
                System.out.println(Thread.currentThread().getName()+"interrupt flag is "+ isInterrupted());
            }
            System.out.println(Thread.currentThread().getName()+"interrupt flag is "+ isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new UserThread("endThread");
        thread.start();
        Thread.sleep(100L);
        thread.interrupt();
    }

}
