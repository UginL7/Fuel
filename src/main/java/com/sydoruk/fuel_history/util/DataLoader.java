package com.sydoruk.fuel_history.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sydoruk.fuel_history.controller.PaymentReceiptRepo;
import com.sydoruk.fuel_history.model.PaymentReceipt;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataLoader {
    private final PaymentReceiptRepo paymentRepo;

/*     public DataLoader(final PaymentReceiptRepo paymentReceiptRepo){
        paymentRepo = paymentReceiptRepo;
    }*/

    @PostConstruct
    private void loadData(){
        paymentRepo.deleteAll();
        PaymentReceipt p1 = GeneratePaymentReceipt.newInstance();
        PaymentReceipt p2 = GeneratePaymentReceipt.newInstance();
        PaymentReceipt p3 = GeneratePaymentReceipt.newInstance();
        PaymentReceipt p4 = GeneratePaymentReceipt.newInstance();

        this.paymentRepo.saveAll(List.of(p1,p2,p3,p4));
    }
}
