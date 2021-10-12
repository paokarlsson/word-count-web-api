package com.textanalysis;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            TextAnalysisHttpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
