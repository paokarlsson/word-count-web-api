package com.textanalysis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WordsHandler {

    Map<String, Integer> words;

    public static WordsHandler useString(String text) {
        return new WordsHandler(text);
    }

    private WordsHandler(String text){
        this.words = createHashMap(text);
    }

    private Map<String, Integer> createHashMap(String text) {
        Map<String, Integer> words = new HashMap<>();

        Arrays.stream(text.split(" "))
                .map(word -> word
                        .replaceAll("[.,;:_\n\r]", "")
                        .trim())
                .filter(word -> !word.isBlank() && !word.isEmpty())
                .forEach(word -> {
                    if (words.containsKey(word)) {
                        int number = words.get(word) + 1;
                        words.put(word, number);
                    } else {
                        words.put(word, 1);
                    }
                });

        return words;
    }

    public String getStatsAsJson() {
        return getStatsAsJson(10);
    }

    public String getStatsAsJson(int limit) {

        String responseMessage;
        if (!words.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");

            Stream<Map.Entry<String, Integer>> stream = words.entrySet().stream()
                    .sorted((w1, w2) -> w2.getValue() - w1.getValue());

            if (limit > 0) stream = stream.limit(limit);
            stream.forEach(word -> {
                sb
                        .append("\"")
                        .append(word.getKey())
                        .append("\":")
                        .append(word.getValue())
                        .append(",");
            });

            // Remove last ,
            sb.setLength(sb.length() - 1);

            sb.append("}");
            responseMessage = sb.toString();
        } else {
            responseMessage = "{\"message\":\"Nothing to return\"}";
        }
        return responseMessage;
    }
}
