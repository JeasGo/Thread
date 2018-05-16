package com.jeas.demo;

public class DaemonThread {
    public static class UserThread extends  Thread{
        public UserThread(String name){
            super(name);
        }

        @Override
        public void run() {
            try {
                while (!isInterrupted()){
                    System.out.println(Thread.currentThread().getName()+"  am extends Thread");
                    System.out.println(Thread.currentThread().getName()+"interrupt flag is "+ isInterrupted());
                }
            } finally {
                System.out.println("我执行了");
            }
            System.out.println(Thread.currentThread().getName()+"interrupt flag is "+ isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new UserThread("endThread");
        thread.setDaemon(true);
        thread.start();
        Thread.sleep( 100L);
        thread.interrupt();
    }
}
