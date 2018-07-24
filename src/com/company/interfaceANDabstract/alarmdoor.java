package com.company.interfaceANDabstract;

import com.company.interfaceANDabstract.abstractdoor;

public class alarmdoor extends abstractdoor {
    @Override
    public void open() {
        System.out.println("open");
    }

    @Override
    public void close() {
        System.out.println("close");
    }

    @Override
    public void alarm() {
        System.out.println("alarm");
    }
}
