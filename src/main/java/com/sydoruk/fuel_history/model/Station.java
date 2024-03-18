package com.sydoruk.fuel_history.model;

import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gas_station")
public class Station {
    
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;        
    @NonNull
    @Column(name = "gas_station", nullable = false)
    private String gasStation;

    // Звʼязок з базою типів пального - перелік назв - файл fuel.java
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    private Set<Fuel> fuelType;

}
