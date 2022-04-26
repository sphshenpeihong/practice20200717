package com.sph.practice.test.innerclass;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class SingleTon {
    private SingleTon() {}

    public static SingleTon getInstance() {
        return SingleTonHoler.INSTANCE;
    }

    private static class SingleTonHoler {
        private static SingleTon INSTANCE = new SingleTon();
    }
}
