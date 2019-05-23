package com.family.biz;

import com.family.entity.Wife;

public class WifeThread implements Runnable {
    private Wife wife;

    public WifeThread(Wife wife) {
        this.wife = wife;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wife.shopping(8);
        }
    }
}
