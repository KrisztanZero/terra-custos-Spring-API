package com.terracustosapi.terracustos.utils;

public class TokenExtractor {
    public static String extractSessionId(String authorizationHeader) {
        String[] headerParts = authorizationHeader.split(" ");
        if (headerParts.length == 2) {
            return headerParts[1];
        } else {
            throw new IllegalArgumentException("Invalid Authorization header format");
        }
    }
}
