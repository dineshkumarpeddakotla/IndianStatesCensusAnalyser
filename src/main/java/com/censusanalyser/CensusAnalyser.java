package com.censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CensusAnalyser {
    @CsvBindByName(column = "State name")
    private String stateName;
    private String population;
    @CsvBindByName(column = "Male_Literate")
    private double maleLiterate;
    @CsvBindByName(column = "Female_Literate")
    private double femaleLiterate;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public double getMaleLiterate() {
        return maleLiterate;
    }

    public void setMaleLiterate(double maleLiterate) {
        this.maleLiterate = maleLiterate;
    }

    public double getFemaleLiterate() {
        return femaleLiterate;
    }

    public void setFemaleLiterate(double femaleLiterate) {
        this.femaleLiterate = femaleLiterate;
    }

    @Override
    public String toString() {
        return "CensusAnalyser{" +
                "stateName='" + stateName + '\'' +
                ", population='" + population + '\'' +
                ", maleLiterate=" + maleLiterate +
                ", femaleLiterate=" + femaleLiterate +
                '}';
    }
}
