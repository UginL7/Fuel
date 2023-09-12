package com.sydoruk.fuel_history.util;

import java.util.Random;

public enum FuelType {
    A95("А95"), A95Plus("А95 покращений"), A92("А92"), Diesel("Дизель"), DieselPlus("Дизель покращений");
    
    private String type;
    private FuelType(final String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }

    public static FuelType getRandomStation(){
        Random random = new Random();
        FuelType fuels[] = FuelType.values();
        int rnd = random.nextInt(0, fuels.length);
        return fuels[rnd];
    }
}
