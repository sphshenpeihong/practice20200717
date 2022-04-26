package com.sph.practice.test.innerclass;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
class Father {
    public int str() {
        return 2;
    }
}

class Mother {
    public int can() {
        return 2;
    }
}

class Son {
    public int get() {
        return new Father_1().str();
    }

    public int getcan() {
        return new Mother_1().can();
    }

    class Father_1 extends Father {
        public int str() {
            return super.str() + 1;
        }
    }

    class Mother_1 extends Mother {
        public int can() {
            return super.can() - 2;
        }
    }
}

public class Outer {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.get());
        System.out.println(son.getcan());
        System.out.println(son.new Father_1().str());
        System.out.println(son.new Mother_1().can());
        /*
            3
            0
            3
            0
         */
    }
}