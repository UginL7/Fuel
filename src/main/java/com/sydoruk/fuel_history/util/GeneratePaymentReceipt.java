package com.sydoruk.fuel_history.util;

import java.sql.Timestamp;
import java.util.Random;

import com.sydoruk.fuel_history.model.PaymentReceipt;

public class GeneratePaymentReceipt {
        public static PaymentReceipt newInstance(){
        Random rnd = new Random();
        String station = GasStation.getRandomStation().toString();
        String fuel = FuelType.getRandomStation().toString();
        float price = (float) (rnd.nextFloat() * (57.0 - 50.0) + 50.0);
        float liter = (float) (rnd.nextFloat() * (47.0 - 1.0) + 1.0);

        return new PaymentReceipt(null, station, fuel, price, liter, new Timestamp(System.currentTimeMillis()).toString());
    }
}
