package com.basic.test;

public class ProxySeverTest {

    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.surface();
    }
}

interface Network {

    void surface();

}

class Server implements Network {

    @Override
    public void surface() {
        System.out.println("真实服务器");
    }

}

class ProxyServer implements Network {

    private Network work;

    public ProxyServer(Network work) {
        this.work = work;
    }

    @Override
    public void surface() {
        check();

        work.surface();
    }

    public void check() {
        System.out.println("检查");
    }
}
