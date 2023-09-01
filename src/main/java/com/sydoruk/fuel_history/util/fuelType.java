package com.sydoruk.fuel_history.util;

import java.util.Random;

public enum fuelType {
    A95("А95"), A95Plus("А95 покращений"), A92("А92"), Diesel("Дизель"), DieselPlus("Дизель покращений");
    
    private String type;
    private fuelType(final String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }

    public static fuelType getRandomStation(){
        Random random = new Random();
        fuelType fuels[] = fuelType.values();
        int rnd = random.nextInt(0, fuels.length);
        return fuels[rnd];
    }
}
