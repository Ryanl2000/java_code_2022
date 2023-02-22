package com.basic.test;

public class MyException extends Exception {

    static final long serialVersionUID = -7034897190768766939L; // 序列号

    public MyException() {

    }

    public MyException(String message) {
        super(message);
    }


}
