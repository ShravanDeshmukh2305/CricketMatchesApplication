package com.example.CricketMatchesApplication.client;

import com.example.CricketMatchesApplication.config.CricketMatchConfig;
import com.example.CricketMatchesApplication.dto.CricketMatchDto;
import com.example.CricketMatchesApplication.dto.MatchData;
import com.example.CricketMatchesApplication.util.HttpCaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@Component
@Slf4j
public class CricketScoreCardClient {


    private final CricketMatchConfig cricketMatchConfig;

    @Autowired
    public CricketScoreCardClient(CricketMatchConfig cricketMatchConfig) {
        this.cricketMatchConfig = cricketMatchConfig;
    }

    public List<MatchData> fetchCricketScoreCard() throws IOException {

        log.info("Fetching cricket match data from API");

        String response = HttpCaller.get(cricketMatchConfig.getCuvoraHost()+cricketMatchConfig.getCuvoraPartnerCricketmatchDataurl(), Map.of("apiKey", "test-creds@2320" ));


        ObjectMapper objectMapper = new ObjectMapper();
        CricketMatchDto cricketMatchDto = objectMapper.readValue(response, CricketMatchDto.class);
        return cricketMatchDto.getMatchDataDetails();
    }

}
