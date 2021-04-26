package com.censusanalyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestIndianStatesCensusAnalyser {

    private static final String ORIGINAL_FILE_PATH = "C:\\Users\\dinnu\\FellowhShipProblems\\CenusAnalyser\\src\\main\\resources\\india-districts-census-2011.csv";

    @Test
    public void givenCorrect() {
        try {
            IndianStatesCensusAnalyser indianStatesCensusAnalyser = new IndianStatesCensusAnalyser();
            int numOfRecords = indianStatesCensusAnalyser.loadIndianStatesCensusData(ORIGINAL_FILE_PATH);
            Assertions.assertEquals(640,numOfRecords);
            System.out.println("Number of Records : " +numOfRecords);
        } catch(CensusAnalyserException e) {
         e.printStackTrace();
        }
    }
}
