package com.example.CricketMatchesApplication.service;

import com.example.CricketMatchesApplication.client.CricketScoreCardClient;
import com.example.CricketMatchesApplication.dto.CricketMatchResponseDto;
import com.example.CricketMatchesApplication.dto.MatchData;
import com.example.CricketMatchesApplication.util.CricketUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class CricketMatchService {

    private CricketScoreCardClient cricketScoreCardClient;

    public CricketMatchService(CricketScoreCardClient cricketScoreCardClient) {
        this.cricketScoreCardClient = cricketScoreCardClient;
    }

    public CricketMatchResponseDto getCricketMatchStats() throws IOException {

        List<MatchData>matchDataDetails = cricketScoreCardClient.fetchCricketScoreCard();
        int highestScore = 0;
        String highestScoringTeam = "";
        int matchesWith300Plus = 0;

        for (MatchData matchData : matchDataDetails) {

            int t1Score = CricketUtils.parseScore( matchData.getT1s());
            int t2Score = CricketUtils.parseScore(matchData.getT2s());


            if (t1Score > highestScore) {
                highestScore = t1Score;
                highestScoringTeam = matchData.getT1();
            }
            if (t2Score > highestScore) {
                highestScore = t2Score;
                highestScoringTeam = matchData.getT2();
            }


            if (t1Score + t2Score > 300) {
                matchesWith300Plus++;
            }
        }

        log.info("Highest Score: {}, Team: {}", highestScore, highestScoringTeam);
        log.info("Total Matches with 300+ Score: {}", matchesWith300Plus);

        CricketMatchResponseDto responseDto = new CricketMatchResponseDto();
        responseDto.setHighestScore(highestScore);
        responseDto.setTeamName(highestScoringTeam);
        responseDto.setTotalMatchesWith300Plus(matchesWith300Plus);

        return responseDto;
    }
}