package com.family.entity;

public class Wife {
    private String name;
    private Family family;

    public Wife(String name, Family family) {
        this.name = name;
        this.family = family;
        this.family.setWife(this);
    }

    public void shopping(double money) {
        synchronized (this.family) {
            double leftMoney = this.family.getAccount();
            System.out.println("Wife 消费前, 账户余额为: " + leftMoney);
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(money > leftMoney) {
                System.out.println("当前账户余额不足, 请 Wife 停止消费. leftMoney: " + leftMoney);
            } else {
                leftMoney = this.getFamily().getAccount() - money;
                this.family.setAccount(leftMoney);
                System.out.println("Wife 消费后, 账户余额为: " + leftMoney);
            }
        }
    }

    public String getName() {
        return name;
    }

    public Family getFamily() {
        return family;
    }
}
