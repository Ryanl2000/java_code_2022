package com.ryan.exer;

/**
 * @author RyanL
 * @description
 * @create 2022/7/28
 */
public class StaticProxySever {
    public static void main(String[] args) {
        Nike nike = new Nike();
        ProxyClotheFactory p = new ProxyClotheFactory(nike);
        p.produceClothe();
    }
}

//代理类
class ProxyClotheFactory implements ClotheFactory {

    private ClotheFactory factory;

    public ProxyClotheFactory(ClotheFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceClothe() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceClothe();
        System.out.println("成功");
    }
}

//被代理类
class Nike implements ClotheFactory {

    @Override
    public void produceClothe() {
        System.out.println("生产Nike运动服");
    }

}

