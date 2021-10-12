package com.textanalysis;

import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServer {

    private final com.sun.net.httpserver.HttpServer server;

    public static HttpServer createServerUsePort(int port) throws IOException {
        return new HttpServer(port);
    }

    public HttpServer(int port) throws IOException {
        this.server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(port),0);
    }

    public void addEndPoint(String path, HttpHandler handler) throws IllegalArgumentException, NullPointerException {
        server.createContext(path,handler);
    }

    public void start() {
        server.start();
    }
}
