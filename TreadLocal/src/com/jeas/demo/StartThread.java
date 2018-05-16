package com.jeas.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class StartThread {
    /**
     *
     */
    private static  class  UserTread extends  Thread{
        @Override
        public void run() {
            super.run();
            System.out.println(Thread.currentThread().getName()+"  am extends Thread");

        }
    }
    public static class UserRunnable implements  Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"  am extends Thread");
        }
    }

    public static class UserCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName()+"  am extends Thread");
            return "Result";
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UserTread userTread = new UserTread();
        userTread.start();

        UserRunnable userRunnable = new UserRunnable();
        userRunnable.run();

        UserCallable userCallable = new UserCallable();
        FutureTask<String> futureTask = new FutureTask(userCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());



    }
}
