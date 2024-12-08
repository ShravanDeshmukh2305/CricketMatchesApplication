package com.example.CricketMatchesApplication.dto;


import lombok.Data;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;


@Data
public class CricketMatchDto {

    @JsonProperty("data")
    private List<MatchData> matchDataDetails;
}
