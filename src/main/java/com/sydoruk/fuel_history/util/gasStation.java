package com.sydoruk.fuel_history.util;

import java.util.Random;

public enum gasStation {
    OKKO("Окко"), WOG("WOG"), 
    AVIAS("АВІАС"), UkrNafta("УкрНафта"), 
    ZNP("Запоріжнафтопродукт");

    private String nameStation;

    public static gasStation getRandomStation(){
        Random random = new Random();
        gasStation stations[] = gasStation.values();
        int rnd = random.nextInt(0, stations.length);
        return stations[rnd];
    }

    public String getNameStation(){
        return nameStation;
    }

    private gasStation(String nameStation){
        this.nameStation = nameStation;
    }   
}
