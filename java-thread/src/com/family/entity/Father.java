package com.family.entity;

public class Father {
    private String name;
    private Family family;

    public Father(String name, Family family) {
        this.name = name;
        this.family = family;
        this.family.setFather(this);
    }

    public void earnMoney(double money) {
        synchronized (this.family) {
            double leftMoney = this.family.getAccount();
            System.out.println("Father 挣钱前, 当前账户余额: " + leftMoney);
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            leftMoney = this.family.getAccount() + money;
            this.family.setAccount(leftMoney);
            System.out.println("Father 挣钱后, 当前账户余额: " + leftMoney);
        }
    }

    public String getName() {
        return name;
    }

    public Family getFamily() {
        return family;
    }
}
