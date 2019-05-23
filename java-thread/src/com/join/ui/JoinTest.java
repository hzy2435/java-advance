package com.join.ui;

public class JoinTest {
    static class SleepThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println("线程 " + Thread.currentThread().getId() + " ---> i: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("SleepThread " + Thread.currentThread().getId() + " is end.");
        }
    }

    static class JoinThread extends Thread {
        private SleepThread sleepThread;

        public JoinThread(SleepThread sleepThread) {
            this.sleepThread = sleepThread;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println("线程 " + Thread.currentThread().getId() + " ---> i: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 当 i = 5 时, SleepThread 加入, JoinThread 等到 SleepThread 运行结束才会继续运行.
                if(i == 5) {
                    try {
                        System.out.println("i == 5, 执行 join 方法, JoinThread 开始挂起");
                        this.sleepThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("JoinThread " + Thread.currentThread().getId() + " is end.");
        }
    }

    public static void main(String[] args) {
        SleepThread sleepThread = new SleepThread();
        JoinThread joinThread = new JoinThread(sleepThread);

        sleepThread.start();
        joinThread.start();
    }
}
