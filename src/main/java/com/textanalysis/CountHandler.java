package com.textanalysis;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class CountHandler implements HttpHandler {

    HttpExchange exchange;

    @Override
    public void handle(HttpExchange exchange) {
        this.exchange = exchange;
        if ("POST".equals(exchange.getRequestMethod())) {
            post();
        } else {
            otherHttpMethods();
        }
    }

    private void post() {
        final HttpExchange finalExchange = exchange;
        try (finalExchange) {
            String requestBody = new String(exchange.getRequestBody().readAllBytes());
            WordsHandler words = WordsHandler.useString(requestBody);
            String responseBody = words.getStatsAsJson();
            System.out.println(responseBody);
            finalExchange.sendResponseHeaders(200, responseBody.getBytes().length);
            OutputStream out = exchange.getResponseBody();
            out.write(responseBody.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void otherHttpMethods() {
        final HttpExchange finalExchange = exchange;
        String responseBody = "{\"message\":\"Only POST method is supported\"}";

        try (finalExchange) {
            finalExchange.sendResponseHeaders(200, responseBody.getBytes().length);
            OutputStream out = exchange.getResponseBody();
            out.write(responseBody.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
