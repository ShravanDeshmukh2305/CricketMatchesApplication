package com.example.CricketMatchesApplication.dto;


import lombok.Data;

@Data

public class CricketMatchResponseDto {

    private String teamName;
    private int highestScore;
    private int totalMatchesWith300Plus;
}
