package com.sydoruk.fuel_history.model;

//import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;

//import java.sql.Timestamp;
//#import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentReceipt{
    
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;        
    @NonNull
    private String gasStation;
    @NonNull
    private String fuelType;
    @NonNull
    private Float pricePerLiter;
    @NonNull
    private Float liters;
    @NonNull
    private String timeStamp;// = new Timestamp(System.currentTimeMillis()).toString();
    
/*     public PaymentReceipt(){}

    public PaymentReceipt(final String id, final String gasStation, final String fuelType, final Float pricePerLiter, final Float liters){      
        if(id == null || id.isEmpty()){
               this.id = UUID.randomUUID().toString();
        }else{
            this.id = id;
        }

        this.timeStamp =  new Timestamp(System.currentTimeMillis()).toString();
        this.gasStation = gasStation;
        this.fuelType = fuelType;
        this.pricePerLiter = pricePerLiter;
        this.liters = liters;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public String getTimeStamp(){
        return timeStamp;
    }

    public String getGasStation(){
        return gasStation;
    }

    public void setGasStation(String gasStation){
        this.gasStation = gasStation;
    }

    public void setFuelType( final String fuelType){
        this.fuelType = fuelType;
    }

    public String getFuelType(){
        return fuelType;
    }

    public Float getPrice(){
        return pricePerLiter;
    }

    public void setPrice(Float price){
        this.pricePerLiter = price;
    }

    public Float getLiters(){
        return liters;
    }

    public void setLiters(Float liters){
        this.liters = liters;
    }
    */
}