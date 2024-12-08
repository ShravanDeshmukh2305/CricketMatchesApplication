package com.example.CricketMatchesApplication.util;

public class CricketUtils {

    public static int parseScore(String score) {
        if (score == null || score.trim().isEmpty()) {
            return 0;
        }
        String[] scoreParts = score.split("/");
        try {
            return Integer.parseInt(scoreParts[0]);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
