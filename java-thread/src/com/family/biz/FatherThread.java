package com.family.biz;

import com.family.entity.Father;

public class FatherThread implements Runnable {

    private Father father;

    public FatherThread(Father father) {
        this.father = father;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            father.earnMoney(10);
        }
    }
}
