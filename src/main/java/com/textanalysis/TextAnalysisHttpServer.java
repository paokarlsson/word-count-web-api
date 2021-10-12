package com.textanalysis;


import java.io.IOException;

public class TextAnalysisHttpServer {

    private static final int PORT = 5000;

    public static void start() throws IOException, IllegalArgumentException, NullPointerException {

        HttpServer server = HttpServer.createServerUsePort(PORT);
        server.addEndPoint("/count", new CountHandler());
        server.start();
    }
}
