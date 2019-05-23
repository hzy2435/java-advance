package com.thread.biz;

import java.util.LinkedList;

public class TicketWorkerSync extends Thread {
    private LinkedList allTicket;

    public TicketWorkerSync(LinkedList allTicket) {
        this.allTicket = allTicket;
    }

    @Override
    public void run() {
        while (allTicket.size() > 0) {
            synchronized (allTicket) {
                if(allTicket.size() > 0) {
                    System.out.println("窗口" + Thread.currentThread().getId() + "准备出票");
                    allTicket.removeLast();
                    System.out.println("当前剩余" + allTicket.size() + "张票.");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
