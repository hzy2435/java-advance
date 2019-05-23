package com.family.ui;

import com.family.biz.FatherThread;
import com.family.biz.SonThread;
import com.family.biz.WifeThread;
import com.family.entity.Family;
import com.family.entity.Father;
import com.family.entity.Son;
import com.family.entity.Wife;

public class FamilyPay {
    public static void main(String[] args) {
        Family family = new Family();
        Father father = new Father("f", family);
        Wife wife = new Wife("w", family);
        Son son = new Son("s", family);

        new Thread(new FatherThread(father)).start();
        new Thread(new WifeThread(wife)).start();
        new Thread(new SonThread(son)).start();
    }
}
