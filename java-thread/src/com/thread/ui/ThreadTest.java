package com.thread.ui;

import com.thread.biz.TicketWorker;
import com.thread.biz.TicketWorkerSync;
import com.thread.entity.Ticket;

import java.util.LinkedList;

public class ThreadTest {
    public static void ticketBook1() {
        new Thread(new TicketWorker()).start();
        new Thread(new TicketWorker()).start();
        new Thread(new TicketWorker()).start();
    }

    /**
     * 多个线程共享 run 方法
     */
    public static void ticketBook2() {
        TicketWorker tw = new TicketWorker();
        new Thread(tw).start();
        new Thread(tw).start();
        new Thread(tw).start();
    }

    /**
     * 共享票资源, 通过竞争共享资源
     */
    public static void ticketBook3() {
        LinkedList<Ticket> tickets = new LinkedList<>();
        for (int i = 1; i <= 100; i++) {
            tickets.add(new Ticket(i));
        }

        new TicketWorkerSync(tickets).start();
        new TicketWorkerSync(tickets).start();
        new TicketWorkerSync(tickets).start();
    }

    public static void main(String[] args) {
        ThreadTest.ticketBook3();
    }
}
