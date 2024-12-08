package com.example.CricketMatchesApplication.controller;

import com.example.CricketMatchesApplication.dto.CricketMatchResponseDto;
import com.example.CricketMatchesApplication.service.CricketMatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/cricket")
@Tag(name = "Cricket Match Controller", description = "Endpoints for Cricket Match Data")
public class CricketMatchController {

    private final CricketMatchService cricketMatchService;

    @Autowired
    public CricketMatchController(CricketMatchService cricketMatchService) {
        this.cricketMatchService = cricketMatchService;
    }

    @GetMapping("/stats")
    @Operation(summary = "Get Cricket Match Stats")
    public ResponseEntity <CricketMatchResponseDto> getCricketMatchStats() {
        CricketMatchResponseDto responseDto = null;
        try {
            responseDto = cricketMatchService.getCricketMatchStats();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Highest Score : " + responseDto.getHighestScore() + " and Team Name is : " + responseDto.getTeamName());
        System.out.println("Number Of Matches with total 300 Plus Score : " + responseDto.getTotalMatchesWith300Plus());

        String message = "Highest Score : \"" + responseDto.getHighestScore() + "\" and Team Name is : \"" + responseDto.getTeamName() + "\"" +
                "\nNumber Of Matches with total 300 Plus Score : \"" + responseDto.getTotalMatchesWith300Plus() + "\"";
        System.out.println(message);
        return ResponseEntity.ok(responseDto);
    }
}
