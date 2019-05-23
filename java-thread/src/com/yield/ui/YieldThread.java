package com.yield.ui;

public class YieldThread {

    static class YieldTest implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                Thread.yield();
                System.out.println("线程 Id: " + Thread.currentThread().getId() + " --i: " + i);
            }
        }
    }

    public static void main(String[] args) {
        YieldTest yt = new YieldTest();
        new Thread(yt).start();
        new Thread(yt).start();
    }

}
