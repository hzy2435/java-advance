package com.thread.biz;

public class TicketWorker implements Runnable {

    private Integer tickets = 100;

    @Override
    public void run() {
        while(tickets > 0) {
            synchronized(tickets) {
                System.out.println("窗口" + Thread.currentThread().getId() + "正在出票...");
                tickets = tickets - 1;
                System.out.println("窗口" + Thread.currentThread().getId() + "剩余" + tickets + "张票.");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
