package com.sydoruk.fuel_history.util;

import java.util.Random;

import com.sydoruk.fuel_history.model.paymentReceipt;

public class generatePaymentReceipt {
        public static paymentReceipt newInstance(){
        Random rnd = new Random();
        String station = gasStation.getRandomStation().toString();
        String fuel = fuelType.getRandomStation().toString();
        float price = (float) (rnd.nextFloat() * (57.0 - 50.0) + 50.0);
        float liter = (float) (rnd.nextFloat() * (47.0 - 1.0) + 1.0);

        return new paymentReceipt(null, station, fuel, price, liter);
    }
}
