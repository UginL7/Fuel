package com.sydoruk.fuel_history.util;

import java.util.Random;

public enum GasStation {
    OKKO("Окко"), WOG("WOG"), 
    AVIAS("АВІАС"), UkrNafta("УкрНафта"), 
    ZNP("Запоріжнафтопродукт");

    private String nameStation;

    public static GasStation getRandomStation(){
        Random random = new Random();
        GasStation stations[] = GasStation.values();
        int rnd = random.nextInt(0, stations.length);
        return stations[rnd];
    }

    public String getNameStation(){
        return nameStation;
    }

    private GasStation(String nameStation){
        this.nameStation = nameStation;
    }   
}
