package com.family.biz;

import com.family.entity.Son;

public class SonThread implements Runnable {
    private Son son;

    public SonThread(Son son) {
        this.son = son;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            son.playGame(5);
        }
    }
}
