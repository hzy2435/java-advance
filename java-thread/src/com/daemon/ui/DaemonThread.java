package com.daemon.ui;

public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
           while (true) {
               try {
                   Thread.sleep(500);
                   System.out.println("------------daemon thread.");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });

        // 设置为守护线程
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(500);
                System.out.println("main thread run with i = " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("main thread is end.");
    }
}
