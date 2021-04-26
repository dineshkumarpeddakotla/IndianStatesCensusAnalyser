package com.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class IndianStatesCensusAnalyser {

    /**
     *
     * @param csvFilePath  *.csv File Path
     * @return Count of Indian Census Data
     * @throws CensusAnalyserException Custom Exception is Thrown of CENSUS_FILE_PROBLEM, UNABLE_TO_PARSE
     */
    public int loadIndianStatesCensusData(String csvFilePath) throws CensusAnalyserException {
        try(Reader reader = Files.newBufferedReader(Paths .get(csvFilePath))) {
            CsvToBeanBuilder<CensusAnalyser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CensusAnalyser.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CensusAnalyser> csvToBean = csvToBeanBuilder.build();
            Iterator<CensusAnalyser> censusCSVIterator = csvToBean.iterator();
            Iterable<CensusAnalyser> csvIterable = () -> censusCSVIterator;
            return (int) StreamSupport.stream(csvIterable.spliterator(),false).count();
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (IllegalStateException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }
    }

    public static void main(String[] args) throws CensusAnalyserException {
        System.out.println("Welcome to Indian States Census Analyser");
        IndianStatesCensusAnalyser indianStatesCensusAnalyser = new IndianStatesCensusAnalyser();
        int count = indianStatesCensusAnalyser.loadIndianStatesCensusData("C:\\Users\\dinnu\\FellowhShipProblems\\CenusAnalyser\\src\\main\\resources\\india-districts-census-2011.csv");
        System.out.println("Indian States Census Data Count = " +count);
    }
}
