package com.example.CricketMatchesApplication.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;



@Getter
@Configuration
public class CricketMatchConfig {


    @Value("${cuvora.host}")
    private String cuvoraHost;

    @Value("${cuvora.partner.CricketmatchData.url}")
    private String cuvoraPartnerCricketmatchDataurl;
}
