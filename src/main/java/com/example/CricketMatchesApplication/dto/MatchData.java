package com.example.CricketMatchesApplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchData {
    private String id;
    private String dateTimeGMT;
    private String matchType;
    private String status;
    private String ms;
    private String t1;
    private String t2;
    private String t1s;
    private String t2s;
    private String t1img;
    private String t2img;
}
