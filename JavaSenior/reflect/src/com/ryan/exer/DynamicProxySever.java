package com.ryan.exer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author RyanL
 * @description  动态代理
 * @create 2022/7/28
 */
public class DynamicProxySever {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human instance = (Human) ProxySever.getProxyInstance(superMan);
        System.out.println(instance.getBelief());
        instance.eat("麻辣烫");

        System.out.println("****************");

        Nike nike = new Nike();
        ClotheFactory factory = (ClotheFactory) ProxySever.getProxyInstance(nike);
        factory.produceClothe();
    }
}

//被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

//创建动态代理
class ProxySever {
    //获取代理类实例
    public static Object getProxyInstance(Object obj) {

        MyInvocationHandler handler = new MyInvocationHandler(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}


class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}

